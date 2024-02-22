package vscode

external interface TextEditorEditOptions {
  /**
   * Add undo stop before making the edits.
   */
  val undoStopBefore: Boolean

  /**
   * Add undo stop after making the edits.
   */
  val undoStopAfter: Boolean
}
