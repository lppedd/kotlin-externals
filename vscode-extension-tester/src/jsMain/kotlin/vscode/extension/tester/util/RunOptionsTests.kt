package vscode.extension.tester.util

external interface RunOptionsTests {
  /** path to custom settings json file */
  var settings: String?

  /** remove the extension's directory as well (if present) */
  var cleanup: Boolean?

  /** path to a custom mocha configuration file */
  var config: String?

  /** logging level of the Webdriver */
  var logLevel: Any? /* logging.Level? */ // TODO(Edoardo): need selenium externals

  /** try to perform all setup without internet connection, needs all requirements pre-downloaded manually */
  var offline: Boolean?

  /** list of resources to be opened by VS Code */
  var resources: Array<String>
}
