@file:JsModule("vscode")

package vscode

import js.objects.Record

/**
 * A notebook edit represents edits that should be applied to the contents of a notebook.
 */
external class NotebookEdit {
  /**
   * Create a new notebook edit.
   *
   * @param range A notebook range.
   * @param newCells An array of new cell data.
   */
  constructor(range: NotebookRange, newCells: Array<NotebookCellData>)

  /**
   * Range of the cells being edited. May be empty.
   */
  var range: NotebookRange

  /**
   * New cells being inserted. May be empty.
   */
  var newCells: Array<NotebookCellData>

  /**
   * Optional new metadata for the cells.
   */
  var newCellMetadata: Record<String, Any>?

  /**
   * Optional new metadata for the notebook.
   */
  var newNotebookMetadata: Record<String, Any>?

  companion object {
    /**
     * Utility to create a edit that replaces cells in a notebook.
     *
     * @param range The range of cells to replace
     * @param newCells The new notebook cells.
     */
    fun replaceCells(
      range: NotebookRange,
      newCells: Array<NotebookCellData>,
    ): NotebookEdit

    /**
     * Utility to create an edit that replaces cells in a notebook.
     *
     * @param index The index to insert cells at.
     * @param newCells The new notebook cells.
     */
    fun insertCells(
      index: Int,
      newCells: Array<NotebookCellData>,
    ): NotebookEdit

    /**
     * Utility to create an edit that deletes cells in a notebook.
     *
     * @param range The range of cells to delete.
     */
    fun deleteCells(range: NotebookRange): NotebookEdit

    /**
     * Utility to create an edit that update a cell's metadata.
     *
     * @param index The index of the cell to update.
     * @param newCellMetadata The new metadata for the cell.
     */
    fun updateCellMetadata(
      index: Int,
      newCellMetadata: Record<String, Any>,
    ): NotebookEdit

    /**
     * Utility to create an edit that updates the notebook's metadata.
     *
     * @param newNotebookMetadata The new metadata for the notebook.
     */
    fun updateNotebookMetadata(newNotebookMetadata: Record<String, Any>): NotebookEdit
  }
}
