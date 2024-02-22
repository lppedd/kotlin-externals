enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    mavenCentral()
  }
}

rootProject.name = "kotlin-externals"

include("common")

include("mocha")

include("vscode")
include("vscode-test-electron")
include("vscode-extension-tester")

include("zowe-core-for-zowe-sdk")
include("zowe-zosmf-for-zowe-sdk")
include("zowe-zos-jobs-for-zowe-sdk")
include("zowe-zos-files-for-zowe-sdk")
include("zowe-zos-tso-for-zowe-sdk")
include("zowe-zos-uss-for-zowe-sdk")
include("zowe-zos-console-for-zowe-sdk")
include("zowe-imperative")
include("zowe-cli")
include("zowe-explorer-api")
