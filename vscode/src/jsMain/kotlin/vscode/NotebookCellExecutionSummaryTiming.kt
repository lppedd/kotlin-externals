package vscode

external interface NotebookCellExecutionSummaryTiming {
  /**
   * Execution start time.
   */
  val startTime: Int

  /**
   * Execution end time.
   */
  val endTime: Int
}
