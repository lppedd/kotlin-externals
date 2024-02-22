import { AbstractSession } from "@zowe/imperative";
import { JOB_STATUS } from "./types/JobStatus";
import { IJob } from "./doc/response/IJob";
import { IMonitorJobWaitForParms } from "./doc/input/IMonitorJobWaitForParms";
/**
 * APIs for monitoring the status of a job. Use these APIs to wait for a job to enter the specified status. All APIs
 * in monitor jobs invoke z/OSMF jobs REST endpoints to obtain job status information.
 * @export
 * @class MonitorJobs
 */
export declare class MonitorJobs {
    /**
     * The default amount of time (in milliseconds) to wait until the next job status poll.
     * @static
     * @memberof MonitorJobs
     */
    static readonly DEFAULT_WATCH_DELAY = 3000;
    /**
     * Default expected job status ("OUTPUT")
     * @static
     * @memberof MonitorJobs
     */
    static readonly DEFAULT_STATUS: JOB_STATUS;
    /**
     * Default number of poll attempts to check for the specified job status.
     * @static
     * @memberof MonitorJobs
     */
    static readonly DEFAULT_ATTEMPTS: number;
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
     * @returns {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    static waitForJobOutputStatus(session: AbstractSession, job: IJob): Promise<IJob>;
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
     * @returns {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    static waitForOutputStatus(session: AbstractSession, jobname: string, jobid: string): Promise<IJob>;
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
     * @returns {Promise<IJob>} - the promise to be fulfilled with IJob object (or rejected with an ImperativeError)
     * @memberof MonitorJobs
     */
    static waitForStatusCommon(session: AbstractSession, parms: IMonitorJobWaitForParms): Promise<IJob>;
    /**
     * Obtain an instance of the app logger (Brightside).
     * @private
     * @static
     * @type {Logger}
     * @memberof MonitorJobs
     */
    private static log;
    /**
     * "Polls" (sets timeouts and continuously checks) for the status of the job to match the desired status.
     * @private
     * @static
     * @param {AbstractSession} session - a Rest client session for z/OSMF
     * @param {IMonitorJobWaitForParms} parms - The monitor jobs parms (see interface for details)
     * @returns {Promise<IJob>} - Fulfill when the status changes as expected
     * @memberof MonitorJobs
     */
    private static pollForStatus;
    /**
     * Checks the status of the job for the expected status (OR that the job has progressed passed the expected status).
     * @private
     * @static
     * @param {AbstractSession} session - the session to initiate the z/OSMF getJobStatus request
     * @param {IMonitorJobWaitForParms} parms - the monitor jobs parameters containing the jobname, jobid, status, etc.
     * @returns {Promise<boolean>} - promise to fulfill when the job status is obtained (or imperative error)
     * @memberof MonitorJobs
     */
    private static checkStatus;
    /**
     * Constructs the default error message (to be thrown via ImperativeError) for the monitor jobs APIs
     * @private
     * @static
     * @param {IMonitorJobWaitForParms} parms - The parameters passed to the API
     * @param {string} details - Additional error details string
     * @returns {string} - The error string to be thrown via ImperativeError
     * @memberof MonitorJobs
     */
    private static constructErrorMsg;
}
