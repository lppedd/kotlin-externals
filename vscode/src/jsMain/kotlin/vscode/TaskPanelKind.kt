@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Controls how the task channel is used between tasks
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TaskPanelKind {
  companion object {
    /**
     * Shares a panel with other tasks. This is the default.
     */
    @JsIntValue(1)
    val Shared: TaskPanelKind

    /**
     * Uses a dedicated panel for this tasks. The panel is not
     * shared with other tasks.
     */
    @JsIntValue(2)
    val Dedicated: TaskPanelKind

    /**
     * Creates a new panel whenever this task is executed.
     */
    @JsIntValue(3)
    val New: TaskPanelKind
  }
}
