package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for delete job (cancel and purge) z/OSMF API
 */
external interface IDeleteJobParms {
  /**
   * job id for the job you want to delete
   */
  var jobid: String

  /**
   * job name for the job you want to delete
   */
  var jobname: String

  /**
   * Optional
   *
   * Version of the X-IBM-Job-Modify-Version header to use (see ZosmfHeaders)
   *
   * If omitted, functionality is the same as if specifying "1.0" - the deletion of the job is asynchronous
   *
   * If "2.0" is specified, the cancel and purge is synchronous
   */
  var modifyVersion: IDeleteJobParmsModifyVersion?
}
