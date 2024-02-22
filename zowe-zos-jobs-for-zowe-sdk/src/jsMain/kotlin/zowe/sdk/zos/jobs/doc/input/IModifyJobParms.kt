package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for change job z/OSMF API
 */
external interface IModifyJobParms {
  /**
   * job name for the job you want to change
   */
  var jobname: String

  /**
   * job id for the job you want to change
   */
  var jobid: String
}
