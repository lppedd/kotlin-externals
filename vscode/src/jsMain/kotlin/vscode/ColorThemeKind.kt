@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents a color theme kind.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ColorThemeKind {
  companion object {
    /**
     * A light color theme.
     */
    @JsIntValue(1)
    val Light: ColorThemeKind

    /**
     * A dark color theme.
     */
    @JsIntValue(2)
    val Dark: ColorThemeKind

    /**
     * A dark high contrast color theme.
     */
    @JsIntValue(3)
    val HighContrast: ColorThemeKind

    /**
     * A light high contrast color theme.
     */
    @JsIntValue(4)
    val HighContrastLight: ColorThemeKind
  }
}
