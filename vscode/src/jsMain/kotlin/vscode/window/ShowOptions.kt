package vscode.window

import vscode.ViewColumn
import vscode.WebviewPanel

external interface ShowOptions {
  /**
   * The view column in which the [WebviewPanel] should be shown.
   */
  val viewColumn: ViewColumn

  /**
   * An optional flag that when `true` will stop the panel from taking focus.
   */
  val preserveFocus: Boolean?
}
