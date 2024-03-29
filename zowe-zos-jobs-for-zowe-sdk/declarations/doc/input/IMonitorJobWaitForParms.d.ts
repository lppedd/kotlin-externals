import { JOB_STATUS } from "../../types/JobStatus";
/**
 * MonitorJobs "waitFor..." APIs parameters interface
 * @export
 * @interface IMonitorJobParms
 */
export interface IMonitorJobWaitForParms {
    /**
     * The z/OS JOBID for the job to monitor. No pre-validation of the JOBID (other than its presence) is performed.
     * Any errors that you receive regarding invalid JOBID/JOBNAME will be surfaced by z/OSMF. Ensure that your
     * JOBID specification adheres to the z/OS standards.
     * @type {string}
     * @memberof IJob
     */
    jobid: string;
    /**
     * The z/OS JOBNAME for the job to monitor. No pre-validation of the JOBNAME (other than its presence) is performed.
     * Any errors that you receive regarding invalid JOBID/JOBNAME will be surfaced by z/OSMF. Ensure that your
     * JOBNAME specification adheres to the z/OS standards.
     * @type {string}
     * @memberof IJob
     */
    jobname: string;
    /**
     * Watch delay is the polling delay in milliseconds. MonitorJobs will poll every "watchDelay" milliseconds for the
     * status of the job that is being monitored. Use in conjunction with "attempts" to specify your maximum wait
     * for the expected status.
     * Default: MonitorJobs.DEFAULT_WATCHER_DELAY
     * @type {number}
     * @memberof IMonitorJobParms
     */
    watchDelay?: number;
    /**
     * The job status (see z/OSMF Jobs REST APIs documentation - and the JOB_STATUS type for possible options) to
     * wait for. Note that if the job's status is "further" along in the logical progression (see the JOB_STATUS
     * documentation for full details) the "waitFor..." API methods will return immediately with the current status.
     * Default: MonitorJobs.DEFAULT_STATUS.
     * @type {JOB_STATUS}
     * @memberof IMonitorJobParms
     */
    status?: JOB_STATUS;
    /**
     * Maximum number of poll attempts. Use in conjunction with "watchDelay" to specify your maximum wait
     * for the expected status.
     * Default: MonitorJobs.DEFAULT_ATTEMPTS.
     * @type {number}
     * @memberof IMonitorJobParms
     */
    attempts?: number;
    [key: string]: any;
}
