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
  constructor(red: Int, green: Int, blue: Int, alpha: Int)

  /**
   * The red component of this color in the range [0-1].
   */
  val red: Int

  /**
   * The green component of this color in the range [0-1].
   */
  val green: Int

  /**
   * The blue component of this color in the range [0-1].
   */
  val blue: Int

  /**
   * The alpha component of this color in the range [0-1].
   */
  val alpha: Int
}
