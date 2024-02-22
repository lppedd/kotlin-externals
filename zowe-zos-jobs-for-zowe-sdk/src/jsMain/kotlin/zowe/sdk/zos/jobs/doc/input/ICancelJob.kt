package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for payload to cancel a job.
 */
external interface ICancelJob {
  /**
   * "cancel" is currently the only valid value
   */
  var request: String

  /**
   * Version, at the time of writing, 1.0 or 2.0 are accepted.
   */
  var version: String
}
