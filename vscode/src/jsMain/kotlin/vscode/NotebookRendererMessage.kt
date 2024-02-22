package vscode

external interface NotebookRendererMessage {
  /**
   * The [NotebookEditor] that sent the message.
   */
  val editor: NotebookEditor

  /**
   * The actual message.
   */
  val message: Any?
}
