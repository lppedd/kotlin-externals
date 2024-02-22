package vscode.extension.tester

external interface SetupOptions {
  /** version of VS Code to test against, defaults to latest */
  var vscodeVersion: String?

  /** when true run `vsce package` with the `--yarn` flag */
  var useYarn: Boolean?

  /** install the extension's dependencies from the marketplace. Defaults to `false`. */
  var installDependencies: Boolean?
}
