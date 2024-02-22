package vscode.window

import vscode.QuickPickOptions

external interface ShowQuickPickOptions : QuickPickOptions {
  @JsTrue
  override var canPickMany: Boolean? // = true
}
