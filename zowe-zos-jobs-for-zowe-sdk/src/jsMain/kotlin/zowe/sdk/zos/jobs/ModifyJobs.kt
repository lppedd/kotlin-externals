@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.IModifyJobOptions
import zowe.sdk.zos.jobs.doc.input.IModifyJobParms
import zowe.sdk.zos.jobs.doc.response.IJobFeedback

/**
 * Class to handle modify of jobclass and holdStatus information
 */
external class ModifyJobs {
  companion object {
    /**
     * Modify a job
     *
     * @param session z/OSMF connection info
     * @param parms parms object (see IModifyJobParms interface for details)
     * @param options options object (see IModifyJobOptions interface for details)
     * @return promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     */
    fun modifyJob(
      session: AbstractSession,
      parms: IModifyJobParms,
      options: IModifyJobOptions,
    ): Promise<IJobFeedback?>

    /**
     * Modify a job
     *
     * Full version of the API with a parameter object
     *
     * @param session z/OSMF connection info
     * @param parms parm object (see IModifyJobParms interface for details)
     * @param options options object (see IModifyJobOptions interface for details)
     * @return promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     */
    fun modifyJobCommon(
      session: AbstractSession,
      parms: IModifyJobParms,
      options: IModifyJobOptions,
    ): Promise<IJobFeedback?>
  }
}
