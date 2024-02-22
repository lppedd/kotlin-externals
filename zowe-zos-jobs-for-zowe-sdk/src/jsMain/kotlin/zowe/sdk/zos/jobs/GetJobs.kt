@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.ICommonJobParms
import zowe.sdk.zos.jobs.doc.input.IGetJobsParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFile

// unhandled import: AbstractSession from "@zowe/imperative"
// unhandled import: ICommonJobParms from "./"
// unhandled import: IGetJobsParms from "./"
// unhandled import: IJob from "./"
// unhandled import: IJobFile from "./"

/**
 * Class to handle obtaining of z/OS batch job information
 * @export
 * @class GetJobs
 */

external class GetJobs {
  companion object {
    /**
     * Get jobs (defaults to the user ID of the session as owner)
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobs(session: AbstractSession): Promise<Array<IJob>>

    /**
     * Get jobs that match a job name preixl
     * Defaults to jobs owned by the user ID in the session.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} prefix - job name prefix for which to list jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobsByPrefix(
      session: AbstractSession,
      prefix: String,
    ): Promise<Array<IJob>>

    /**
     * Get jobs that are owned by a certain user or pattern of users
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} owner - owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobsByOwner(
      session: AbstractSession,
      owner: String,
    ): Promise<Array<IJob>>

    /**
     * Get a list of jobs that match an owner and prefix
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} owner - owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @param {string} prefix - prefix for which to get jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobsByOwnerAndPrefix(
      session: AbstractSession,
      owner: String,
      prefix: String,
    ): Promise<Array<IJob>>

    /**
     * Get a list of jobs that match various parameters
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string}
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobsByParameters(
      session: AbstractSession,
      params: IGetJobsParms,
    ): Promise<Array<IJob>>

    /**
     * Get a single job object from an input job id
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobid - the job ID for the job for which you want to get status
     * @return {Promise<IJob>} - promise that resolves to an IJob object from an input jobid
     * @memberof GetJobs
     */
    fun getJob(
      session: AbstractSession,
      jobid: String,
    ): Promise<IJob>

    /**
     * Get jobs filtered by owner and prefix.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IGetJobsParms} params - parm object (see IGetJobsParms interface for details)
     * @return {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    fun getJobsCommon(
      session: AbstractSession,
      params: IGetJobsParms = definedExternally,
    ): Promise<Array<IJob>>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to get status
     * @param {string} jobid - the job ID for the job for which you want to get status
     * @return {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    fun getStatus(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<IJob>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.  Even though the parameter and return
     * value are of the same type, the IJob object returned will have the
     * current status of the job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - job object
     * @return {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    fun getStatusForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<IJob>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see ICommonJobParms interface for details)
     * @return {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    fun getStatusCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<IJob>

    /**
     * Get a list of all spool files for a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to get a list of spool files
     * @param {string} jobid - the job ID for the job for which you want to get a list of spool files
     * @return {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objects
     * @memberof GetJobs
     */
    fun getSpoolFiles(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<Array<IJobFile>>

    /**
     * Get a list of all job spool files for a job
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job for which you would like to get a list of job spool files
     * @return {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objects
     * @memberof GetJobs
     */
    fun getSpoolFilesForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<Array<IJobFile>>

    /**
     * Get a list of all job spool files for a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see for details)
     * @return {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objectsl
     * @memberof GetJobs
     */
    fun getSpoolFilesCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<Array<IJobFile>>

    /**
     * Get JCL from a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to retrieve JCL
     * @param {string} jobid - the job ID for the job for which you want to retrieve JCL
     * @return {Promise<IJob>} - job document on resolve
     * @memberof GetJobs
     */
    fun getJcl(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<String>

    /**
     * Get JCL from a job.
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job for which you would like to retrieve JCL
     * @return {Promise<string>} - promise that resolves to JCL content
     * @memberof GetJobs
     */
    fun getJclForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<String>

    /**
     * Get the JCL that was used to submit a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see ICommonJobParms interface for details)
     * @return {Promise<string>} - promise that resolves to the JCL content
     * @memberof GetJobs
     */
    fun getJclCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<String>

    /**
     * Get spool content from a job (keeping naming convention patter with this duplication function).
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobFile - the spool file for which you want to retrieve the content
     * @return {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    fun getSpoolContent(
      session: AbstractSession,
      jobFile: IJobFile,
    ): Promise<String>

    /**
     * Get spool content from a job using the job name, job ID, and spool ID number from z/OSMF
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobname - the job name for the job containing the spool content
     * @param jobid - the job id for the job containing the spool content
     * @param spoolId - id number assigned by zosmf that identifies the particular job spool file (DD)
     * @return {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    fun getSpoolContentById(
      session: AbstractSession,
      jobname: String,
      jobid: String,
      spoolId: Double,
    ): Promise<String>

    /**
     * Get spool content from a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobFile - the spool file for which you want to retrieve the content
     * @return {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    fun getSpoolContentCommon(
      session: AbstractSession,
      jobFile: IJobFile,
    ): Promise<String>
  }
}
