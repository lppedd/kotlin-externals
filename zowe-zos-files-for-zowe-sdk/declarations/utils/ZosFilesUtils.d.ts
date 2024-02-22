/// <reference types="node" />
import { IHeaderContent, AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../doc/IZosFilesResponse";
import { IDeleteOptions } from "../methods/hDelete";
import { IOptions } from "../doc/IOptions";
import { IDataSet } from "../doc/IDataSet";
/**
 * Common IO utilities
 */
export declare class ZosFilesUtils {
    /**
     * Data set name qualifier separator
     * @type {string}
     */
    static readonly DSN_SEP: string;
    /**
     * Default file extension
     * @type {string}
     */
    static readonly DEFAULT_FILE_EXTENSION: string;
    static readonly MAX_MEMBER_LENGTH: number;
    /**
     * Break up a dataset name of either:
     *  USER.WORK.JCL(TEMPLATE) to user/work/jcl/template
     * Or:
     *  USER.WORK.PS to user/work/ps
     * @param  {string} dataSet - data set to break up into folders
     */
    static getDirsFromDataSet(dataSet: string): string;
    /**
     * Get fullpath name from input path.
     * @param {string} inputPath - input path
     * @return {string} full path version of the input path
     */
    static getFullPath(inputPath: string): string;
    /**
     * Return an array contain the list of all files in the input path. It does not trevor to
     * directory in the input path.
     * @param {string}  inputPath input path to gather file list
     * @param {boolean} [inFullPathFormat=true] is the return file path in full path mode flag
     * @param {boolean} [isIgnoreHidden=true] is listing hidden files flag
     * @return {string[]} Array of all files finds in path
     */
    static getFileListFromPath(inputPath: string, inFullPathFormat?: boolean, isIgnoreHidden?: boolean): string[];
    /**
     * Common method to build headers given input options object
     * @private
     * @static
     * @param {IOptions} options - various options
     * @returns {IHeaderContent[]}
     * @memberof ZosFilesUtils
     */
    static generateHeadersBasedOnOptions(options: IOptions): IHeaderContent[];
    /**
     * Generate member name from input string base on IBM specification
     * @param {string} fileName input name used to generate member name with
     * @return {string} generated member name
     */
    static generateMemberName(fileName: string): string;
    /**
     * Check if the input data set name contain masking characters
     * @param {string} dataSetName input data set name to be checked
     * @return {boolean} status if data set name contain masking characters
     */
    static isDataSetNameContainMasking(dataSetName: string): boolean;
    /**
     * Normalize all Windows newline to Unix newline
     * @param {Buffer} buffer data to convert
     * @return {Buffer} converted data
     */
    static normalizeNewline(buffer: Buffer): Buffer;
    /**
     * Normanize and URL-encode a USS path to be passed to z/OSMF
     * @param ussPath path to sanitize
     */
    static sanitizeUssPathForRestCall(ussPath: string): string;
    /**
     * Format USS filepaths in the way that the APIs expect (no leading /)
     * @param {string} usspath - the path to format
     */
    static formatUnixFilepath(usspath: string): string;
    /**
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} dataSetName -The name of the data set to recall|migrate|delete
     * @param {string} returnMessage - Message to return based upon command request
     * @param {any} hsmCommand - HsmCommand requested
     * @param {IRecallOptions | IMigrateOptions | IDeleteOptions} options
     * * - If true then the function waits for completion of the request. If false (default) the request is queued.
     */
    static dfsmsHsmCommand(session: AbstractSession, dataSetName: string, returnMessage: string, hsmCommand: any, options?: Partial<IDeleteOptions>): Promise<IZosFilesResponse>;
    /**
     * Converts the name of a data set to an IDataSet
     * @param {string} name  - the name in the form USER.DATA.SET | USER.DATA.SET(mem1)
     */
    static getDataSetFromName(name: string): IDataSet;
}
