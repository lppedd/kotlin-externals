package vscode.window

import vscode.JsTrue
import vscode.QuickPickOptions

external interface ShowQuickPickOptions : QuickPickOptions {
  @JsTrue
  override var canPickMany: Boolean? // = true
}
