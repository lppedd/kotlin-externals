@file:JsModule("vscode")

package vscode.window

import vscode.*

/**
 * Show the given document in a text editor. A [ViewColumn] can be provided
 * to control where the editor is being shown. Might change the [vscode.window.activeTextEditor].
 *
 * @param document A text document to be shown.
 * @param column A view column in which the [TextEditor] should be shown. The default is the [ViewColumn.Active].
 *   Columns that do not exist will be created as needed up to the maximum of [ViewColumn.Nine]. Use [ViewColumn.Beside]
 *   to open the editor to the side of the currently active one.
 * @param preserveFocus When `true` the editor will not take focus.
 * @return A promise that resolves to an [TextEditor].
 */
external fun showTextDocument(
  document: TextDocument,
  column: ViewColumn = definedExternally,
  preserveFocus: Boolean = definedExternally,
): Thenable<TextEditor>

/**
 * Show the given document in a text editor. [TextDocumentShowOptions] can be provided
 * to control options of the editor is being shown. Might change the [vscode.window.activeTextEditor].
 *
 * @param document A text document to be shown.
 * @param options [TextDocumentShowOptions] to configure the behavior of showing the [TextEditor].
 * @return A promise that resolves to an [TextEditor].
 */
external fun showTextDocument(
  document: TextDocument,
  options: TextDocumentShowOptions = definedExternally,
): Thenable<TextEditor>

/**
 * A short-hand for `openTextDocument(uri).then(document => showTextDocument(document, options))`.
 *
 * @see [vscode.workspace.openTextDocument]
 *
 * @param uri A resource identifier.
 * @param options [TextDocumentShowOptions] to configure the behavior of showing the [TextEditor].
 * @return A promise that resolves to an [TextEditor].
 */
external fun showTextDocument(
  uri: Uri,
  options: TextDocumentShowOptions = definedExternally,
): Thenable<TextEditor>
