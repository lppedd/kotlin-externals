package vscode

import seskar.js.JsIntValue

/**
 * In a remote window the extension kind describes if an extension
 * runs where the UI (window) runs or if an extension runs remotely.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ExtensionKind {
  companion object {
    /**
     * Extension runs where the UI runs.
     */
    @JsIntValue(1)
    val UI: ExtensionKind

    /**
     * Extension runs where the remote extension host runs.
     */
    @JsIntValue(2)
    val Workspace: ExtensionKind
  }
}
