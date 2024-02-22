package vscode

/**
 * An event describing a transactional [TextDocument document] change.
 */

external interface TextDocumentChangeEvent {
  /**
   * The affected document.
   */
  val document: TextDocument

  /**
   * An array of content changes.
   */
  val contentChanges: Array<out TextDocumentContentChangeEvent>

  /**
   * The reason why the document was changed.
   * Is `undefined` if the reason is not known.
   */
  val reason: TextDocumentChangeReason?
}
