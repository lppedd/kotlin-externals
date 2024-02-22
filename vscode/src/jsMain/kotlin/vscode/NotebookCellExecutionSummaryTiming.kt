package vscode

external interface NotebookCellExecutionSummaryTiming {
  /**
   * Execution start time.
   */
  val startTime: Double

  /**
   * Execution end time.
   */
  val endTime: Double
}
