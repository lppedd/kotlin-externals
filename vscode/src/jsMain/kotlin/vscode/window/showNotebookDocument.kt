@file:JsModule("vscode")

package vscode.window

import vscode.NotebookDocument
import vscode.NotebookDocumentShowOptions
import vscode.NotebookEditor
import vscode.Thenable

/**
 * Show the given [NotebookDocument] in a [NotebookEditor].
 *
 * @param document A text document to be shown.
 * @param options [NotebookDocumentShowOptions] to configure the behavior of showing the [NotebookEditor].
 *
 * @return A promise that resolves to an [NotebookEditor].
 */
external fun showNotebookDocument(
  document: NotebookDocument,
  options: NotebookDocumentShowOptions = definedExternally,
): Thenable<NotebookEditor>
