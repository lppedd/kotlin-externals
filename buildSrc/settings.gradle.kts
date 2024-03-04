rootProject.name = "buildSrc"

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    mavenCentral()
    gradlePluginPortal()

    // For JNPM
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
  }

  versionCatalogs {
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}
