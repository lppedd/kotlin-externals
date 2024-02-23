package vscode.window

import vscode.QuickPickOptions

external interface ShowQuickPickOptions : QuickPickOptions {
  override var canPickMany: `true`?
}
