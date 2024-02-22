@file:JsModule("vscode")

package vscode

/**
 * Raw representation of a notebook.
 *
 * Extensions are responsible for creating {@linkcode NotebookData} so that the editor
 * can create a {@linkcode NotebookDocument}.
 *
 * @see [NotebookSerializer]
 */

external class NotebookData {
  /**
   * Create new notebook data.
   *
   * @param cells An array of cell data.
   */
  constructor(cells: Array<NotebookCellData>)

  /**
   * The cell data of this notebook data.
   */
  var cells: Array<NotebookCellData>

  /**
   * Arbitrary metadata of notebook data.
   */
  var metadata: (NotebookDataMetadata)?
}
