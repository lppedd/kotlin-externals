package vscode.extension.tester.util

external interface DefaultRunOptions {
  var vscodeVersion: String
  var settings: String
  var logLevel: Any /* logging.Level */ // TODO(Edoardo): need selenium externals
  var offline: Boolean
  var resources: Array<Any?> // never[]
}
