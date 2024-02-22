import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * Interface for the options to the create zos-file-system API.
 * @export
 * @interface ICreateZfsOptions
 */
export interface ICreateZfsOptions extends IZosFilesOptions {
    /**
     * The user ID for owner of the root directory
     * @type {string}
     */
    owner?: string;
    /**
     * The group ID for the root directory
     * @type {string}
     */
    group?: string;
    /**
     * The permissions code for the root directory
     * @type {number}
     */
    perms?: number;
    /**
     * The primary space allocation
     * @type {number}
     */
    cylsPri: number;
    /**
     * The secondary space allocation
     * @type {number}
     */
    cylsSec?: number;
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
     * The volumes on which to allocate space
     * @type {string[]}
     */
    volumes?: string[];
    /**
     * The number of seconds to wait for command to complete
     * @type {number}
     */
    timeout?: number;
}
