package zowe.imperative.operations.doc

import zowe.imperative.operations.TaskStage

/**
 * Implement this interface to be able to be tracked by the CLI progress bar or GUIs
 */
external interface ITaskWithStatus {
  /**
   * What percentage complete is your task right now?
   */
  var percentComplete: Int

  /**
   * A very short message describing what is being worked on
   */
  var statusMessage: String

  /**
   * Describe the overall status of the task. If the task fails while in progress,
   * you can set this to [TaskStage.FAILED]
   */
  var stageName: TaskStage
}
