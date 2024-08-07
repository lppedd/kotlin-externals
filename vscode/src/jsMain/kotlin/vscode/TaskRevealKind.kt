package vscode

import seskar.js.JsIntValue

/**
 * Controls the behaviour of the terminal's visibility.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TaskRevealKind {
  companion object {
    /**
     * Always brings the terminal to front if the task is executed.
     */
    @JsIntValue(1)
    val Always: TaskRevealKind

    /**
     * Only brings the terminal to front if a problem is detected executing the task
     * (e.g. the task couldn't be started because).
     */
    @JsIntValue(2)
    val Silent: TaskRevealKind

    /**
     * The terminal never comes to front when the task is executed.
     */
    @JsIntValue(3)
    val Never: TaskRevealKind
  }
}
