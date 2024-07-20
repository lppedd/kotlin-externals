package vscode.extension.tester

external interface SetupOptionsTests {
  /**
   * Ihen true run `vsce package` with the `--yarn` flag
   */
  var useYarn: Boolean?

  /**
   * Install the extension's dependencies from the marketplace. Defaults to `false`.
   */
  var installDependencies: Boolean?
}
