/**
 * Common interface for submit job API
 * @export
 * @interface ISubmitParms
 */
export interface ISubmitParmsCommon {
    /**
     * A string for JCL symbolic substitution
     * @type {string}
     * @memberof ISubmitParms
     */
    jclSymbols?: string;
    /**
     * Specify internal reader file encoding and corresponding http(s) headers
     * will be appended to the request accordingly
     * @type {string}
     * @memberof ISubmitParms
     */
    internalReaderFileEncoding?: string;
    /**
     * Specify internal reader RECFM and corresponding http(s) headers
     * will be appended to the request accordingly
     * "F" (fixed) or "V" (variable)
     * @type {string}
     * @memberof ISubmitJclParms
     */
    internalReaderRecfm?: string;
    /**
     * Specify internal reader LRECL and corresponding http(s) headers
     * will be appended to the request accordingly
     * @type {string}
     * @memberof ISubmitJclParms
     */
    internalReaderLrecl?: string;
}
