@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.Uri

/**
 * Returns a path that is relative to the workspace folder or folders.
 *
 * When there are no [vscode.workspace.workspaceFolders] or when the path
 * is not contained in them, the input is returned.
 *
 * @param pathOrUri A path or uri. When a uri is given its [Uri.fsPath] is used.
 * @param includeWorkspaceFolder When `true` and when the given path is contained inside a
 *   workspace folder the name of the workspace is prepended. Defaults to `true` when there are
 *   multiple workspace folders and `false` otherwise.
 * @return A path relative to the root or the input.
 */
external fun asRelativePath(
  pathOrUri: String,
  includeWorkspaceFolder: Boolean = definedExternally,
): String

/**
 * Returns a path that is relative to the workspace folder or folders.
 *
 * When there are no [vscode.workspace.workspaceFolders] or when the path
 * is not contained in them, the input is returned.
 *
 * @param pathOrUri A path or uri. When a uri is given its [Uri.fsPath] is used.
 * @param includeWorkspaceFolder When `true` and when the given path is contained inside a
 *   workspace folder the name of the workspace is prepended. Defaults to `true` when there are
 *   multiple workspace folders and `false` otherwise.
 * @return A path relative to the root or the input.
 */
external fun asRelativePath(
  pathOrUri: Uri,
  includeWorkspaceFolder: Boolean = definedExternally,
): String
