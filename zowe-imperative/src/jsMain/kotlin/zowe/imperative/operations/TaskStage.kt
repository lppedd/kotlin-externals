package zowe.imperative.operations

/**
 * Describes the current stage/status of a task in your CLI Used in operation infrastructure and for progress bars
 */
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
