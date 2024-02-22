/// <reference types="node" />
/// <reference types="node" />
import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IUploadOptions } from "./doc/IUploadOptions";
import { Readable } from "stream";
export declare class Upload {
    /**
     * Upload content from file to data set
     * @param {AbstractSession} session      - z/OS connection info
     * @param {string}          inputFile    - path to a file
     * @param {string}          dataSetName  - Name of the data set to write to
     * @param {IUploadOptions}  [options={}] - Uploading options
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the out come
     *
     * @throws {ImperativeError} When encounter error scenarios.
     *
     */
    static fileToDataset(session: AbstractSession, inputFile: string, dataSetName: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Upload content from a directory to a PDS
     * @param {AbstractSession} session      - z/OS connection info
     * @param {string}          inputDir     - path to a file
     * @param {string}          dataSetName  - Name of the data set to write to
     * @param {IUploadOptions}  [options={}] - Uploading options
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the out come
     *
     * @throws {ImperativeError} When encounter error scenarios.
     *
     */
    static dirToPds(session: AbstractSession, inputDir: string, dataSetName: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Writing data buffer to a data set.
     * @param {AbstractSession} session      - z/OS connection info
     * @param {Buffer}          fileBuffer   - Data buffer to be written
     * @param {string}          dataSetName  - Name of the data set to write to
     * @param {IUploadOptions}  [options={}] - Uploading options
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome
     *
     * @throws {ImperativeError} When encounter error scenarios.
     */
    static bufferToDataSet(session: AbstractSession, fileBuffer: Buffer, dataSetName: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Writing data buffer to a data set.
     * @param {AbstractSession} session      - z/OS connection info
     * @param {Buffer}          fileBuffer   - Data buffer to be written
     * @param {string}          dataSetName  - Name of the data set to write to
     * @param {IUploadOptions}  [options={}] - Uploading options
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the out come
     *
     * @throws {ImperativeError} When encounter error scenarios.
     */
    static streamToDataSet(session: AbstractSession, fileStream: Readable, dataSetName: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Upload content from input path to dataSet or PDS members
     * @param {AbstractSession} session      - z/OS connection info
     * @param {string}          inputPath    - User input path to file or directory
     * @param {string}          dataSetName  - Name of the data set to write to
     * @param {IUploadOptions}  [options={}] - Uploading options
     *
     * @param task - use this to be updated on the current status of the upload operation
     * @return {Promise<IZosFilesResponse>} A response indicating the out come
     *
     * @throws {ImperativeError} When encounter error scenarios.
     *
     * @example pathToDataSet(session, "file.txt", "ps.name")
     * @example pathToDataset(session, "file.txt", "psd.name(member)")
     * @example pathToDataSet(session, "directory", "pds.name")
     * @example pathToDataset(session, "/full/path/file.txt", "ps.name")
     *
     * Note:
     * This method does everything needed to do from checking if path is file or directory
     * and if data set is sequential file or PDS to determine what name to be used when
     * upload content to data set.  All you have to specify is a directory and a dsname.
     */
    static pathToDataSet(session: AbstractSession, inputPath: string, dataSetName: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Upload content to USS file
     * @param {AbstractSession} session - z/OS connection info
     * @param {string} ussname          - Name of the USS file to write to
     * @param {Buffer} buffer          - Data to be written
     * @param {IUploadOptions}  [options={}] - Uploading options
     * @returns {Promise<object>}
     */
    static bufferToUssFile(session: AbstractSession, ussname: string, buffer: Buffer, options?: IUploadOptions): Promise<string>;
    /**
     * Upload content to USS file
     * @param {AbstractSession} session - z/OS connection info
     * @param {string} ussname          - Name of the USS file to write to
     * @param {Buffer} uploadStream          - Data to be written
     * @param {IUploadOptions}  [options={}] - Uploading options
     * @returns {Promise<IZosFilesResponse>} - A response indicating the outcome
     */
    static streamToUssFile(session: AbstractSession, ussname: string, uploadStream: Readable, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Upload content from a local file to remote USS file
     * @param session   - z/OS connection info
     * @param inputFile - Path to local file
     * @param ussname   - Name of USS file to write to
     * @param options   - Uploading options
     * @returns {Promise<IZosFilesResponse>} - A response indicating the outcome
     */
    static fileToUssFile(session: AbstractSession, inputFile: string, ussname: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Upload local directory to USS directory
     * @param {AbstractSession} session - z/OS connection info
     * @param {string} inputDirectory   - the path of local directory
     * @param {string} ussname          - the name of uss folder
     * @param {IUploadOptions} [options={}]   - Uploading options
     * @returns {Promise<IZosFilesResponse>}
     */
    static dirToUSSDir(session: AbstractSession, inputDirectory: string, ussname: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    /**
     * Check if USS directory exists
     * @param {AbstractSession} session - z/OS connection info
     * @param {string} ussname          - the name of uss folder
     * @return {Promise<boolean>}
     */
    static isDirectoryExist(session: AbstractSession, ussname: string): Promise<boolean>;
    /**
     * Upload directory to USS recursively
     * @param {AbstractSession} session       - z/OS connection info
     * @param {string} inputDirectory         - the path of local directory
     * @param {string} ussname                - the name of uss folder
     * @param {IUploadOptions} [options={}]   - Uploading options
     * @return {null}
     */
    static dirToUSSDirRecursive(session: AbstractSession, inputDirectory: string, ussname: string, options?: IUploadOptions): Promise<IZosFilesResponse>;
    private static uploadFile;
    /**
     * Get Log
     * @returns {Logger} applicationLogger.
     */
    private static get log();
    /**
     * Checks if a given directory has sub-directories or not
     * @param {string} dirPath full-path for the directory to check
     */
    private static hasDirs;
    /**
     * Returns an array of sub-directories objects, containing directory name, and full path specification
     * @param dirPath full-path for the directory to check
     */
    private static getDirs;
    /**
     * helper function to prepare file names for display on progress bar
     * @param stringInput string input to be formated
     */
    private static formatStringForDisplay;
    /**
     * helper function to generate the headers based on the options used
     * @param {IUploadOptions} options - upload options
     * @param {string} context         - context method from where you call this function (can be "buffer", "stream" or undefined)
     */
    private static generateHeadersBasedOnOptions;
}
