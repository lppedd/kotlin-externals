import { AbstractSession } from "@zowe/imperative";
import { IModifyJobParms } from "./doc/input/IModifyJobParms";
import { IModifyJobOptions } from "./doc/input/IModifyJobOptions";
import { IJobFeedback } from "./doc/response/IJobFeedback";
/**
 * Class to handle modify of jobclass and holdStatus information
 * @export
 * @class ModifyJobs
 */
export declare class ModifyJobs {
    /**
     * Modify a job
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IModifyJobParms} parms - parms object (see IModifyJobParms interface for details)
     * @param {IModifyJobOptions} options - options object (see IModifyJobOptions interface for details)
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof ModifyJobs
     */
    static modifyJob(session: AbstractSession, parms: IModifyJobParms, options: IModifyJobOptions): Promise<undefined | IJobFeedback>;
    /**
     * Modify a job
     * Full version of the API with a parameter object
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IModifyJobParms} parms - parm object (see IModifyJobParms interface for details)
     * @param {IModifyJobOptions} options - options object (see IModifyJobOptions interface for details)
     * @returns {Promise<undefined|IJobFeedback>} - promise of undefined, or IJobFeedback object returned by API if modifyVersion is 2.0
     * @memberof ModifyJobs
     */
    static modifyJobCommon(session: AbstractSession, parms: IModifyJobParms, options: IModifyJobOptions): Promise<undefined | IJobFeedback>;
    /**
     * @returns {Logger}
     */
    private static get log();
}
