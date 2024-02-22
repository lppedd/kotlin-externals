@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents a notebook editor that is attached to a [NotebookDocument].
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NotebookEditorRevealType {
  companion object {
    /**
     * The range will be revealed with as little scrolling as possible.
     */
    @JsIntValue(0)
    val Default: NotebookEditorRevealType

    /**
     * The range will always be revealed in the center of the viewport.
     */
    @JsIntValue(1)
    val InCenter: NotebookEditorRevealType

    /**
     * If the range is outside the viewport, it will be revealed in the center of the viewport.
     * Otherwise, it will be revealed with as little scrolling as possible.
     */
    @JsIntValue(2)
    val InCenterIfOutsideViewport: NotebookEditorRevealType

    /**
     * The range will always be revealed at the top of the viewport.
     */
    @JsIntValue(3)
    val AtTop: NotebookEditorRevealType
  }
}
