@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents different [TextEditor.revealRange] strategies in a text editor.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TextEditorRevealType {
  companion object {
    /**
     * The range will be revealed with as little scrolling as possible.
     */
    @JsIntValue(0)
    val Default: TextEditorRevealType

    /**
     * The range will always be revealed in the center of the viewport.
     */
    @JsIntValue(1)
    val InCenter: TextEditorRevealType

    /**
     * If the range is outside the viewport, it will be revealed in the center of the viewport.
     * Otherwise, it will be revealed with as little scrolling as possible.
     */
    @JsIntValue(2)
    val InCenterIfOutsideViewport: TextEditorRevealType

    /**
     * The range will always be revealed at the top of the viewport.
     */
    @JsIntValue(3)
    val AtTop: TextEditorRevealType
  }
}
