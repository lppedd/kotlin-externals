@file:JsModule("vscode")

package vscode

/**
 * Represents reasons why a text document is saved.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TextDocumentSaveReason {
  companion object {
    /**
     * Manually triggered, e.g. by the user pressing save, by starting debugging,
     * or by an API call.
     */
    val Manual: TextDocumentSaveReason

    /**
     * Automatic after a delay.
     */
    val AfterDelay: TextDocumentSaveReason

    /**
     * When the editor lost focus.
     */
    val FocusOut: TextDocumentSaveReason
  }
}
