@file:JsModule("vscode")

package vscode

/**
 * Represents different positions for rendering a decoration in an [DecorationRenderOptions.overviewRulerLane overview ruler].
 * The overview ruler supports three lanes.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface OverviewRulerLane {
  companion object {
    /**
     * The left lane of the overview ruler.
     */
    val Left: OverviewRulerLane

    /**
     * The center lane of the overview ruler.
     */
    val Center: OverviewRulerLane

    /**
     * The right lane of the overview ruler.
     */
    val Right: OverviewRulerLane

    /**
     * All lanes of the overview ruler.
     */
    val Full: OverviewRulerLane
  }
}
