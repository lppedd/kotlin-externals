/**
 * Interface for submit job API
 * @export
 * @interface ISubmitJobUSSParms
 */
export interface ISubmitJobUSSParms {
    /**
     * USS File which should contain syntactically correct JCL
     * Example value: /u/users/ibmuser/iefbr14.jcl
     * where the file contains statements like:
     *   //IEFBR14 JOB ()
     *   //RUN     EXEC PGM=IEFBR14
     * @type {string}
     * @memberof ISubmitJobUSSParms
     */
    jobUSSFile: string;
    /**
     * A string for JCL symbolic substitution
     * @type {string}
     * @memberof ISubmitJobUSSParms
     */
    jclSymbols?: string;
}
