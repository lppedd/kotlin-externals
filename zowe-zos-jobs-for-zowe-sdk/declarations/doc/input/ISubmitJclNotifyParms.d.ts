import { JOB_STATUS } from "../../types/JobStatus";
/**
 * Interface for submiting jobs API
 * @export
 * @interface ISubmitJclNotifyParm
 */
export interface ISubmitJclNotifyParm {
    /**
     * JCL to submit, for example:
     *   "//IEFBR14 JOB ()\n" +
     *   "//RUN     EXEC PGM=IEFBR14"
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    jcl: string;
    /**
     * Specify internal reader RECFM and corresponding http(s) headers
     * will be appended to the request accordingly
     * "F" (fixed) or "V" (variable)
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    internalReaderRecfm?: string;
    /**
     * Specify internal reader LRECL and corresponding http(s) headers
     * will be appended to the request accordingly
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    internalReaderLrecl?: string;
    /**
     * Watch delay (polling delay) that the underlying services will use
     * to report whenever a job is complete in milliseconds.
     * Default: MonitorJobs.DEFAULT_WATCHER_DELAY
     * @type {number}
     * @memberof ISubmitJclNotifyParm
     */
    watchDelay?: number;
    /**
     * Status for which you'd like to be notified of a completed job.
     * Default: MonitorJobs.DEFAULT_STATUS.
     * @type {JOB_STATUS}
     * @memberof ISubmitJclNotifyParm
     */
    status?: JOB_STATUS;
    /**
     * Number of attempts for which will poll before ending.
     * Default: MonitorJobs.DEFAULT_ATTEMPTS.
     * @type {number}
     * @memberof ISubmitJclNotifyParm
     */
    attempts?: number;
    /**
     * A string for JCL symbolic substitution
     * @type {string}
     * @memberof ISubmitJobParms
     */
    jclSymbols?: string;
}
