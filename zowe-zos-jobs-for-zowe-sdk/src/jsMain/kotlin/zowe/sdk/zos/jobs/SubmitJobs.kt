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
 */
external class SubmitJobs {
  companion object {
    /**
     * Submit a job that resides in a z/OS data set.
     * @param session z/OSMF connection info
     * @param jobDataSet job data set to be translated into parms object
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJob(
      session: AbstractSession,
      jobDataSet: String,
    ): Promise<IJob>

    /**
     * Submit a job that resides in a USS File.
     * @param session z/OSMF connection info
     * @param jobUSSFile job USS File to be translated into parms object
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitUSSJob(
      session: AbstractSession,
      jobUSSFile: String,
    ): Promise<IJob>

    /**
     * Submit a job that resides in a z/OS data set or USS file.
     * @param session z/OSMF connection info
     * @param parms parm object (see for details)
     * @return Promise that resolves to an IJob document with details about the submitted job
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
     * @param session z/OSMF connection info
     * @param jcl string of JCL that you want to be submitted
     * @param internalReaderRecfm record format of the jcl you want to submit. "F" (fixed) or "V" (variable)
     * @param internalReaderLrecl logical record length of the jcl you want to submit
     * @param internalReaderFileEncoding
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJcl(
      session: AbstractSession,
      jcl: String,
      internalReaderRecfm: String = definedExternally,
      internalReaderLrecl: String = definedExternally,
      internalReaderFileEncoding: String = definedExternally,
    ): Promise<IJob>

    fun submitJclString(
      session: AbstractSession,
      jcl: String,
      parms: ISubmitParms,
    ): Promise<Union<IJob, Array<ISpoolFile>> /* IJob | ISpoolFile[] */>

    /**
     * Submit a JCL string to run
     * @param session z/OSMF connection info
     * @param parms parm object (see for details)
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJclCommon(
      session: AbstractSession,
      parms: ISubmitJclParms,
    ): Promise<IJob>

    /**
     * Submit a JCL string  to run
     * @param session z/OSMF connection info
     * @param jcl string of JCL that you want to be submitted
     * @param internalReaderRecfm record format of the jcl you want to submit. "F" (fixed) or "V" (variable).
     * @param internalReaderLrecl logical record length of the jcl you want to submit
     * @param internalReaderFileEncoding
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJclNotify(
      session: AbstractSession,
      jcl: String,
      internalReaderRecfm: String = definedExternally,
      internalReaderLrecl: String = definedExternally,
      internalReaderFileEncoding: String = definedExternally,
    ): Promise<IJob>

    /**
     * Submit a job from a string of JCL and be notified whenever it reaches the default status on a default polling interval.
     * @param session z/OSMF connection info
     * @param parms parm object (see for details)
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJclNotifyCommon(
      session: AbstractSession,
      parms: ISubmitJclNotifyParm,
    ): Promise<IJob>

    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @param session z/OSMF connection info
     * @param jobDataSet job data set to be translated into parms object with assumed defaults
     * @return Promise that resolves to an IJob document with details about the submitted job
     */
    fun submitJobNotify(
      session: AbstractSession,
      jobDataSet: String,
    ): Promise<IJob>

    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @param session z/OSMF connection info
     * @param jobUSSFile job USS file to be translated into parms object with assumed defaults
     * @return Promise that resolves to an IJob document with details about the submitted job
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
     * @param session z/OSMF connection info
     * @param parms parm object (see for details)
     * @return Promise that resolves to an IJob document with details about the submitted job
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
     * @param session z/OSMF connection info
     * @param parms Submit options
     * @param responseJobInfo job document for a previously submitted job
     * @return Promise that resolves to an IJob or ISpoolFile[]
     */
    fun checkSubmitOptions(
      session: AbstractSession,
      parms: ISubmitParms,
      responseJobInfo: IJob,
    ): Promise<Union<IJob, Array<ISpoolFile>> /* IJob | ISpoolFile[] */>
  }
}
