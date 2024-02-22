/**
 * Completed job interface
 * @export
 * @interface IJobComplete
 */
export interface IJobComplete {
    /**
     * unique identifier of job (substitute of job name and job id)
     * @type {string}
     * @memberof IJob
     */
    "job-correlator": string;
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
     * Job owner
     * @type {string}
     * @memberof IJobComplete
     */
    "owner": string;
    /**
     * Job class
     * @type {string}
     * @memberof IJobComplete
     */
    "class": string;
    /**
     * return code of the job
     * @type {string}
     * @memberof IJob
     */
    retcode: string;
    /**
     * Completion type
     * @type {number}
     * @memberof IJobComplete
     */
    "completion-type": number;
    /**
     * Completion code
     * @type {number}
     * @memberof IJobComplete
     */
    "completion-code": number;
    /**
     * Abend code
     * @type {string}
     * @memberof IJobComplete
     */
    "abend-code": string;
}
