package vscode

/**
 * Describes a structural change to a notebook document, e.g newly added and removed cells.
 *
 * @see [NotebookDocumentChangeEvent]
 */

external interface NotebookDocumentContentChange {
/**
   * The range at which cells have been either added or removed.
   *
   * Note that no cells have been [NotebookDocumentContentChange.removedCells removed]
   * when this range is [NotebookRange.isEmpty empty].
   */
  val range: NotebookRange

/**
   * Cells that have been added to the document.
   */
  val addedCells: Array<out NotebookCell>

/**
   * Cells that have been removed from the document.
   */
  val removedCells: Array<out NotebookCell>
}
