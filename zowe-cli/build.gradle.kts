@file:Suppress("UnstableApiUsage")

import com.github.lppedd.kotlin.gradle.ext.npmName
import com.github.lppedd.kotlin.gradle.ext.npmVersion

plugins {
  id("externals.module")
}

version = "$npmVersion-R1"

declarations {
  packageName = npmName
  basePath = "lib"
  includePattern = setOf("**/*.d.ts")
  excludePattern = setOf("**/index.d.ts", "**/main.d.ts")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        implementation(libs.kotlin.wrappers.js)
        implementation(libs.kotlin.wrappers.node)
        implementation(npm(npmName, npmVersion))

        api(projects.zoweZosFilesForZoweSdk)
        api(projects.zoweZosJobsForZoweSdk)
        api(projects.zoweZosTsoForZoweSdk)
        api(projects.zoweZosmfForZoweSdk)
        api(projects.zoweZosConsoleForZoweSdk)
        api(projects.zoweImperative)
      }
    }
  }
}
