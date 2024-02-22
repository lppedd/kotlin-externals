package vscode

import js.array.ReadonlyArray
import js.objects.Record

/**
 * Describes a change to a notebook cell.
 *
 * See [NotebookDocumentChangeEvent]
 */
external interface NotebookDocumentCellChange {
  /**
   * The affected cell.
   */
  val cell: NotebookCell

  /**
   * The document of the cell or `undefined` when it did not change.
   *
   * *Note* that you should use the [vscode.workspace.onDidChangeTextDocument]-event
   * for detailed change information, like what edits have been performed.
   */
  val document: TextDocument?

  /**
   * The new metadata of the cell or `undefined` when it did not change.
   */
  val metadata: Record<String, Any>?

  /**
   * The new outputs of the cell or `undefined` when they did not change.
   */
  val outputs: ReadonlyArray<NotebookCellOutput>?

  /**
   * The new execution summary of the cell or `undefined` when it did not change.
   */
  val executionSummary: NotebookCellExecutionSummary?
}
