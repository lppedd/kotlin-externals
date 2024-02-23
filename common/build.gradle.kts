import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
  kotlin("multiplatform")
  id("module.publishable")
}

version = "1.0.0"

kotlin {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    apiVersion.set(KotlinVersion.KOTLIN_1_9)
    languageVersion.set(KotlinVersion.KOTLIN_1_9)
    freeCompilerArgs.add("-Xallow-kotlin-package")
  }

  js {
    nodejs()
    browser()
  }
}
