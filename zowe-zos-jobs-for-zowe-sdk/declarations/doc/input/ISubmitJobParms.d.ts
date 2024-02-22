/**
 * Interface for submit job API
 * @export
 * @interface ISubmitJobParms
 */
export interface ISubmitJobParms {
    /**
     * z/OS data set which should contain syntactically correct JCL
     * Example value: IBMUSER.PUBLIC.CNTL(IEFBR14)
     * where IEFBR14 contains statements like:
     *   //IEFBR14 JOB ()
     *   //RUN     EXEC PGM=IEFBR14
     * @type {string}
     * @memberof ISubmitJobParms
     */
    jobDataSet: string;
    /**
     * A string for JCL symbolic substitution
     * @type {string}
     * @memberof ISubmitJobParms
     */
    jclSymbols?: string;
}
