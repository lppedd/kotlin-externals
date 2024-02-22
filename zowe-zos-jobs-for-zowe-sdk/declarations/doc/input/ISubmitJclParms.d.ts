/**
 * Interface for submit JCL APIs
 * @export
 * @interface ISubmitJclParms
 */
export interface ISubmitJclParms {
    /**
     * JCL to submit, for example:
     *   "//IEFBR14 JOB ()\n" +
     *   "//RUN     EXEC PGM=IEFBR14"
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    jcl: string;
    /**
     * Specify internal reader RECFM and corresponding http(s) headers
     * will be appended to the request accordingly
     * "F" (fixed) or "V" (variable)
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    internalReaderRecfm?: string;
    /**
     * Specify internal reader LRECL and corresponding http(s) headers
     * will be appended to the request accordingly
     * @type {string}
     * @memberof ISubmitJclNotifyParm
     */
    internalReaderLrecl?: string;
    /**
     * A string for JCL symbolic substitution
     * @type {string}
     * @memberof ISubmitJobParms
     */
    jclSymbols?: string;
}
