package zowe.sdk.zos.jobs.doc.response

/**
 * Job interface for when a job is submitted
 */
external interface IJobSubmit {
  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String

  /**
   * status of the job
   */
  var status: String

  /**
   * return code of the job
   */
  var retcode: String
}
