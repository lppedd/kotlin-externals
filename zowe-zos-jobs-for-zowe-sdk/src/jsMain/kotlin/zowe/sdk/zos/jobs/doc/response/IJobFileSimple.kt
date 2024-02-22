package zowe.sdk.zos.jobs.doc.response

/**
 * Condensed job response interface
 *
 * Simplified version of an IJob that can be used to
 * display job details to a user without providing too much detail.
 */
external interface IJobFileSimple {
  /**
   * ID of job that was submitted
   */
  var id: Int

  /**
   * DD name of job spool file
   */
  var ddname: String

  /**
   * Step for which job dd exists
   */
  var stepname: String

  /**
   * Total records contained within the job dd
   */
  // "record-count": number;
  // TODO(Edoardo): how to do this? In TS it is possible to have dashes
}
