@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.ViewColumn
import vscode.WebviewPanel

/**
 * Create and show a new webview panel.
 *
 * @param viewType Identifies the type of the webview panel.
 * @param title Title of the panel.
 * @param showOptions Where to show the webview in the editor. If preserveFocus is set, the new webview will not take focus.
 * @param options Settings for the new panel.
 *
 * @return New webview panel.
 */
external fun createWebviewPanel(
  viewType: String,
  title: String,
  showOptions: ViewColumn,
  options: CreateWebviewPanelOptions = definedExternally,
): WebviewPanel

/**
 * Create and show a new webview panel.
 *
 * @param viewType Identifies the type of the webview panel.
 * @param title Title of the panel.
 * @param showOptions Where to show the webview in the editor. If preserveFocus is set, the new webview will not take focus.
 * @param options Settings for the new panel.
 *
 * @return New webview panel.
 */
external fun createWebviewPanel(
  viewType: String,
  title: String,
  showOptions: ShowOptions,
  options: CreateWebviewPanelOptions = definedExternally,
): WebviewPanel
