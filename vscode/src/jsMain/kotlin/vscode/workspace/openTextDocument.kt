@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.*

/**
 * Opens a document. Will return early if this document is already open. Otherwise
 * the document is loaded and the [vscode.workspace.onDidOpenTextDocument]-event fires.
 *
 * The document is denoted by an [Uri]. Depending on the [Uri.scheme] the
 * following rules apply:
 * - `file`-scheme: Open a file on disk (`openTextDocument(Uri.file(path))`). Will be rejected if the file
 *   does not exist or cannot be loaded.
 * - `untitled`-scheme: Open a blank untitled file with associated path (`openTextDocument(Uri.file(path).with({ scheme: 'untitled' }))`).
 *   The language will be derived from the file name.
 * - For all other schemes contributed [TextDocumentContentProvider] and
 *   [FileSystemProvider] are consulted.
 *
 * *Note* that the lifecycle of the returned document is owned by the editor and not by the extension. That means an
 * [vscode.workspace.onDidCloseTextDocument]-event can occur at any time after opening it.
 *
 * @param uri Identifies the resource to open.
 * @return A promise that resolves to a [TextDocument].
 */
external fun openTextDocument(uri: Uri): Thenable<TextDocument>

/**
 * A short-hand for `openTextDocument(Uri.file(path))`.
 *
 * @see [vscode.workspace.openTextDocument]
 * @param path A path of a file on disk.
 * @return A promise that resolves to a [TextDocument].
 */
external fun openTextDocument(path: String): Thenable<TextDocument>

/**
 * Opens an untitled text document. The editor will prompt the user for a file
 * path when the document is to be saved. The `options` parameter allows to
 * specify the *language* and/or the *content* of the document.
 *
 * @param options Options to control how the document will be created.
 * @return A promise that resolves to a [TextDocument].
 */
external fun openTextDocument(options: OpenTextDocumentOptions = definedExternally): Thenable<TextDocument>
