@file:Suppress("VulnerableLibrariesLocal")

plugins {
  `kotlin-dsl`
}

dependencies {
  // The Kotlin Gradle Plugin dependency propagates to the entire workspace
  implementation(libs.kotlin.plugin)
  implementation(libs.ktlint.plugin)
  implementation(libs.seskar.plugin)
  implementation(libs.karakum.plugin)
  implementation(libs.maven.publish.plugin)
  implementation(libs.jnpm)
}

gradlePlugin {
  plugins {
    register("externalsModule") {
      id = "module.externals"
      implementationClass = "com.github.lppedd.kotlin.gradle.ExternalsModulePlugin"
    }
    register("publishableModule") {
      id = "module.publishable"
      implementationClass = "com.github.lppedd.kotlin.gradle.PublishableModulePlugin"
    }
    register("moduleVscode") {
      id = "module.vscode"
      implementationClass = "com.github.lppedd.kotlin.gradle.VSCodeModulePlugin"
    }
  }
}
