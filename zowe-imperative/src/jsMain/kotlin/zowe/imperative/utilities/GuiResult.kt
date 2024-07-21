package zowe.imperative.utilities

/**
 * This enum represents the possible results from isGuiAvailable.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface GuiResult {
  companion object {
    /**
     * A GUI is available
     */
    @JsInt(0)
    val GUI_AVAILABLE: GuiResult

    /**
     * No GUI because this is an SSH connection.
     */
    @JsInt(1)
    val NO_GUI_SSH: GuiResult

    /**
     * No GUI because The $DISPLAY environment variable is not set.
     */
    @JsInt(2)
    val NO_GUI_NO_DISPLAY: GuiResult
  }
}
