/**
 * Interface for delete job (cancel and purge) z/OSMF API
 * @export
 * @interface IDeleteJobParms
 */
export interface IDeleteJobParms {
    /**
     * job id for the job you want to delete
     * @type {string}
     * @memberof IDeleteJobParms
     */
    jobid: string;
    /**
     * job name for the job you want to delete
     * @type {string}
     * @memberof IDeleteJobParms
     */
    jobname: string;
    /**
     * Optional
     * Version of the X-IBM-Job-Modify-Version header to use (see ZosmfHeaders)
     * If omitted, functionality is the same as if specifying "1.0" - the deletion of the job is asynchronous
     * If "2.0" is specified, the cancel and purge is synchronous
     *
     * @type {"1.0" | "2.0"}
     * @memberof IDeleteJobParms
     */
    modifyVersion?: "1.0" | "2.0";
}
