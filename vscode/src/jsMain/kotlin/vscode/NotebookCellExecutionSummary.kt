package vscode

/**
 * The summary of a notebook cell execution.
 */
external interface NotebookCellExecutionSummary {
  /**
   * The order in which the execution happened.
   */
  val executionOrder: Int?

  /**
   * If the execution finished successfully.
   */
  val success: Boolean?

  /**
   * The times at which execution started and ended, as unix timestamps
   */
  val timing: NotebookCellExecutionSummaryTiming?
}
