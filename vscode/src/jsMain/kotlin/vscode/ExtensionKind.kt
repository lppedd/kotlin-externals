@file:JsModule("vscode")

package vscode

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
    val UI: ExtensionKind

    /**
     * Extension runs where the remote extension host runs.
     */
    val Workspace: ExtensionKind
  }
}
