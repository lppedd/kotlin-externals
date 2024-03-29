package vscode

/**
 * Additional data about a workspace edit.
 */
external interface WorkspaceEditMetadata {
  /**
   * Signal to the editor that this edit is a refactoring.
   */
  var isRefactoring: Boolean?
}
