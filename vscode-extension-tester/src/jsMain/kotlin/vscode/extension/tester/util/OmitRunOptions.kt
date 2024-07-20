package vscode.extension.tester.util

/**
 * TODO(Edoardo): equivalent to `Omit<RunOptions, 'vscodeVersion'>` in TS.
 *   Need a compiler plugin.
 */
external interface OmitRunOptions {
  /**
   * Path to custom settings json file
   */
  var settings: String?

  /**
   * Remove the extension's directory as well (if present)
   */
  var cleanup: Boolean?

  /**
   * Path to a custom mocha configuration file
   */
  var config: String?

  /**
   * Logging level of the Webdriver
   */
  var logLevel: Any? /* logging.Level? */ // TODO(Edoardo): need selenium externals

  /**
   * Try to perform all setup without internet connection, needs all requirements pre-downloaded manually
   */
  var offline: Boolean?

  /**
   * List of resources to be opened by VS Code
   */
  var resources: Array<String>
}
