import { AbstractSession } from "@zowe/imperative";
import { IJob } from "./doc/response/IJob";
import { IDeleteJobParms } from "./doc/input/IDeleteJobParms";
import { IJobFeedback } from "./doc/response/IJobFeedback";
/**
 * Class to handle deletion of job information
 * @export
 * @class DeleteJobs
 */
export declare class DeleteJobs {
    /**
     * Cancel and purge a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - job name to be translated into parms object
     * @param {string} jobid - job id to be translated into parms object
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof DeleteJobs
     */
    static deleteJob(session: AbstractSession, jobname: string, jobid: string): Promise<undefined | IJobFeedback>;
    /**
     * Cancel and purge a job
     * Alternative version of the delete API accepting an IJob object returned from other APIs such as GetJobs and SubmitJobs
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job that you want to delete
     * @param {"1.0"| "2.0"} modifyVersion - version of the X-IBM-Job-Modify-Version header to use (see ZosmfHeaders)
     * @returns {Promise<undefined|IJobFeedback>} -  promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof DeleteJobs
     */
    static deleteJobForJob(session: AbstractSession, job: IJob, modifyVersion?: "1.0" | "2.0"): Promise<undefined | IJobFeedback>;
    /**
     * Cancel and purge a job
     * Full version of the API with a parameter object
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IDeleteJobParms} parms - parm object (see IDeleteJobParms interface for details)
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof DeleteJobs
     */
    static deleteJobCommon(session: AbstractSession, parms: IDeleteJobParms): Promise<undefined | IJobFeedback>;
    /**
     * Getter for brightside logger
     * @returns {Logger}
     */
    private static get log();
}
