@file:JsModule("vscode")

package vscode

/**
 * Represents a color in RGBA space.
 */
external class Color {
  /**
   * Creates a new color instance.
   *
   * @param red The red component.
   * @param green The green component.
   * @param blue The blue component.
   * @param alpha The alpha component.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(red: Double, green: Double, blue: Double, alpha: Double)

  /**
   * The red component of this color in the range [0-1].
   */
  val red: Double

  /**
   * The green component of this color in the range [0-1].
   */
  val green: Double

  /**
   * The blue component of this color in the range [0-1].
   */
  val blue: Double

  /**
   * The alpha component of this color in the range [0-1].
   */
  val alpha: Double
}
