import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IDownloadOptions, IDownloadSingleOptions } from "./doc/IDownloadOptions";
import { IZosmfListResponse } from "../list/doc/IZosmfListResponse";
import { IUSSListOptions } from "../list";
/**
 * This class holds helper functions that are used to download data sets, members and more through the z/OS MF APIs
 */
export declare class Download {
    /**
     * Retrieve data sets and/or members contents and save them in your local workspace
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           dataSetName  - contains the data set name
     * @param {IDownloadSingleOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download "USER.DATA.SET.PS" to "user/data/set/ps.txt"
     * await Download.dataSet(session, "USER.DATA.SET.PS");
     *
     * // Download "USER.DATA.SET.PDS(MEMBER)" to "user/data/set/pds/member.txt"
     * await Download.dataSet(session, "USER.DATA.SET.PDS(MEMBER)");
     *
     * // Download "USER.DATA.SET" to "./path/to/file.txt"
     * await Download.dataSet(session, "USER.DATA.SET", {file: "./path/to/file.txt"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    static dataSet(session: AbstractSession, dataSetName: string, options?: IDownloadSingleOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve all members from a PDS and save them in your local workspace
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           dataSetName  - contains the data set name
     * @param {IDownloadOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download all members of "USER.DATA.SET.PDS" to "user/data/set/pds/"
     * await Download.allMembers(session, "USER.DATA.SET.PDS");
     *
     * // Download all members of "USER.DATA.SET.PDS" to "./path/to/dir/"
     * await Download.allMembers(session, "USER.DATA.SET.PDS", {directory: "./path/to/dir/"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    static allMembers(session: AbstractSession, dataSetName: string, options?: IDownloadOptions): Promise<IZosFilesResponse>;
    /**
     * Download a list of data sets to local files
     *
     * @param {AbstractSession}  session         - z/OS MF connection info
     * @param {IZosmfListResponse[]} dataSetObjs - contains data set objects returned by z/OSMF List API
     * @param {IDownloadOptions} [options={}]    - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download a list of "PS" and "PO" datasets to the directory "./path/to/dir/"
     * await Download.allDataSets(session, [
     *    { dsname: "USER.DATA.SET.PS", dsorg: "PS" },
     *    { dsname: "USER.DATA.SET.PDS", dsorg: "PO" }
     * ], {directory: "./path/to/dir/"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.2.0/com.ibm.zos.v2r2.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    static allDataSets(session: AbstractSession, dataSetObjs: IZosmfListResponse[], options?: IDownloadOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve USS file content and save it in your local workspace.
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           ussFileName  - contains the USS file name
     * @param {IDownloadSingleOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} USS file name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static ussFile(session: AbstractSession, ussFileName: string, options?: IDownloadSingleOptions): Promise<IZosFilesResponse>;
    /**
     * Retrieve USS file content and save it in your local workspace.
     *
     * @param {AbstractSession}  session      - z/OS MF connection info
     * @param {string}           ussDirName  - contains the USS file name
     * @param {IDownloadOptions} [fileOptions={}] - contains the file options to be sent
     * @param {IUSSListOptions}  [listOptions={}] - contains the uss list options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} USS file name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    static ussDir(session: AbstractSession, ussDirName: string, fileOptions?: IDownloadOptions, listOptions?: IUSSListOptions): Promise<IZosFilesResponse>;
    /**
     * Create an empty download data sets matching result.
     * @returns Results object with all lists initialized as empty
     */
    private static emptyDownloadDsmResult;
    /**
     * Create an empty download data sets matching result.
     * @returns Results object with all lists initialized as empty
     */
    private static emptyDownloadUssDirResult;
    /**
     * Build a response string from a download data sets matching result.
     * @param result Result object from the download API
     * @param options Options passed to the download API
     * @returns Response string to print to console
     */
    private static buildDownloadDsmResponse;
    /**
     * Build a response string from a download ussDir result.
     * @param result Result object from the download API
     * @param options Options passed to the download API
     * @returns Response string to print to console
     */
    private static buildDownloadUssDirResponse;
    private static generateHeadersBasedOnOptions;
    private static parseAttributeOptions;
}
