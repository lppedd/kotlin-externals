@file:Suppress("UnstableApiUsage")

import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.npm.npmProject

plugins {
  kotlin("multiplatform")
}

kotlin {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    freeCompilerArgs.add("-XXLanguage:+JsAllowInvalidCharsIdentifiersEscaping")
  }

  js {
    nodejs()
    useCommonJs()
    binaries.library()

    val mainCompilation = compilations.named("main")
    mainCompilation.configure {
      packageJson {
        val commands = listOf(
          mapOf(
            "command" to "helloworld.helloWorld",
            "title" to "Hello World",
          )
        )

        customField("activationEvents", listOf("onCommand:helloworld.helloWorld"))
        customField("categories", listOf("Other"))
        customField("contributes", mapOf("commands" to commands))
        customField("displayName", "HelloWorld")
        customField("description", "My first extension")
        customField("engines", mapOf("vscode" to "^1.86.0"))
      }

      // Register a task to allow starting a debug session
      tasks.register<Exec>("debugExtension") {
        dependsOn("jsNodeDevelopmentLibraryDistribution")

        val basePath = npmProject.dir
        val hostOs = OperatingSystem.current()

        executable = if (hostOs.isWindows) "code.cmd" else "code"
        args("--inspect-extensions=9229", "--extensionDevelopmentPath=$basePath")
      }
    }
  }

  sourceSets {
    jsMain {
      dependencies {
        implementation(projects.vscode)
      }

      languageSettings {
        optIn("kotlin.js.ExperimentalJsExport")
      }
    }
  }
}
