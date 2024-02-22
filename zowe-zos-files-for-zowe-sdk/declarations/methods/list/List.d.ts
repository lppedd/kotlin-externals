import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IListOptions } from "./doc/IListOptions";
import { IUSSListOptions } from "./doc/IUSSListOptions";
import { IFsOptions } from "./doc/IFsOptions";
import { IDsmListOptions } from "./doc/IDsmListOptions";
/**
 * This class holds helper functions that are used to list data sets and its members through the z/OS MF APIs
 */
export declare class List {
    private static CONTROL_CHAR_REGEX;
    /**
     * Retrieve all members from a PDS
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           dataSetName  - contains the data set name
     * @param {IListOptions}     [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetListDataSetMembers.htm
     */
    static allMembers(session: AbstractSession, dataSetName: string, options?: IListOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve all members from a data set name
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           dataSetName  - contains the data set name
     * @param {IListOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static dataSet(session: AbstractSession, dataSetName: string, options?: IListOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve a list of all files from a path name
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           path         - contains the uss path name
     * @param {IUSSListOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static fileList(session: AbstractSession, path: string, options?: IUSSListOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve zfs files
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {IZfsOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static fs(session: AbstractSession, options?: IFsOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve zfs files if indicated path
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {IZfsOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static fsWithPath(session: AbstractSession, options?: IFsOptions): Promise<IZosFilesResponse>;
    /**
     * List data sets that match a DSLEVEL pattern
     * @param {AbstractSession} session z/OSMF connection info
     * @param {string[]} patterns Data set patterns to include
     * @param {IDsmListOptions} options Contains options for the z/OSMF request
     * @returns {Promise<IZosFilesResponse>} List of z/OSMF list responses for each data set
     *
     * @example
     * ```typescript
     *
     * // List all "PS" and "PO" datasets that match the pattern "USER.**.DATASET"
     * await List.dataSetsMatchingPattern(session, "USER.**.DATASET");
     * ```
     */
    static dataSetsMatchingPattern(session: AbstractSession, patterns: string[], options?: IDsmListOptions): Promise<IZosFilesResponse>;
    private static get log();
}
