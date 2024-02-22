package zowe.explorer.api.globals

sealed external interface WebviewOptions {
  var viewType: String
  var title: String
  var vscode: WebviewOptionsVscode?
}
