import { IStartTsoParms } from "./IStartTsoParms";
/**
 * Interface for TSO issue command z/OSMF parameters
 * @export
 * @interface IIssueTsoParms
 */
export interface IIssueTsoParms {
    /**
     * Command text to issue to the TSO address space.
     * @type {string}
     * @memberof IIssueTsoParms
     */
    command: string;
    /**
     * Accounting info for Jobs
     * @type {string}
     * @memberof IIssueTsoParms
     */
    accountNumber: string;
    /**
     * Interface for TSO start command z/OSMF parameters
     * @type {string}
     * @memberof IIssueTsoParms
     */
    startParams: IStartTsoParms;
}
