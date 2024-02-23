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
  includePattern = setOf("index.d.ts")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        implementation(devNpm(npmName, npmVersion))
        api(libs.kotlin.wrappers.js)
      }
    }
  }
}
