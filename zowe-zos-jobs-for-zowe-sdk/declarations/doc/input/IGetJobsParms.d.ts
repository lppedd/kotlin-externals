/**
 * Interface for various GetJobs APIs
 * @export
 * @interface IGetJobsParms
 */
export interface IGetJobsParms {
    /**
     * Owner for which to obtain jobs for.
     * Default: current user
     * @type {string}
     * @memberof IGetJobsParms
     */
    owner?: string;
    /**
     * Prefix to filter when obtaining jobs.
     * Default: *
     * @type {string}
     * @memberof IGetJobsParms
     */
    prefix?: string;
    /**
     * Optional parameter to limit the returned data to only jobs that are currently active. This parameter is case-insensitive
     * Default: *
     * @type {string}
     * @memberof IGetJobsParms
     */
    status?: string;
    /**
     * Max jobs to return in a list
     * Default: JobsConstants.DEFAULT_MAX_JOBS
     * @type {number}
     * @memberof IGetJobsParms
     */
    maxJobs?: number;
    /**
     * job id for a job
     * @type {string}
     * @memberof IJob
     */
    jobid?: string;
    /**
     * Return execution data about jobs
     * @type {boolean}
     * @memberof IGetJobsParms
     */
    execData?: boolean;
}
