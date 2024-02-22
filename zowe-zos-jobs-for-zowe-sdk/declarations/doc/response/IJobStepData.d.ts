/**
 * Step info on a job interface
 * @export
 * @interface IJobStepData
 */
export interface IJobStepData {
    /**
     * smfid
     * @type {string}
     * @memberof IJobStepData
     */
    smfid: string;
    /**
     * ACtive
     * @type {string}
     * @memberof IJobStepData
     */
    active: string;
    /**
     * Job relevant step
     * @type {number}
     * @memberof IJobStepData
     */
    "step-number": number;
    /**
     * Job relevant proc
     * @type {string}
     * @memberof IJobStepData
     */
    "proc-step-name": string;
    /**
     * Step for which job dd exists
     * @type {string}
     * @memberof IJobFileSimple
     */
    "step-name": string;
    /**
     * Program EXEC=
     * @type {string}
     * @memberof IJobStepData
     */
    "program-name": string;
}
