import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

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
  }

  sourceSets {
    jsMain {
      dependencies {
        implementation(projects.vscode)
      }
    }
  }
}
