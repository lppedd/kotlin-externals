@file:JsModule("vscode")

package vscode

/**
 * The tab represents a custom editor.
 */
external class TabInputCustom {
  /**
   * Constructs a custom editor tab input.
   * @param uri The uri of the tab.
   * @param viewType The viewtype of the custom editor.
   */
  constructor(uri: Uri, viewType: String)

  /**
   * The uri that the tab is representing.
   */
  val uri: Uri

  /**
   * The type of custom editor.
   */
  val viewType: String
}
