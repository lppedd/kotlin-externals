import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * Interface for the options to the create data-set-vsam API.
 * @export
 * @interface ICreateVsamOptions
 */
export interface ICreateVsamOptions extends IZosFilesOptions {
    /**
     * The data set organization
     * @type {string}
     */
    dsorg?: string;
    /**
     * The unit of space allocation
     * @type {string}
     */
    alcunit?: string;
    /**
     * The primary space allocation
     * @type {number}
     */
    primary?: number;
    /**
     * The secondary space allocation
     * @type {number}
     */
    secondary?: number;
    /**
     * The volumes on which to allocate space
     * @type {string}
     */
    volumes?: string;
    /**
     * The storage class
     * @type {string}
     */
    storclass?: string;
    /**
     * The management class
     * @type {string}
     */
    mgntclass?: string;
    /**
     * The data class
     * @type {string}
     */
    dataclass?: string;
    /**
     * The number of days for which the VSAM cluster will be retained
     * @type {string}
     */
    retainFor?: number;
    /**
     * The date until which the VSAM cluster will be retained
     * @type {string}
     */
    retainTo?: string;
    /**
     * The indicator that we need to show the attributes
     *
     * DO NOT SEND THIS TO ZOSMF
     *
     * @type {boolean}
     */
    showAttributes?: boolean;
}
