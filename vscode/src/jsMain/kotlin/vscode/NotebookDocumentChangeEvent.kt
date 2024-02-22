package vscode

/**
 * An event describing a transactional [NotebookDocument notebook] change.
 */

external interface NotebookDocumentChangeEvent {
/**
   * The affected notebook.
   */
  val notebook: NotebookDocument

/**
   * The new metadata of the notebook or `undefined` when it did not change.
   */
  val metadata: (Temp10)?

/**
   * An array of content changes describing added or removed [NotebookCell cells].
   */
  val contentChanges: Array<out NotebookDocumentContentChange>

/**
   * An array of [NotebookDocumentCellChange cell changes].
   */
  val cellChanges: Array<out NotebookDocumentCellChange>
}
