package vscode

external interface CodeActionDocumentation {
  /**
   * The kind of the code action being documented.
   *
   * If the kind is generic, such as `CodeActionKind.Refactor`, the documentation will be shown whenever any
   * refactorings are returned. If the kind if more specific, such as `CodeActionKind.RefactorExtract`, the
   * documentation will only be shown when extract refactoring code actions are returned.
   */
  val kind: CodeActionKind

  /**
   * Command that displays the documentation to the user.
   *
   * This can display the documentation directly in the editor or open a website using [vscode.env.openExternal];
   *
   * The title of this documentation code action is taken from [Command.title]
   */
  val command: Command
}
