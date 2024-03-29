@file:JsModule("vscode")

package vscode

/**
 * The tabs represents two notebooks in a diff configuration.
 */
external class TabInputNotebookDiff {
  /**
   * Constructs a notebook diff tab input.
   * @param original The uri of the original unmodified notebook.
   * @param modified The uri of the modified notebook.
   * @param notebookType The type of notebook. Maps to {@linkcode NotebookDocument.notebookType NotebookDocuments's notebookType}
   */
  constructor(original: Uri, modified: Uri, notebookType: String)

  /**
   * The uri of the original notebook.
   */
  val original: Uri

  /**
   * The uri of the modified notebook.
   */
  val modified: Uri

  /**
   * The type of notebook. Maps to {@linkcode NotebookDocument.notebookType NotebookDocuments's notebookType}
   */
  val notebookType: String
}
