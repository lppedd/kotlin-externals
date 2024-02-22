@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.IDeleteJobParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFeedback

/**
 * Class to handle deletion of job information
 */
external class DeleteJobs {
  companion object {
    /**
     * Cancel and purge a job
     *
     * @param session z/OSMF connection info
     * @param jobname job name to be translated into parms object
     * @param jobid job id to be translated into parms object
     * @return promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     */
    fun deleteJob(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<IJobFeedback?>

    /**
     * Cancel and purge a job
     *
     * Alternative version of the delete API accepting an IJob object returned from other APIs such as GetJobs and SubmitJobs
     *
     * @param session z/OSMF connection info
     * @param job the job that you want to delete
     * @param modifyVersion version of the X-IBM-Job-Modify-Version header to use (see ZosmfHeaders)
     * @return promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     */
    fun deleteJobForJob(
      session: AbstractSession,
      job: IJob,
      modifyVersion: DeleteJobsDeleteJobForJobModifyVersion = definedExternally,
    ): Promise<IJobFeedback?>

    /**
     * Cancel and purge a job
     *
     * Full version of the API with a parameter object
     *
     * @param session z/OSMF connection info
     * @param parms parm object (see IDeleteJobParms interface for details)
     * @return promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     */
    fun deleteJobCommon(
      session: AbstractSession,
      parms: IDeleteJobParms,
    ): Promise<IJobFeedback?>
  }
}
