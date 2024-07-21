package vscode

import seskar.js.JsIntValue

/**
 * Debug console mode used by debug session, see [DebugSessionOptions options].
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DebugConsoleMode {
  companion object {
    /**
     * Debug session should have a separate debug console.
     */
    @JsIntValue(0)
    val Separate: DebugConsoleMode

    /**
     * Debug session should share debug console with its parent session.
     * This value has no effect for sessions which do not have a parent session.
     */
    @JsIntValue(1)
    val MergeWithParent: DebugConsoleMode
  }
}
