package vscode

/**
 * An event that is fired when a [TextDocument document] will be saved.
 *
 * To make modifications to the document before it is being saved, call the
 * {@linkcode TextDocumentWillSaveEvent.waitUntil waitUntil}-function with a thenable
 * that resolves to an array of [TextEdit text edits].
 */
external interface TextDocumentWillSaveEvent {
  /**
   * The document that will be saved.
   */
  val document: TextDocument

  /**
   * The reason why save was triggered.
   */
  val reason: TextDocumentSaveReason

  /**
   * Allows to pause the event loop until the provided thenable resolved.
   *
   * *Note:* This function can only be called during event dispatch.
   *
   * @param thenable A thenable that delays saving.
   */
  fun waitUntil(thenable: Thenable<Any?>)
}
