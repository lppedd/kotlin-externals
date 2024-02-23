@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.Thenable
import vscode.WorkspaceFolder
import vscode.WorkspaceFolderPickOptions

/**
 * Shows a selection list of [vscode.workspace.workspaceFolders] to pick from.
 * Returns `undefined` if no folder is open.
 *
 * @param options Configures the behavior of the workspace folder list.
 * @return A promise that resolves to the workspace folder or `undefined`.
 */
external fun showWorkspaceFolderPick(
  options: WorkspaceFolderPickOptions = definedExternally,
): Thenable<WorkspaceFolder?>
