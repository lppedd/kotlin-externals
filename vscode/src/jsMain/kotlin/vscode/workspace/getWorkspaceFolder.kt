@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.Uri
import vscode.WorkspaceFolder

/**
 * Returns the [WorkspaceFolder] that contains a given uri.
 * - returns `undefined` when the given uri doesn't match any workspace folder
 * - returns the *input* when the given uri is a workspace folder itself
 *
 * @param uri An uri.
 * @return A workspace folder or `undefined`
 */
external fun getWorkspaceFolder(uri: Uri): WorkspaceFolder?
