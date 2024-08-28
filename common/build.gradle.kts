import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
  kotlin("multiplatform")
  id("module.publishable")
}

version = "1.0.0"

kotlin {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    freeCompilerArgs.add("-Xallow-kotlin-package")
  }

  js {
    nodejs()
    browser()
  }
}
