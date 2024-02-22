@file:JsModule("@vscode/test-electron")

package vscode.test.electron

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Version {
  companion object {
    @seskar.js.JsValue("insiders")
    val insiders: Version

    @seskar.js.JsValue("stable")
    val stable: Version
  }
}
