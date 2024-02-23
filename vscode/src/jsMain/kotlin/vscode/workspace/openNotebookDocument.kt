@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.NotebookData
import vscode.NotebookDocument
import vscode.Thenable
import vscode.Uri

/**
 * Open a notebook. Will return early if this notebook is already [notebookDocuments]. Otherwise
 * the notebook is loaded and the [onDidOpenNotebookDocument]-event fires.
 *
 * *Note* that the lifecycle of the returned notebook is owned by the editor and not by the extension. That means an
 * [onDidCloseNotebookDocument]-event can occur at any time after.
 *
 * *Note* that opening a notebook does not show a notebook editor. This function only returns a notebook document which
 * can be shown in a notebook editor but it can also be used for other things.
 *
 * @param uri The resource to open.
 * @return A promise that resolves to a [NotebookDocument]
 */
external fun openNotebookDocument(uri: Uri): Thenable<NotebookDocument>

/**
 * Open an untitled notebook. The editor will prompt the user for a file
 * path when the document is to be saved.
 *
 * @see [vscode.workspace.openNotebookDocument]
 * @param notebookType The notebook type that should be used.
 * @param content The initial contents of the notebook.
 * @return A promise that resolves to a [NotebookDocument].
 */
external fun openNotebookDocument(
  notebookType: String,
  content: NotebookData = definedExternally,
): Thenable<NotebookDocument>
