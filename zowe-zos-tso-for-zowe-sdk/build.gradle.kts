@file:Suppress("UnstableApiUsage")

import com.github.lppedd.kotlin.gradle.ext.npmName
import com.github.lppedd.kotlin.gradle.ext.npmVersion

plugins {
  id("module.externals")
  id("module.publishable")
}

version = "$npmVersion-R1"

declarations {
  packageName = npmName
  basePath = "lib"
  includePattern = setOf("**/*.d.ts")
  excludePattern = setOf("**/index.d.ts")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        implementation(libs.kotlin.wrappers.js)
        implementation(npm(npmName, npmVersion))

        implementation(projects.zoweZosmfForZoweSdk)
        implementation(projects.zoweImperative)
      }
    }
  }
}
