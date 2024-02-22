@file:JsModule("vscode")

package vscode

/**
 * Represents a color range from a document.
 */
external class ColorInformation {
  /**
   * Creates a new color range.
   *
   * @param range The range the color appears in. Must not be empty.
   * @param color The value of the color.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(range: Range, color: Color)

  /**
   * The range in the document where this color appears.
   */
  var range: Range

  /**
   * The actual color value for this color range.
   */
  var color: Color
}
