package vscode

import js.array.ReadonlyArray
import js.objects.Record

/**
 * An event describing a transactional [NotebookDocument] change.
 */
external interface NotebookDocumentChangeEvent {
  /**
   * The affected notebook.
   */
  val notebook: NotebookDocument

  /**
   * The new metadata of the notebook or `undefined` when it did not change.
   */
  val metadata: Record<String, Any>?

  /**
   * An array of content changes describing added or removed cells ([NotebookCell]).
   */
  val contentChanges: ReadonlyArray<NotebookDocumentContentChange>

  /**
   * An array of cell changes ([NotebookDocumentCellChange]).
   */
  val cellChanges: ReadonlyArray<NotebookDocumentCellChange>
}
