@file:JsModule("vscode")

package vscode

/**
 * The tab represents a single text based resource.
 */

external class TabInputText {
  /**
   * Constructs a text tab input with the given URI.
   * @param uri The URI of the tab.
   */
  constructor(uri: Uri)

  /**
   * The uri represented by the tab.
   */
  val uri: Uri
}
