package vscode

/**
 * An event that is fired when a [NotebookDocument notebook document] will be saved.
 *
 * To make modifications to the document before it is being saved, call the
 * {@linkcode NotebookDocumentWillSaveEvent.waitUntil waitUntil}-function with a thenable
 * that resolves to a [WorkspaceEdit workspace edit].
 */
external interface NotebookDocumentWillSaveEvent {
  /**
   * A cancellation token.
   */
  val token: CancellationToken

  /**
   * The [NotebookDocument notebook document] that will be saved.
   */
  val notebook: NotebookDocument

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
