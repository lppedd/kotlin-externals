package zowe.sdk.zos.jobs.doc.response

/**
 * Job feedback interface
 */
external interface IJobFeedback {
  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * Original job id
   */
  var `original-jobid`: String

  /**
   * Job owner
   */
  var owner: String

  /**
   * Member
   */
  var member: String

  /**
   * System name
   */
  var sysname: String

  /**
   * unique identifier of job (substitute of job name and job id)
   */
  var `job-correlator`: String

  /**
   * status of the job
   */
  var status: String

  /**
   * Internal code
   */
  var `internal-code`: String

  /**
   * Message
   */
  var message: String
}
