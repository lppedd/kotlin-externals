/**
 * Interface for change job z/OSMF API
 * @export
 * @interface IModifyJobParms
 */
export interface IModifyJobParms {
    /**
     * job name for the job you want to change
     * @type {string}
     * @memberof IModifyJobParms
     */
    jobname: string;
    /**
     * job id for the job you want to change
     * @type {string}
     * @memberof IModifyJobParms
     */
    jobid: string;
}
