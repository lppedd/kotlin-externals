package vscode

import seskar.js.JsIntValue

/**
 * Reasons for why a text document has changed.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TextDocumentChangeReason {
  companion object {
    /** The text change is caused by an undo operation. */
    @JsIntValue(1)
    val Undo: TextDocumentChangeReason

    /** The text change is caused by an redo operation. */
    @JsIntValue(2)
    val Redo: TextDocumentChangeReason
  }
}
