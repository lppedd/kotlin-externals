package vscode.extension.tester

external interface DefaultSetupOptions {
  /**
   * Version of VS Code to test against, defaults to latest
   */
  var vscodeVersion: String

  /**
   * Install the extension's dependencies from the marketplace. Defaults to `false`.
   */
  var installDependencies: Boolean
}
