@file:JsModule("vscode")

package vscode

/**
 * Represents a notebook editor that is attached to a [NotebookDocument notebook].
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NotebookEditorRevealType {
  companion object {
    /**
     * The range will be revealed with as little scrolling as possible.
     */
    val Default: NotebookEditorRevealType

    /**
     * The range will always be revealed in the center of the viewport.
     */
    val InCenter: NotebookEditorRevealType

    /**
     * If the range is outside the viewport, it will be revealed in the center of the viewport.
     * Otherwise, it will be revealed with as little scrolling as possible.
     */
    val InCenterIfOutsideViewport: NotebookEditorRevealType

    /**
     * The range will always be revealed at the top of the viewport.
     */
    val AtTop: NotebookEditorRevealType
  }
}
