package vscode.extension.tester

external interface SetupOptions {
  /**
   * Version of VS Code to test against, defaults to latest
   */
  var vscodeVersion: String?

  /**
   * When true run `vsce package` with the `--yarn` flag
   */
  var useYarn: Boolean?

  /**
   * Install the extension's dependencies from the marketplace. Defaults to `false`.
   */
  var installDependencies: Boolean?
}
