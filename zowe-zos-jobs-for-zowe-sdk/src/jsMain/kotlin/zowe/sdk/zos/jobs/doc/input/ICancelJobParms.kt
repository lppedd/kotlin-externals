package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for cancel job z/OSMF API
 */
external interface ICancelJobParms {
  /**
   * job id for the job you want to cancel
   */
  var jobid: String

  /**
   * job name for the job you want to cancel
   */
  var jobname: String

  /**
   * version of the cancel request
   */
  var version: String?
}
