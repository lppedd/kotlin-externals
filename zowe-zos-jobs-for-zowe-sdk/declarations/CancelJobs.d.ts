import { AbstractSession } from "@zowe/imperative";
import { IJob } from "./doc/response/IJob";
import { ICancelJobParms } from "./doc/input/ICancelJobParms";
import { IJobFeedback } from "./doc/response/IJobFeedback";
/**
 * Class to handle deletion of job information
 * @export
 * @class CancelJobs
 */
export declare class CancelJobs {
    /**
     * Cancel and purge a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} jobname - job name to be translated into parms object
     * @param {string} jobid - job id to be translated into parms object
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    static cancelJob(session: AbstractSession, jobname: string, jobid: string, version?: string): Promise<undefined | IJobFeedback>;
    /**
     * Cancel and purge a job
     * Alternative version of the cancel API accepting an IJob object returned from other APIs such as GetJobs and SubmitJobs
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IJob} job - the job that you want to cancel
     * @param {string} version - version of cancel request
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    static cancelJobForJob(session: AbstractSession, job: IJob, version?: "1.0" | "2.0"): Promise<undefined | IJobFeedback>;
    /**
     * Cancel and purge a job
     * Full version of the API with a parameter object
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {ICancelJobParms} parms - parm object (see ICancelJobParms interface for details)
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof CancelJobs
     */
    static cancelJobCommon(session: AbstractSession, parms: ICancelJobParms): Promise<undefined | IJobFeedback>;
    /**
     * Getter for brightside logger
     * @returns {Logger}
     */
    private static get log();
}
