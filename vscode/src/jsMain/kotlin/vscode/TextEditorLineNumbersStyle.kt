@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Rendering style of the line numbers.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TextEditorLineNumbersStyle {
  companion object {
    /**
     * Do not render the line numbers.
     */
    @JsIntValue(0)
    val Off: TextEditorLineNumbersStyle

    /**
     * Render the line numbers.
     */
    @JsIntValue(1)
    val On: TextEditorLineNumbersStyle

    /**
     * Render the line numbers with values relative to the primary cursor location.
     */
    @JsIntValue(2)
    val Relative: TextEditorLineNumbersStyle
  }
}
