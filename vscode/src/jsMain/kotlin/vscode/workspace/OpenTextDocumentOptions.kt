package vscode.workspace

import vscode.TextDocument

external interface OpenTextDocumentOptions {
  /**
   * The [TextDocument.languageId] of the document.
   */
  var language: String?

  /**
   * The initial contents of the document.
   */
  var content: String?
}
