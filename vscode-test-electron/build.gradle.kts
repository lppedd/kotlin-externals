@file:Suppress("UnstableApiUsage")

import com.github.lppedd.kotlin.gradle.ext.npmName
import com.github.lppedd.kotlin.gradle.ext.npmVersion

plugins {
  id("externals.module")
}

version = "$npmVersion-R1"

declarations {
  packageName = npmName
  basePath = "out"
  includePattern = setOf("**/*.d.ts")
  excludePattern = setOf("**/index.d.ts")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        implementation(libs.kotlin.wrappers.js)
        implementation(libs.kotlin.wrappers.node)
        implementation(npm(npmName, npmVersion))
      }
    }
  }
}