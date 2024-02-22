package vscode.workspace

import vscode.Uri

external interface WorkspaceFolderToAdd {
  /**
   * The uri of a workspace folder that's to be added.
   */
  val uri: Uri

  /**
   * The name of a workspace folder that's to be added.
   */
  val name: String?
}
