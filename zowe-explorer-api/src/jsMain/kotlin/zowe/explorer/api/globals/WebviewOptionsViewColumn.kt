package zowe.explorer.api.globals

import vscode.ViewColumn

external interface WebviewOptionsViewColumn : WebviewOptions {
  var showOptions: ViewColumn
}
