import { AbstractSession } from "@zowe/imperative";
import { IJob, ISubmitJclNotifyParm, ISubmitJclParms, ISubmitJobUSSNotifyParm, ISubmitJobNotifyParm, ISubmitJobParms, ISubmitJobUSSParms } from "./";
import { ISubmitParms } from "./doc/input/ISubmitParms";
import { ISpoolFile } from "./doc/response/ISpoolFile";
/**
 * Class to handle submitting of z/OS batch jobs via z/OSMF
 * @export
 * @class SubmitJobs
 */
export declare class SubmitJobs {
    private static readonly singleQuote;
    /**
     * Submit a job that resides in a z/OS data set.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobDataSet - job data set to be translated into parms object
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJob(session: AbstractSession, jobDataSet: string): Promise<IJob>;
    /**
     * Submit a job that resides in a USS File.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobUSSFile - job USS File to be translated into parms object
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitUSSJob(session: AbstractSession, jobUSSFile: string): Promise<IJob>;
    /**
     * Submit a job that resides in a z/OS data set or USS file.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJobParms} parms - parm object (see for details)
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJobCommon(session: AbstractSession, parms: ISubmitJobParms | ISubmitJobUSSParms): Promise<IJob>;
    /**
     * Submit a string of JCL to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jcl - string of JCL that you want to be submit
     * @param {string} internalReaderRecfm - record format of the jcl you want to submit. "F" (fixed) or "V" (variable)
     * @param {string} internalReaderLrecl - logical record length of the jcl you want to submit
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJcl(session: AbstractSession, jcl: string, internalReaderRecfm?: string, internalReaderLrecl?: string, internalReaderFileEncoding?: string): Promise<IJob>;
    static submitJclString(session: AbstractSession, jcl: string, parms: ISubmitParms): Promise<IJob | ISpoolFile[]>;
    /**
     * Submit a JCL string to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJclParms} parms - parm object (see for details)
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJclCommon(session: AbstractSession, parms: ISubmitJclParms): Promise<IJob>;
    /**
     * Submit a JCL string  to run
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jcl - string of JCL that you want to be submit
     * @param {string} internalReaderRecfm - record format of the jcl you want to submit. "F" (fixed) or "V" (variable).
     * @param {string} internalReaderLrecl - logical record length of the jcl you want to submit
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJclNotify(session: AbstractSession, jcl: string, internalReaderRecfm?: string, internalReaderLrecl?: string, internalReaderFileEncoding?: string): Promise<IJob>;
    /**
     * Submit a job from a string of JCL and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJclNotifyParm} parms - parm object (see for details)
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJclNotifyCommon(session: AbstractSession, parms: ISubmitJclNotifyParm): Promise<IJob>;
    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobDataSet - job data set to be translated into parms object with assumed defaults
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJobNotify(session: AbstractSession, jobDataSet: string): Promise<IJob>;
    /**
     * Submit a job and be notified whenever it reaches the default status on a default polling interval.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobUSSFile - job USS file to be translated into parms object with assumed defaults
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitUSSJobNotify(session: AbstractSession, jobUSSFile: string): Promise<IJob>;
    /**
     * Submit a job from a data set and be notified whenever it reaches a certain status.
     * If not status is specified, MonitorJobs.DEFAULT_STATUS is assumed.
     * The polling interval can also be optionally controlled via parms.watchDelay.
     * If not specified, the default polling is MonitorJobs.DEFAULT_WATCH_DELAY.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitJobNotifyParm} parms - parm object (see for details)
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    static submitJobNotifyCommon(session: AbstractSession, parms: ISubmitJobNotifyParm | ISubmitJobUSSNotifyParm): Promise<IJob>;
    /**
     * Common method to handle job submit options
     * @public
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ISubmitParms } parms - Submit options
     * @param {IJob} responseJobInfo - job document for a previously submitted job
     * @returns {Promise<IJob | ISpoolFile[]>} - Promise that resolves to an IJob or ISpoolFile[]
     * @memberof SubmitJobs
     */
    static checkSubmitOptions(session: AbstractSession, parms: ISubmitParms, responseJobInfo: IJob): Promise<IJob | ISpoolFile[]>;
    /**
     * Common method to watch for a job to reach a certain status whether the job was
     * submitted through raw JCL statement or through a data set containing JCL.
     * @private
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - job document for a previously submitted job
     * @param {JOB_STATUS } status - status that we want this job to reach before notifying
     * @param {number} watchDelay - delay / interval to poll
     * @returns {Promise<IJob>} - Promise that resolves to an IJob document with details about the submitted job
     * @memberof SubmitJobs
     */
    private static submitNotifyCommon;
    /**
     * Parse input string for JCL substitution
     * @param {string} symbols - JCL substitution symbols
     * @returns {IHeaderContent[]} headers - Headers to add to the request
     * @memberof SubmitJobs
     */
    private static getSubstitutionHeaders;
    /**
     * Form a header used for JCL symbol substitution
     *
     * @param {string} symName
     *     The name of the JCL substitution symbol
     *
     * @param {string} symDefs
     *       The CLI argument that contains all of the JCL substitution symbol definitions
     *
     * @param {string} valStartInx
     *       Index into symDefs to the start of the value for symName.
     *
     * @param {string} valEndInx
     *       Index into symDefs that is one past the end of the value for symName.
     *
     * @returns {IHeaderContent}
     *      Header to add to our set of headers
     * @memberof SubmitJobs
     */
    private static formSubstitutionHeader;
    /**
     * Getter for brightside logger
     * @returns {Logger}
     */
    private static get log();
}
