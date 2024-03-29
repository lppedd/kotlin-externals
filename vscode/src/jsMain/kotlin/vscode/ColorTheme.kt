package vscode

/**
 * Represents a color theme.
 */
external interface ColorTheme {
  /**
   * The kind of this color theme: light, dark, high contrast dark and high contrast light.
   */
  val kind: ColorThemeKind
}
