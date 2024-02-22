package vscode

external interface CodeActionDisabled {
  /**
   * Human readable description of why the code action is currently disabled.
   *
   * This is displayed in the code actions UI.
   */
  val reason: String
}
