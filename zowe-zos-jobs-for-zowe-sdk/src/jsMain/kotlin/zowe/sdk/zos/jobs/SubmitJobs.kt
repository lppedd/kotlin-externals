@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.*
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.ISpoolFile
import kotlin.ts.Union

/**
 * Class to handle submitting of z/OS batch jobs via z/OSMF
 * @export
 * @class SubmitJobs
 */

external class SubmitJobs {
  companion object {
    /**
     * Submit a job that resides in a z/OS data set.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobDataSet - job data set to be translated into parms object
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJob(
      session: AbstractSession,
      jobDataSet: String,
    ): Promise<IJob>

    /**
     * Submit a job that resides in a USS File.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobUSSFile - job USS File to be translated into parms object
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitUSSJob(
      session: AbstractSession,
      jobUSSFile: String,
    ): Promise<IJob>

    /**
     * Submit a job that resides in a z/OS data set or USS file.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJobParms} parms - parm object (see for details)
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJobCommon(
      session: AbstractSession,
      parms: ISubmitJobParms,
    ): Promise<IJob>

    fun submitJobCommon(
      session: AbstractSession,
      parms: ISubmitJobUSSParms,
    ): Promise<IJob>

    /**
     * Submit a string of JCL to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jcl - string of JCL that you want to be submit
     * @param {string} internalReaderRecfm - record format of the jcl you want to submit. "F" (fixed) or "V" (variable)
     * @param {string} internalReaderLrecl - logical record length of the jcl you want to submit
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJcl(
      session: AbstractSession,
      jcl: String,
      internalReaderRecfm: String = definedExternally,
      internalReaderLrecl: String = definedExternally,
    ): Promise<IJob>

    fun submitJclString(
      session: AbstractSession,
      jcl: String,
      parms: ISubmitParms,
    ): Promise<Union<IJob, Array<ISpoolFile>> /* IJob | ISpoolFile[] */>

    /**
     * Submit a JCL string to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJclParms} parms - parm object (see for details)
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJclCommon(
      session: AbstractSession,
      parms: ISubmitJclParms,
    ): Promise<IJob>

    /**
     * Submit a JCL string  to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jcl - string of JCL that you want to be submit
     * @param {string} internalReaderRecfm - record format of the jcl you want to submit. "F" (fixed) or "V" (variable).
     * @param {string} internalReaderLrecl - logical record length of the jcl you want to submit
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJclNotify(
      session: AbstractSession,
      jcl: String,
      internalReaderRecfm: String = definedExternally,
      internalReaderLrecl: String = definedExternally,
    ): Promise<IJob>

    /**
     * Submit a job from a string of JCL and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJclNotifyParm} parms - parm object (see for details)
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJclNotifyCommon(
      session: AbstractSession,
      parms: ISubmitJclNotifyParm,
    ): Promise<IJob>

    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobDataSet - job data set to be translated into parms object with assumed defaults
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJobNotify(
      session: AbstractSession,
      jobDataSet: String,
    ): Promise<IJob>

    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobUSSFile - job USS file to be translated into parms object with assumed defaults
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitUSSJobNotify(
      session: AbstractSession,
      jobUSSFile: String,
    ): Promise<IJob>

    /**
     * Submit a job from a data set and be notified whenever it reaches a certain status.
     * If not status is specified, MonitorJobs.DEFAULT_STATUS is assumed.
     * The polling interval can also be optionally controlled via parms.watchDelay.
     * If not specified, the default polling is MonitorJobs.DEFAULT_WATCH_DELAY.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJobNotifyParm} parms - parm object (see for details)
     * @return {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    fun submitJobNotifyCommon(
      session: AbstractSession,
      parms: ISubmitJobNotifyParm,
    ): Promise<IJob>

    fun submitJobNotifyCommon(
      session: AbstractSession,
      parms: ISubmitJobUSSNotifyParm,
    ): Promise<IJob>

    /**
     * Common method to handle job submit options
     * @public
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitParms } parms - Submit options
     * @param {IJob} responseJobInfo - job document for a previously submitted job
     * @return {Promise<IJob | ISpoolFile[]>} - Promise that resolves to an IJob or ISpoolFile[]
     * @memberof SubmitJobs
     */
    fun checkSubmitOptions(
      session: AbstractSession,
      parms: ISubmitParms,
      responseJobInfo: IJob,
    ): Promise<Union<IJob, Array<ISpoolFile>> /* IJob | ISpoolFile[] */>
  }
}
