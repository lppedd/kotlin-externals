@file:Suppress("UnstableApiUsage")

import com.github.lppedd.kotlin.gradle.ext.npmName
import com.github.lppedd.kotlin.gradle.ext.npmVersion

plugins {
  id("externals.module")
}

version = "$npmVersion-R1"

declarations {
  packageName = npmName
  includePattern = setOf("index.d.ts")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        implementation(libs.kotlin.wrappers.js)
        implementation(npm(npmName, npmVersion))
      }
    }
  }
}
