@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents the alignment of status bar items.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface StatusBarAlignment {
  companion object {
    /**
     * Aligned to the left side.
     */
    @JsIntValue(1)
    val Left: StatusBarAlignment

    /**
     * Aligned to the right side.
     */
    @JsIntValue(2)
    val Right: StatusBarAlignment
  }
}
