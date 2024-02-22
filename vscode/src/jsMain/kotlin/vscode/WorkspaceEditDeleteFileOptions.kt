package vscode

external interface WorkspaceEditDeleteFileOptions {
  /**
   * Delete the content recursively if a folder is denoted.
   */
  val recursive: Boolean?

  /**
   * Do nothing if a file with `uri` exists already.
   */
  val ignoreIfNotExists: Boolean?
}
