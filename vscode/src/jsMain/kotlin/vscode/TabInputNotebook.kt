@file:JsModule("vscode")

package vscode

/**
 * The tab represents a notebook.
 */
external class TabInputNotebook {
  /**
   * Constructs a new tab input for a notebook.
   * @param uri The uri of the notebook.
   * @param notebookType The type of notebook. Maps to {@linkcode NotebookDocument.notebookType NotebookDocuments's notebookType}
   */
  constructor(uri: Uri, notebookType: String)

  /**
   * The uri that the tab is representing.
   */
  val uri: Uri

  /**
   * The type of notebook. Maps to {@linkcode NotebookDocument.notebookType NotebookDocuments's notebookType}
   */
  val notebookType: String
}
