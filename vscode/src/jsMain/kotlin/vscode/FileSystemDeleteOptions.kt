package vscode

external interface FileSystemDeleteOptions {
  /**
   * Delete the content recursively if a folder is denoted.
   */
  var recursive: Boolean?

  /**
   * Use the os's trashcan instead of permanently deleting files whenever possible.
   */
  var useTrash: Boolean?
}
