@file:JsModule("vscode")

package vscode.workspace

import vscode.WorkspaceFolder

/**
 * This method replaces `deleteCount` [vscode.workspace.workspaceFolders] starting at index `start`
 * by an optional set of `workspaceFoldersToAdd` on the `vscode.workspace.workspaceFolders` array. This "splice"
 * behavior can be used to add, remove and change workspace folders in a single operation.
 *
 * **Note:** in some cases calling this method may result in the currently executing extensions (including the
 * one that called this method) to be terminated and restarted. For example when the first workspace folder is
 * added, removed or changed the (deprecated) `rootPath` property is updated to point to the first workspace
 * folder. Another case is when transitioning from an empty or single-folder workspace into a multi-folder
 * workspace (see also: https://code.visualstudio.com/docs/editor/workspaces).
 *
 * Use the [onDidChangeWorkspaceFolders] event to get notified when the
 * workspace folders have been updated.
 *
 * **Example:** adding a new workspace folder at the end of workspace folders
 * ```typescript
 * workspace.updateWorkspaceFolders(workspace.workspaceFolders ? workspace.workspaceFolders.length : 0, null, { uri: ...});
 * ```
 *
 * **Example:** removing the first workspace folder
 * ```typescript
 * workspace.updateWorkspaceFolders(0, 1);
 * ```
 *
 * **Example:** replacing an existing workspace folder with a new one
 * ```typescript
 * workspace.updateWorkspaceFolders(0, 1, { uri: ...});
 * ```
 *
 * It is valid to remove an existing workspace folder and add it again with a different name
 * to rename that folder.
 *
 * **Note:** it is not valid to call [updateWorkspaceFolders] multiple times
 * without waiting for the [onDidChangeWorkspaceFolders] to fire.
 *
 * @param start the zero-based location in the list of currently opened [WorkspaceFolder]
 *   from which to start deleting workspace folders.
 * @param deleteCount the optional number of workspace folders to remove.
 * @param workspaceFoldersToAdd the optional variable set of workspace folders to add in place of the deleted ones.
 *   Each workspace is identified with a mandatory URI and an optional name.
 * @return true if the operation was successfully started and false otherwise if arguments were used that would result
 *   in invalid workspace folder state (e.g. 2 folders with the same URI).
 */
external fun updateWorkspaceFolders(
  start: Int,
  deleteCount: Int?,
  vararg workspaceFoldersToAdd: WorkspaceFolderToAdd,
): Boolean
