package vscode.test.electron

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Platform {
  companion object {
    @seskar.js.JsValue("darwin")
    val darwin: Platform

    @seskar.js.JsValue("darwin-arm64")
    val darwinArm64: Platform

    @seskar.js.JsValue("win32-x64-archive")
    val win32X64Archive: Platform

    @seskar.js.JsValue("win32-arm64-archive")
    val win32Arm64Archive: Platform

    @seskar.js.JsValue("linux-x64")
    val linuxX64: Platform

    @seskar.js.JsValue("linux-arm64")
    val linuxArm64: Platform

    @seskar.js.JsValue("linux-armhf")
    val linuxArmhf: Platform
  }
}
