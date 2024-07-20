package vscode.extension.tester

/**
 * TODO(Edoardo): equivalent to `Omit<SetupOptions, 'vscodeVersion'>` in TS.
 *   Need a compiler plugin.
 */
external interface OmitSetupOptions {
  /**
   * Ihen true run `vsce package` with the `--yarn` flag
   */
  var useYarn: Boolean?

  /**
   * Install the extension's dependencies from the marketplace. Defaults to `false`.
   */
  var installDependencies: Boolean?
}
