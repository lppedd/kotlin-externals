package vscode.extension.tester

external interface SetupOptionsTests {
  /** when true run `vsce package` with the `--yarn` flag */
  var useYarn: Boolean?

  /** install the extension's dependencies from the marketplace. Defaults to `false`. */
  var installDependencies: Boolean?
}
