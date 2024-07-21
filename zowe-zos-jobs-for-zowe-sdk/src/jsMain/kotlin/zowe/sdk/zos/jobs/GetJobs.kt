@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.ICommonJobParms
import zowe.sdk.zos.jobs.doc.input.IGetJobsParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFile

/**
 * Class to handle obtaining of z/OS batch job information
 */
external class GetJobs {
  companion object {
    /**
     * Get jobs (defaults to the user ID of the session as owner)
     * @param session z/OSMF connection info
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobs(session: AbstractSession): Promise<Array<IJob>>

    /**
     * Get jobs that match a job name preixl
     *
     * Defaults to jobs owned by the user ID in the session.
     * @param session z/OSMF connection info
     * @param prefix job name prefix for which to list jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobsByPrefix(
      session: AbstractSession,
      prefix: String,
    ): Promise<Array<IJob>>

    /**
     * Get jobs that are owned by a certain user or pattern of users
     * @param session z/OSMF connection info
     * @param owner owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobsByOwner(
      session: AbstractSession,
      owner: String,
    ): Promise<Array<IJob>>

    /**
     * Get a list of jobs that match an owner and prefix
     * @param session z/OSMF connection info
     * @param owner owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @param prefix prefix for which to get jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobsByOwnerAndPrefix(
      session: AbstractSession,
      owner: String,
      prefix: String,
    ): Promise<Array<IJob>>

    /**
     * Get a list of jobs that match various parameters
     * @param session z/OSMF connection info
     * @param {string}
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobsByParameters(
      session: AbstractSession,
      params: IGetJobsParms,
    ): Promise<Array<IJob>>

    /**
     * Get a single job object from an input job id
     * @param session z/OSMF connection info
     * @param jobid the job ID for the job for which you want to get status
     * @return promise that resolves to an IJob object from an input jobid
     */
    fun getJob(
      session: AbstractSession,
      jobid: String,
    ): Promise<IJob>

    /**
     * Get jobs filtered by owner and prefix.
     * @param session z/OSMF connection info
     * @param params parm object (see IGetJobsParms interface for details)
     * @return promise that resolves to an array of IJob objects (matching jobs)
     */
    fun getJobsCommon(
      session: AbstractSession,
      params: IGetJobsParms = definedExternally,
    ): Promise<Array<IJob>>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @param session z/OSMF connection info
     * @param jobname the job name for the job for which you want to get status
     * @param jobid the job ID for the job for which you want to get status
     * @return promise that resolves to an IJob object representing the job
     */
    fun getStatus(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<IJob>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     *
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.  Even though the parameter and return
     * value are of the same type, the IJob object returned will have the
     * current status of the job.
     * @param session z/OSMF connection info
     * @param job job object
     * @return promise that resolves to an IJob object representing the job
     */
    fun getStatusForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<IJob>

    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @param session z/OSMF connection info
     * @param parms parm object (see ICommonJobParms interface for details)
     * @return promise that resolves to an IJob object representing the job
     */
    fun getStatusCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<IJob>

    /**
     * Get a list of all spool files for a job.
     * @param session z/OSMF connection info
     * @param jobname the job name for the job for which you want to get a list of spool files
     * @param jobid the job ID for the job for which you want to get a list of spool files
     * @return promise that resolves to an array of IJobFile objects
     */
    fun getSpoolFiles(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<Array<IJobFile>>

    /**
     * Get a list of all job spool files for a job
     *
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @param session z/OSMF connection info
     * @param job the job for which you would like to get a list of job spool files
     * @return promise that resolves to an array of IJobFile objects
     */
    fun getSpoolFilesForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<Array<IJobFile>>

    /**
     * Get a list of all job spool files for a job.
     * @param session z/OSMF connection info
     * @param parms parm object (see for details)
     * @return promise that resolves to an array of IJobFile objectsl
     */
    fun getSpoolFilesCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<Array<IJobFile>>

    /**
     * Get JCL from a job.
     * @param session z/OSMF connection info
     * @param jobname the job name for the job for which you want to retrieve JCL
     * @param jobid the job ID for the job for which you want to retrieve JCL
     * @return job document on resolve
     */
    fun getJcl(
      session: AbstractSession,
      jobname: String,
      jobid: String,
    ): Promise<String>

    /**
     * Get JCL from a job.
     *
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @param session z/OSMF connection info
     * @param job the job for which you would like to retrieve JCL
     * @return promise that resolves to JCL content
     */
    fun getJclForJob(
      session: AbstractSession,
      job: IJob,
    ): Promise<String>

    /**
     * Get the JCL that was used to submit a job.
     * @param session z/OSMF connection info
     * @param parms parm object (see ICommonJobParms interface for details)
     * @return promise that resolves to the JCL content
     */
    fun getJclCommon(
      session: AbstractSession,
      parms: ICommonJobParms,
    ): Promise<String>

    /**
     * Get spool content from a job (keeping naming convention patter with this duplication function).
     * @param session z/OSMF connection info
     * @param jobFile the spool file for which you want to retrieve the content
     * @param encoding the code page to use for EBCDIC translation
     * @return promise that resolves to the spool content
     */
    fun getSpoolContent(
      session: AbstractSession,
      jobFile: IJobFile,
      encoding: String = definedExternally,
    ): Promise<String>

    /**
     * Get spool content from a job using the job name, job ID, and spool ID number from z/OSMF
     * @param session z/OSMF connection info
     * @param jobname the job name for the job containing the spool content
     * @param jobid the job id for the job containing the spool content
     * @param spoolId id number assigned by zosmf that identifies the particular job spool file (DD)
     * @param encoding the code page to use for EBCDIC translation
     * @return promise that resolves to the spool content
     */
    fun getSpoolContentById(
      session: AbstractSession,
      jobname: String,
      jobid: String,
      spoolId: Int,
      encoding: String = definedExternally,
    ): Promise<String>

    /**
     * Get spool content from a job.
     * @param session z/OSMF connection info
     * @param jobFile the spool file for which you want to retrieve the content
     * @param encoding the code page to use for EBCDIC translation
     * @return promise that resolves to the spool content
     */
    fun getSpoolContentCommon(
      session: AbstractSession,
      jobFile: IJobFile,
      encoding: String = definedExternally,
    ): Promise<String>
  }
}
