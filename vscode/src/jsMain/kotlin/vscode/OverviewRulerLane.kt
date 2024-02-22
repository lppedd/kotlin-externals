@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Represents different positions for rendering a decoration in an overview ruler ([DecorationRenderOptions.overviewRulerLane]).
 * The overview ruler supports three lanes.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface OverviewRulerLane {
  companion object {
    /**
     * The left lane of the overview ruler.
     */
    @JsIntValue(1)
    val Left: OverviewRulerLane

    /**
     * The center lane of the overview ruler.
     */
    @JsIntValue(2)
    val Center: OverviewRulerLane

    /**
     * The right lane of the overview ruler.
     */
    @JsIntValue(4)
    val Right: OverviewRulerLane

    /**
     * All lanes of the overview ruler.
     */
    @JsIntValue(7)
    val Full: OverviewRulerLane
  }
}
