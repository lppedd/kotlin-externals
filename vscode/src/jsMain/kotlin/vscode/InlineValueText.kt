@file:JsModule("vscode")

package vscode

/**
 * Provide inline value as text.
 */
external class InlineValueText {
  /**
   * Creates a new InlineValueText object.
   *
   * @param range The document line where to show the inline value.
   * @param text The value to be shown for the line.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(range: Range, text: String)

  /**
   * The document range for which the inline value applies.
   */
  val range: Range

  /**
   * The text of the inline value.
   */
  val text: String
}
