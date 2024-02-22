/**
 * Job feedback interface
 * @export
 * @interface IJobFeedback
 */
export interface IJobFeedback {
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
     * Original job id
     * @type {string}
     * @memberof IJobFeedback
     */
    "original-jobid": string;
    /**
     * Job owner
     * @type {string}
     * @memberof IJobComplete
     */
    owner: string;
    /**
     * Member
     * @type {string}
     * @memberof IJobFeedback
     */
    member: string;
    /**
     * System name
     * @type {string}
     * @memberof IJobFeedback
     */
    sysname: string;
    /**
     * unique identifier of job (substitute of job name and job id)
     * @type {string}
     * @memberof IJob
     */
    "job-correlator": string;
    /**
     * status of the job
     * @type {string}
     * @memberof IJob
     */
    status: string;
    /**
     * Internal code
     * @type {string}
     * @memberof IJobFeedback
     */
    "internal-code": string;
    /**
     * Message
     * @type {string}
     * @memberof IJobFeedback
     */
    message: string;
}
