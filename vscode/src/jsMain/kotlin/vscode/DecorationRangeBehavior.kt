@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Describes the behavior of decorations when typing/editing at their edges.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DecorationRangeBehavior {
  companion object {
    /**
     * The decoration's range will widen when edits occur at the start or end.
     */
    @JsIntValue(0)
    val OpenOpen: DecorationRangeBehavior

    /**
     * The decoration's range will not widen when edits occur at the start or end.
     */
    @JsIntValue(1)
    val ClosedClosed: DecorationRangeBehavior

    /**
     * The decoration's range will widen when edits occur at the start, but not at the end.
     */
    @JsIntValue(2)
    val OpenClosed: DecorationRangeBehavior

    /**
     * The decoration's range will widen when edits occur at the end, but not at the start.
     */
    @JsIntValue(3)
    val ClosedOpen: DecorationRangeBehavior
  }
}
