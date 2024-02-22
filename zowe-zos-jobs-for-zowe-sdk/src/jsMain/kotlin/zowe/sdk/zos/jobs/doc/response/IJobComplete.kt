package zowe.sdk.zos.jobs.doc.response

/**
 * Completed job interface
 */
external interface IJobComplete {
  /**
   * unique identifier of job (substitute of job name and job id)
   */
  var `job-correlator`: String

  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * Job owner
   */
  var owner: String

  /**
   * Job class
   */
  var `class`: String

  /**
   * return code of the job
   */
  var retcode: String

  /**
   * Completion type
   */
  var `completion-type`: Int

  /**
   * Completion code
   */
  var `completion-code`: Int

  /**
   * Abend code
   */
  var `abend-code`: String
}
