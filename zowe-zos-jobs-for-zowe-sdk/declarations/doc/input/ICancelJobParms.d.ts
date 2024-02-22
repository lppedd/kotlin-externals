/**
 * Interface for cancel job z/OSMF API
 * @export
 * @interface ICancelJobParms
 */
export interface ICancelJobParms {
    /**
     * job id for the job you want to cancel
     * @type {string}
     * @memberof ICancelJobParms
     */
    jobid: string;
    /**
     * job name for the job you want to cancel
     * @type {string}
     * @memberof ICancelJobParms
     */
    jobname: string;
    /**
     * version of the cancel request
     * @type {string}
     * @memberof ICancelJobParms
     */
    version?: string;
}
