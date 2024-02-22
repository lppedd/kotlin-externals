package vscode

/**
 * Run options for a task.
 */

external interface RunOptions {
  /**
   * Controls whether task variables are re-evaluated on rerun.
   */
  var reevaluateOnRerun: Boolean?
}
