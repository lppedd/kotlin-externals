package vscode.extension.tester

external interface VsixOptions {
  /**
   * Path to the extension `.vsix` file. If not set, default vsce path will be used.
   */
  var vsixFile: String?

  /**
   * When `true` run `vsce package` with the `--yarn` flag.
   */
  var useYarn: Boolean?

  /**
   * Install the extension's dependencies from the marketplace. Defaults to `false`.
   */
  var installDependencies: Boolean?
}
