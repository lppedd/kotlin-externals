package zowe.sdk.zos.jobs.doc.response

/**
 * Step info on a job interface
 */
external interface IJobStepData {
  /**
   * smfid
   */
  var smfid: String

  /**
   * ACtive
   */
  var active: String

  /**
   * Job relevant step
   */
  var `step-number`: Int

  /**
   * Job relevant proc
   */
  var `proc-step-name`: String

  /**
   * Step for which job dd exists
   */
  var `step-name`: String

  /**
   * Program EXEC=
   */
  var `program-name`: String
}
