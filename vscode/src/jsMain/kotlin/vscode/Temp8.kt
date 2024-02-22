package vscode

external interface Temp8 {
  /**
   * The [NotebookEditor editor] that sent the message.
   */
  val editor: NotebookEditor

  /**
   * The actual message.
   */
  val message: Any?
}
