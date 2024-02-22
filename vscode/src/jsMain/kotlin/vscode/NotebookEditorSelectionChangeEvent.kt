package vscode

/**
 * Represents an event describing the change in a [NotebookEditor.selections notebook editor's selections].
 */

external interface NotebookEditorSelectionChangeEvent {
/**
   * The [NotebookEditor notebook editor] for which the selections have changed.
   */
  val notebookEditor: NotebookEditor

/**
   * The new value for the [NotebookEditor.selections notebook editor's selections].
   */
  val selections: Array<out NotebookRange>
}
