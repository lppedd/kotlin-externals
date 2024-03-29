@file:JsModule("vscode")

package vscode

/**
 * The tab represents two text based resources
 * being rendered as a diff.
 */
external class TabInputTextDiff {
  /**
   * Constructs a new text diff tab input with the given URIs.
   * @param original The uri of the original text resource.
   * @param modified The uri of the modified text resource.
   */
  constructor(original: Uri, modified: Uri)

  /**
   * The uri of the original text resource.
   */
  val original: Uri

  /**
   * The uri of the modified text resource.
   */
  val modified: Uri
}
