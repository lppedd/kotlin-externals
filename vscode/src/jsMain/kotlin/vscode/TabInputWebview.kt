@file:JsModule("vscode")

package vscode

/**
 * The tab represents a webview.
 */

external class TabInputWebview {
  /**
   * Constructs a webview tab input with the given view type.
   * @param viewType The type of webview. Maps to {@linkcode WebviewPanel.viewType WebviewPanel's viewType}
   */
  constructor(viewType: String)

  /**
   * The type of webview. Maps to {@linkcode WebviewPanel.viewType WebviewPanel's viewType}
   */
  val viewType: String
}
