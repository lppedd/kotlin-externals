import { JOB_STATUS } from "../../types/JobStatus";
import { ISubmitJobUSSParms } from "./ISubmitJobUSSParms";
/**
 * Interface for submit job API
 * @export
 * @interface ISubmitJobNotifyParm
 */
export interface ISubmitJobUSSNotifyParm extends ISubmitJobUSSParms {
    /**
     * Watch delay (polling delay) that the underlying services will use
     * to report whenever a job is complete in milliseconds.
     * Default: MonitorJobs.DEFAULT_WATCHER_DELAY
     * @type {number}
     * @memberof ISubmitJobUSSNotifyParm
     */
    watchDelay?: number;
    /**
     * Status for which you'd like to be notified of a completed job.
     * Default: MonitorJobs.DEFAULT_STATUS.
     * @type {JOB_STATUS}
     * @memberof ISubmitJobUSSNotifyParm
     */
    status?: JOB_STATUS;
    /**
     * Number of attempts for which will poll before ending.
     * Default: MonitorJobs.DEFAULT_ATTEMPTS.
     * @type {number}
     * @memberof ISubmitJobUSSNotifyParm
     */
    attempts?: number;
}
