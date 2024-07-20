package vscode.test.electron

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface VersionType {
  companion object {
    @seskar.js.JsValue("insiders")
    val insiders: VersionType

    @seskar.js.JsValue("stable")
    val stable: VersionType
  }
}
