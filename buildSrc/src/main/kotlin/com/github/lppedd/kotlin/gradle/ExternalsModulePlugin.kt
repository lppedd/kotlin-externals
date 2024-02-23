package com.github.lppedd.kotlin.gradle

import com.github.lppedd.kotlin.gradle.ext.kmpExtension
import com.github.lppedd.kotlin.gradle.services.NpmService
import com.github.lppedd.kotlin.gradle.tasks.CheckNpmVersionTask
import com.github.lppedd.kotlin.gradle.tasks.CopyTsDeclarationsTask
import io.github.sgrishchenko.karakum.gradle.plugin.KarakumPlugin
import io.github.usefulness.KtlintGradleExtension
import io.github.usefulness.KtlintGradlePlugin
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsSubTargetDsl
import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import seskar.gradle.plugin.SeskarGradleSubplugin

/**
 * @author Edoardo Luppi
 */
class ExternalsModulePlugin : Plugin<Project> {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  override fun apply(project: Project) {
    // Apply the required plugins
    project.apply<KotlinMultiplatformPluginWrapper>()

    // Help us convert TypeScript declarations to Kotlin
    project.apply<KarakumPlugin>()

    // Enable formatting with Ktlint
    project.apply<KtlintGradlePlugin>()
    project.extensions.configure<KtlintGradleExtension> {
      ignoreFailures.set(true)
    }

    val tsDeclarations = project.extensions.create<TsDeclarations>("declarations")

    // Disable a nagging console (fake) error.
    // See https://youtrack.jetbrains.com/issue/KT-52578
    val yarn = project.yarn
    yarn.ignoreScripts = false

    // General Kotlin multiplatform configuration
    val kmp = project.kmpExtension
    kmp.compilerOptions {
      apiVersion.set(KotlinVersion.KOTLIN_1_9)
      languageVersion.set(KotlinVersion.KOTLIN_1_9)
      freeCompilerArgs.add("-XXLanguage:+JsAllowInvalidCharsIdentifiersEscaping")
    }

    kmp.js {
      val config: KotlinJsSubTargetDsl.() -> Unit = {
        testTask {
          useMocha {
            timeout = "30s"
          }
        }
      }

      nodejs(config)
      browser(config)
      useCommonJs()
    }

    // Compile to ES classes for better debuggability.
    // This is the only way it works for prod/dev/test compilations.
    // See discussion in https://youtrack.jetbrains.com/issue/KT-56818
    project.tasks.withType<Kotlin2JsCompile>().configureEach {
      kotlinOptions {
        useEsClasses = true
      }
    }

    // Apply the Seskar plugin after the Kotlin plugin
    // has created the appropriate dependency configurations
    project.apply<SeskarGradleSubplugin>()

    val jsMain = kmp.sourceSets.findByName("jsMain")
    jsMain?.dependencies {
      implementation(project(":common"))
      implementation("io.github.turansky.seskar:seskar-core:2.40.0")
    }

    val jsTest = kmp.sourceSets.findByName("jsTest")
    jsTest?.dependencies {
      implementation(kotlin("test"))
    }

    // Register a task to check if the associated npm package is outdated
    project.gradle.sharedServices.registerIfAbsent(NpmService.SERVICE_NAME, NpmService::class) {}
    project.tasks.register<CheckNpmVersionTask>(CheckNpmVersionTask.TASK_NAME)

    // Register a task to copy TypeScript declaration files from the npm package
    project.tasks.register<CopyTsDeclarationsTask>(CopyTsDeclarationsTask.TASK_NAME) {
      dependsOn("clean${name.capitalized()}")

      val packageName = tsDeclarations.packageName.get()
      val basePath = tsDeclarations.basePath.getOrElse("")
      val includePattern = tsDeclarations.includePattern.get()
      val excludePattern = tsDeclarations.excludePattern.orNull

      val buildDir = project.rootProject.layout.buildDirectory
      val packageJson = buildDir.file("js/node_modules/$packageName/package.json").get().asFile
      val baseDir = buildDir.dir("js/node_modules/$packageName/$basePath").get().asFile

      if (!packageJson.isFile) {
        throw GradleException("package.json not found at: $packageJson")
      }

      if (!baseDir.isDirectory) {
        throw GradleException("Base directory not found at: $baseDir")
      }

      // Copy the package.json to keep track of the package version
      from(packageJson) {
        rename("package.json", "package.txt")
      }

      // Copy TypeScript declarations
      from(baseDir) {
        include(includePattern)

        if (excludePattern != null) {
          exclude(excludePattern)
        }
      }

      eachFile {
        // Normalize line endings
        filter { it }
      }

      val destDir = project.layout.projectDirectory.dir("declarations")
      into(destDir)

      includeEmptyDirs = false
    }
  }
}
