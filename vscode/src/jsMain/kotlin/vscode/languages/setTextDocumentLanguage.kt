@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.TextDocument
import vscode.Thenable

/**
 * Set (and change) the [TextDocument.languageId] that is associated
 * with the given document.
 *
 * *Note* that calling this function will trigger the [vscode.workspace.onDidCloseTextDocument] event
 * followed by the [vscode.workspace.onDidOpenTextDocument] event.
 *
 * @param document The document which language is to be changed
 * @param languageId The new language identifier.
 * @return A thenable that resolves with the updated document.
 */
external fun setTextDocumentLanguage(
  document: TextDocument,
  languageId: String,
): Thenable<TextDocument>
