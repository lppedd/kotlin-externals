package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for various job APIs
 */
external interface ICommonJobParms {
  /**
   * job id for a job
   */
  var jobid: String

  /**
   * job name for a job
   */
  var jobname: String
}
