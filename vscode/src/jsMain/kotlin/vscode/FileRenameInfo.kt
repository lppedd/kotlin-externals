package vscode

external interface FileRenameInfo {
  /**
   * The old uri of a file.
   */
  val oldUri: Uri

  /**
   * The new uri of a file.
   */
  val newUri: Uri
}
