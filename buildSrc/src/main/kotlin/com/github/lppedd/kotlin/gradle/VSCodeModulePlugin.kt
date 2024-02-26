package com.github.lppedd.kotlin.gradle

import com.github.lppedd.kotlin.gradle.ext.kmpExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Exec
import org.gradle.internal.os.OperatingSystem
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper
import org.jetbrains.kotlin.gradle.targets.js.npm.npmProject
import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import seskar.gradle.plugin.SeskarGradleSubplugin

/**
 * @author Edoardo Luppi
 */
class VSCodeModulePlugin : Plugin<Project> {
  override fun apply(project: Project) {
    // Apply the required plugins
    project.apply<KotlinMultiplatformPluginWrapper>()

    // Register an extension to allow configuring the plugin using
    //
    // vscodeExtension {
    //   ...
    // }
    val vscode = project.extensions.create<VSCodeModuleExtension>("vscodeExtension", project)

    // See https://youtrack.jetbrains.com/issue/KT-52578
    project.yarn.ignoreScripts = false

    // General KMP configuration
    project.kmpExtension.apply {
      js {
        nodejs()
        useCommonJs()
        binaries.library()
        compilations.named("main").configure {
          // Register a task to allow starting a debug session
          project.tasks.register<Exec>("debugExtension") {
            dependsOn("jsNodeDevelopmentLibraryDistribution")

            if (vscode.webViewsDir.isPresent) {
              dependsOn("copyWebviews")
            }

            val basePath = npmProject.dir.get()
            val hostOs = OperatingSystem.current()

            executable = if (hostOs.isWindows) "code.cmd" else "code"
            args("--extensionDevelopmentPath=$basePath", "--inspect-extensions=9229", "--host=127.0.0.1")
          }
        }
      }

      sourceSets.jsMain.configure {
        dependencies {
          implementation(project(":vscode"))
        }
      }

      sourceSets.configureEach {
        languageSettings {
          optIn("kotlin.js.ExperimentalJsExport")
          optIn("kotlinx.coroutines.DelicateCoroutinesApi")
        }
      }
    }

    project.apply<SeskarGradleSubplugin>()
    project.tasks.withType<Kotlin2JsCompile>().configureEach {
      compilerOptions {
        freeCompilerArgs.add("-XXLanguage:+JsAllowInvalidCharsIdentifiersEscaping")
      }

      kotlinOptions {
        useEsClasses = true
        sourceMap = true
        sourceMapEmbedSources = "always"
      }
    }
  }
}
