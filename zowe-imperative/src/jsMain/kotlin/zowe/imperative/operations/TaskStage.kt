@file:JsModule("@zowe/imperative")

package zowe.imperative.operations

import seskar.js.JsVirtual

/**
 * Describes the current stage/status of a task in your CLI Used in operation infrastructure and for progress bars
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TaskStage {
  companion object {
    @JsInt(0)
    val IN_PROGRESS: TaskStage

    @JsInt(1)
    val COMPLETE: TaskStage

    @JsInt(2)
    val NOT_STARTED: TaskStage

    @JsInt(3)
    val FAILED: TaskStage
  }
}
