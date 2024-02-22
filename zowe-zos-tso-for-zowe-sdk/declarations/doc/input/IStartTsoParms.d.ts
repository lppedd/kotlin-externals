/**
 * Interface for TSO start command z/OSMF parameters
 * @export
 * @interface IStartTsoParms
 */
export interface IStartTsoParms {
    /**
     * name of the logonProcedure for address space
     * @type {string}
     * @memberof IStartTsoParms
     */
    logonProcedure?: string;
    /**
     * character set for address space
     * @type {string}
     * @memberof IStartTsoParms
     */
    characterSet?: string;
    /**
     * code page for tso address space
     * @type {string}
     * @memberof IStartTsoParms
     */
    codePage?: string;
    /**
     * number of rows
     * @type {string}
     * @memberof IStartTsoParms
     */
    rows?: string;
    /**
     * number of columns
     * @type {string}
     * @memberof IStartTsoParms
     */
    columns?: string;
    /**
     * user account number
     * @type {string}
     * @memberof IStartTsoParms
     */
    account?: string;
    /**
     * region size for address space
     * @type {string}
     * @memberof IStartTsoParms
     */
    regionSize?: string;
}
