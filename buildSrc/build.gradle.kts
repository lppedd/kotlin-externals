plugins {
  `kotlin-dsl`
}

dependencies {
  // The Kotlin Gradle Plugin dependency propagates to the entire workspace
  implementation(libs.kotlin.plugin)
  implementation(libs.ktlint.plugin)
  implementation(libs.seskar.plugin)
  implementation(libs.karakum.plugin)
}

gradlePlugin {
  plugins {
    register("externalsModule") {
      id = "externals.module"
      implementationClass = "com.github.lppedd.kotlin.gradle.ExternalsModulePlugin"
    }
  }
}
