package vscode

external interface WorkspaceEditRenameFileOptions {
  /**
   * Overwrite existing file. Overwrite wins over `ignoreIfExists`
   */
  val overwrite: Boolean?

  /**
   * Do nothing if a file with `uri` exists already.
   */
  val ignoreIfExists: Boolean?
}
