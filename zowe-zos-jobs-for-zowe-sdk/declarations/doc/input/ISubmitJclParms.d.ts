import { ISubmitParmsCommon } from "./ISubmitParmsCommon";
/**
 * Interface for submit JCL APIs
 * @export
 * @interface ISubmitJclParms
 */
export interface ISubmitJclParms extends ISubmitParmsCommon {
    /**
     * JCL to submit, for example:
     *   "//IEFBR14 JOB ()\n" +
     *   "//RUN     EXEC PGM=IEFBR14"
     * @type {string}
     * @memberof ISubmitJclParms
     */
    jcl: string;
}
