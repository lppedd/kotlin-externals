package vscode

/**
 * Represents an event describing the change in a [NotebookEditor.visibleRanges notebook editor's visibleRanges].
 */
external interface NotebookEditorVisibleRangesChangeEvent {
  /**
   * The [NotebookEditor notebook editor] for which the visible ranges have changed.
   */
  val notebookEditor: NotebookEditor

  /**
   * The new value for the [NotebookEditor.visibleRanges notebook editor's visibleRanges].
   */
  val visibleRanges: Array<out NotebookRange>
}
