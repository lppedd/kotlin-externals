/**
 * Job interface for when a job is submitted
 * @export
 * @interface IJobSubmit
 */
export interface IJobSubmit {
    /**
     * job id for a job
     * @type {string}
     * @memberof IJob
     */
    jobid: string;
    /**
     * job name for a job
     * @type {string}
     * @memberof IJob
     */
    jobname: string;
    /**
     * status of the job
     * @type {string}
     * @memberof IJob
     */
    status: string;
    /**
     * return code of the job
     * @type {string}
     * @memberof IJob
     */
    retcode: string;
}
