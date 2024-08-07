@file:JsModule("vscode")

package vscode

/**
 * A reference to one of the workbench colors as defined in [Theme Color](https://code.visualstudio.com/api/references/theme-color).
 * Using a theme color is preferred over a custom color as it gives theme authors and users the possibility to change the color.
 */
external class ThemeColor {
  /**
   * Creates a reference to a theme color.
   *
   * @param id of the color.
   *   The available colors are listed in [Theme Color](https://code.visualstudio.com/api/references/theme-color).
   */
  constructor(id: String)
}
