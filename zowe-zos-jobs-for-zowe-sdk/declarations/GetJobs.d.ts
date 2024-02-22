import { AbstractSession } from "@zowe/imperative";
import { ICommonJobParms, IGetJobsParms, IJob, IJobFile } from "./";
/**
 * Class to handle obtaining of z/OS batch job information
 * @export
 * @class GetJobs
 */
export declare class GetJobs {
    /**
     * Get jobs (defaults to the user ID of the session as owner)
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobs(session: AbstractSession): Promise<IJob[]>;
    /**
     * Get jobs that match a job name preixl
     * Defaults to jobs owned by the user ID in the session.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} prefix - job name prefix for which to list jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobsByPrefix(session: AbstractSession, prefix: string): Promise<IJob[]>;
    /**
     * Get jobs that are owned by a certain user or pattern of users
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} owner - owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobsByOwner(session: AbstractSession, owner: string): Promise<IJob[]>;
    /**
     * Get a list of jobs that match an owner and prefix
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} owner - owner for which to get jobs. Supports wildcard e.g. IBMU* returns jobs owned by
     *                         all users whose ID beings with "IBMU"
     * @param {string} prefix - prefix for which to get jobs. Supports wildcard e.g. JOBNM*
     *                          returns jobs with names starting with "JOBNM"
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobsByOwnerAndPrefix(session: AbstractSession, owner: string, prefix: string): Promise<IJob[]>;
    /**
     * Get a list of jobs that match various parameters
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string}
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobsByParameters(session: AbstractSession, params: IGetJobsParms): Promise<IJob[]>;
    /**
     * Get a single job object from an input job id
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobid - the job ID for the job for which you want to get status
     * @returns {Promise<IJob>} - promise that resolves to an IJob object from an input jobid
     * @memberof GetJobs
     */
    static getJob(session: AbstractSession, jobid: string): Promise<IJob>;
    /**
     * Get jobs filtered by owner and prefix.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IGetJobsParms} params - parm object (see IGetJobsParms interface for details)
     * @returns {Promise<IJob[]>} - promise that resolves to an array of IJob objects (matching jobs)
     * @memberof GetJobs
     */
    static getJobsCommon(session: AbstractSession, params?: IGetJobsParms): Promise<IJob[]>;
    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to get status
     * @param {string} jobid - the job ID for the job for which you want to get status
     * @returns {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    static getStatus(session: AbstractSession, jobname: string, jobid: string): Promise<IJob>;
    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.  Even though the parameter and return
     * value are of the same type, the IJob object returned will have the
     * current status of the job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - job object
     * @returns {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    static getStatusForJob(session: AbstractSession, job: IJob): Promise<IJob>;
    /**
     * Get the status and other details (e.g. owner, return code) for a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see ICommonJobParms interface for details)
     * @returns {Promise<IJob>} - promise that resolves to an IJob object representing the job
     * @memberof GetJobs
     */
    static getStatusCommon(session: AbstractSession, parms: ICommonJobParms): Promise<IJob>;
    /**
     * Get a list of all spool files for a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to get a list of spool files
     * @param {string} jobid - the job ID for the job for which you want to get a list of spool files
     * @returns {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objects
     * @memberof GetJobs
     */
    static getSpoolFiles(session: AbstractSession, jobname: string, jobid: string): Promise<IJobFile[]>;
    /**
     * Get a list of all job spool files for a job
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job for which you would like to get a list of job spool files
     * @returns {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objects
     * @memberof GetJobs
     */
    static getSpoolFilesForJob(session: AbstractSession, job: IJob): Promise<IJobFile[]>;
    /**
     * Get a list of all job spool files for a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see for details)
     * @returns {Promise<IJobFile[]>} - promise that resolves to an array of IJobFile objectsl
     * @memberof GetJobs
     */
    static getSpoolFilesCommon(session: AbstractSession, parms: ICommonJobParms): Promise<IJobFile[]>;
    /**
     * Get JCL from a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - the job name for the job for which you want to retrieve JCL
     * @param {string} jobid - the job ID for the job for which you want to retrieve JCL
     * @returns {Promise<IJob>} - job document on resolve
     * @memberof GetJobs
     */
    static getJcl(session: AbstractSession, jobname: string, jobid: string): Promise<string>;
    /**
     * Get JCL from a job.
     * Alternate version of the API that accepts an IJob object returned by
     * other APIs such as SubmitJobs.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job for which you would like to retrieve JCL
     * @returns {Promise<string>} - promise that resolves to JCL content
     * @memberof GetJobs
     */
    static getJclForJob(session: AbstractSession, job: IJob): Promise<string>;
    /**
     * Get the JCL that was used to submit a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICommonJobParms} parms - parm object (see ICommonJobParms interface for details)
     * @returns {Promise<string>} - promise that resolves to the JCL content
     * @memberof GetJobs
     */
    static getJclCommon(session: AbstractSession, parms: ICommonJobParms): Promise<string>;
    /**
     * Get spool content from a job (keeping naming convention patter with this duplication function).
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobFile - the spool file for which you want to retrieve the content
     * @returns {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    static getSpoolContent(session: AbstractSession, jobFile: IJobFile): Promise<string>;
    /**
     * Get spool content from a job using the job name, job ID, and spool ID number from z/OSMF
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobname - the job name for the job containing the spool content
     * @param jobid - the job id for the job containing the spool content
     * @param spoolId - id number assigned by zosmf that identifies the particular job spool file (DD)
     * @returns {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    static getSpoolContentById(session: AbstractSession, jobname: string, jobid: string, spoolId: number): Promise<string>;
    /**
     * Get spool content from a job.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobFile - the spool file for which you want to retrieve the content
     * @returns {Promise<string>} - promise that resolves to the spool content
     * @memberof GetJobs
     */
    static getSpoolContentCommon(session: AbstractSession, jobFile: IJobFile): Promise<string>;
    private static filterResultsByStatuses;
}
