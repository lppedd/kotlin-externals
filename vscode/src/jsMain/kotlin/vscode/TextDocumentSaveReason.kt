package vscode

import seskar.js.JsIntValue

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
    @JsIntValue(1)
    val Manual: TextDocumentSaveReason

    /**
     * Automatic after a delay.
     */
    @JsIntValue(2)
    val AfterDelay: TextDocumentSaveReason

    /**
     * When the editor lost focus.
     */
    @JsIntValue(3)
    val FocusOut: TextDocumentSaveReason
  }
}
