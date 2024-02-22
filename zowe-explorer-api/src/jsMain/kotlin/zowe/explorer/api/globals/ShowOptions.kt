package zowe.explorer.api.globals

import vscode.ViewColumn

external interface ShowOptions {
  var viewColumn: ViewColumn
  var preserveFocus: Boolean?
}
