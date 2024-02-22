@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.ICancelJobParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFeedback

/**
 * Class to handle deletion of job information
 */
external class CancelJobs {
  companion object {
    /**
     * Cancel and purge a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - job name to be translated into parms object
     * @param {string} jobid - job id to be translated into parms object
     * @return {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    fun cancelJob(
      session: AbstractSession,
      jobname: String,
      jobid: String,
      version: String = definedExternally,
    ): Promise<IJobFeedback?>

    /**
     * Cancel and purge a job
     * Alternative version of the cancel API accepting an IJob object returned from other APIs such as GetJobs and SubmitJobs
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job that you want to cancel
     * @param {string} version - version of cancel request
     * @return {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    fun cancelJobForJob(
      session: AbstractSession,
      job: IJob,
      version: CancelJobsCancelJobForJobVersion = definedExternally,
    ): Promise<IJobFeedback?>

    /**
     * Cancel and purge a job
     * Full version of the API with a parameter object
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICancelJobParms} parms - parm object (see ICancelJobParms interface for details)
     * @return {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    fun cancelJobCommon(
      session: AbstractSession,
      parms: ICancelJobParms,
    ): Promise<IJobFeedback?>
  }
}
