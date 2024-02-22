@file:JsModule("vscode")

package vscode

/**
 * Controls how the task channel is used between tasks
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TaskPanelKind {
  companion object {
    /**
     * Shares a panel with other tasks. This is the default.
     */
    val Shared: TaskPanelKind

    /**
     * Uses a dedicated panel for this tasks. The panel is not
     * shared with other tasks.
     */
    val Dedicated: TaskPanelKind

    /**
     * Creates a new panel whenever this task is executed.
     */
    val New: TaskPanelKind
  }
}
