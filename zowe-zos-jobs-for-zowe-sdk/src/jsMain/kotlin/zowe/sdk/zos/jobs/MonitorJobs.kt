@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.IMonitorJobWaitForParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.types.JobStatus

/**
 * APIs for monitoring the status of a job. Use these APIs to wait for a job to enter the specified status. All APIs
 * in monitor jobs invoke z/OSMF jobs REST endpoints to obtain job status information.
 */
external class MonitorJobs {
  companion object {
    /**
     * The default amount of time (in milliseconds) to wait until the next job status poll.
     */
    @JsInt(3000)
    val DEFAULT_WATCH_DELAY: Int

    /**
     * Default expected job status ("OUTPUT")
     */
    val DEFAULT_STATUS: JobStatus

    /**
     * Default number of poll attempts to check for the specified job status.
     */
    val DEFAULT_ATTEMPTS: Int

    /**
     * Given an IJob (has jobname/jobid), waits for the status of the job to be "OUTPUT". This API will poll for
     * the OUTPUT status once every 3 seconds indefinitely. If the polling interval/duration is NOT sufficient, use
     * "waitForStatusCommon" to adjust.
     *
     * See JSDoc for "waitForStatusCommon" for full details on polling and other logic.
     *
     * @static
     * @param {AbstractSession} session - a Rest client session for z/OSMF
     * @param {IJob} job - the z/OS job to wait for (see z/OSMF Jobs APIs for details)
     * @return {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    fun waitForJobOutputStatus(
      session: AbstractSession,
      job: IJob,
    ): Promise<IJob>

    /**
     * Given the jobname/jobid, waits for the status of the job to be "OUTPUT". This API will poll for the OUTPUT status
     * once every 3 seconds indefinitely. If the polling interval/duration is NOT sufficient, use
     * "waitForStatusCommon" to adjust.
     *
     * See JSDoc for "waitForStatusCommon" for full details on polling and other logic.
     *
     * @static
     * @param {AbstractSession} session - a Rest client session for z/OSMF
     * @param {string} jobname - the z/OS jobname of the job to wait for output status (see z/OSMF Jobs APIs for details)
     * @param {string} jobid - the z/OS jobid of the job to wait for output status (see z/OSMF Jobs APIS for details)
     * @return {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    fun waitForOutputStatus(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<IJob>

    /**
     * Given jobname/jobid, checks for the desired "status" (default is "OUTPUT") continuously (based on the interval
     * and attempts specified).
     *
     * The "order" of natural job status is INPUT > ACTIVE > OUTPUT. If the requested status is earlier in the sequence
     * than the current status of the job, then the method returns immediately (since the job will never enter the
     * requested status) with the current status of the job.
     *
     * @static
     * @param {AbstractSession} session - a Rest client session for z/OSMF
     * @param {IMonitorJobWaitForParms} parms - monitor jobs parameters (see interface for details)
     * @return {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    fun waitForStatusCommon(
      session: AbstractSession,
      parms: IMonitorJobWaitForParms,
    ): Promise<IJob>
  }
}
