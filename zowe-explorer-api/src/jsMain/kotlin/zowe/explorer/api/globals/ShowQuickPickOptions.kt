package zowe.explorer.api.globals

external interface ShowQuickPickOptions : vscode.QuickPickOptions {
  override var canPickMany: Boolean?
}
