package vscode

import seskar.js.JsIntValue

/**
 * The scope of a task.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TaskScope {
  companion object {
    /**
     * The task is a global task. Global tasks are currently not supported.
     */
    @JsIntValue(1)
    val Global: TaskScope

    /**
     * The task is a workspace task
     */
    @JsIntValue(2)
    val Workspace: TaskScope
  }
}
