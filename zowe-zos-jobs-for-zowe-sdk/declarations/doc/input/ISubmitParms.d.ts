import { ITaskWithStatus } from "@zowe/imperative";
import { ISubmitParmsCommon } from "./ISubmitParmsCommon";
/**
 * Interface for submit job API
 * @export
 * @interface ISubmitParms
 */
export interface ISubmitParms extends ISubmitParmsCommon {
    /**
     * USS file which should contain syntactically correct JCL
     * Example value: IBMUSER.PUBLIC.CNTL(IEFBR14)
     * where IEFBR14 contains statements like:
     *   //IEFBR14 JOB ()
     *   //RUN     EXEC PGM=IEFBR14
     */
    jclSource: string;
    /**
     * Returns spool content if this option used
     */
    viewAllSpoolContent?: boolean;
    /**
     * Wait for the job to reach output status
     */
    waitForActive?: boolean;
    /**
     * Wait for the job to reach output status
     */
    waitForOutput?: boolean;
    /**
     * Local directory path to download output of the job
     */
    directory?: string;
    /**
     * A file extension to save the job output with
     */
    extension?: string;
    /**
     * The volume on which the data set is stored
     */
    volume?: string;
    /**
     * Task status object used by CLI handlers to create progress bars
     * for certain job submit requests
     * Optional
     */
    task?: ITaskWithStatus;
}
