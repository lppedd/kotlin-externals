@file:JsModule("vscode")

package vscode

/**
 * A file decoration represents metadata that can be rendered with a file.
 */
external class FileDecoration {
  /**
   * Creates a new decoration.
   *
   * @param badge A letter that represents the decoration.
   * @param tooltip The tooltip of the decoration.
   * @param color The color of the decoration.
   */
  constructor(
    badge: String = definedExternally,
    tooltip: String = definedExternally,
    color: ThemeColor = definedExternally,
  )

  /**
   * A very short string that represents this decoration.
   */
  var badge: String?

  /**
   * A human-readable tooltip for this decoration.
   */
  var tooltip: String?

  /**
   * The color of this decoration.
   */
  var color: ThemeColor?

  /**
   * A flag expressing that this decoration should be
   * propagated to its parents.
   */
  var propagate: Boolean?
}
