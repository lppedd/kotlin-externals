import { AbstractSession } from "@zowe/imperative";
import { IDownloadAllSpoolContentParms } from "./doc/input/IDownloadAllSpoolContentParms";
import { IJobFile } from "./doc/response/IJobFile";
import { IDownloadSpoolContentParms } from "./doc/input/IDownloadSpoolContentParms";
/**
 * Class to handle downloading of job information
 * @export
 * @class DownloadJobs
 */
export declare class DownloadJobs {
    /**
     * Default directory where output will be placed
     * @static
     * @type {string}
     * @memberof DownloadJobs
     */
    static readonly DEFAULT_JOBS_OUTPUT_DIR: string;
    /**
     * Default extension of downloaded folders
     * @static
     * @type {string}
     * @memberof DownloadJobs
     */
    static readonly DEFAULT_JOBS_OUTPUT_FILE_EXT: string;
    /**
     * Download spool content to a the default download directory
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param jobFile - spool file to download
     * @returns {Promise<string>} - content downloaded
     * @memberof DownloadJobs
     */
    static downloadSpoolContent(session: AbstractSession, jobFile: IJobFile): Promise<void>;
    /**
     * Download all job output (spool content) for a job to a the local directory
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IDownloadAllSpoolContentParms} parms - parameter object (see IDownloadAllSpoolContentParms for details)
     * @returns {Promise<void>} - a promise which will resolve when the download is complete
     * @memberof DownloadJobs
     */
    static downloadAllSpoolContentCommon(session: AbstractSession, parms: IDownloadAllSpoolContentParms): Promise<void>;
    /**
     * Download spool content to specified directory
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IDownloadSpoolContentParms} parms - parm object (see IDownloadSpoolContentParms interface for details)
     * @returns {Promise<void>} - promise that resolves when the file is downloaded
     * @memberof DownloadJobs
     */
    static downloadSpoolContentCommon(session: AbstractSession, parms: IDownloadSpoolContentParms): Promise<void>;
    /**
     * Get the file where a specified spool file (IJobFile) would be downloaded to
     * @deprecated Use getSpoolDownloadFilePath instead
     * @static
     * @param {IJobFile} jobFile - the spool file that would be downloaded
     * @param {boolean} omitJobidDirectory - if true, the job ID of the jobFile will not be included in the file path
     * @param {string} outDir - parent output directory you would like to download to
     * @returns {string} the file path that the spool file would be downloaded to
     * @memberof DownloadJobs
     */
    static getSpoolDownloadFile(jobFile: IJobFile, omitJobidDirectory?: boolean, outDir?: string): string;
    /**
     * Get the file where a specified spool file (IJobFile) would be downloaded to
     * @static
     * @param {IDownloadSpoolContentParms} parms - parm object (see IDownloadSpoolContentParms interface for details)
     * @returns {string} the file path that the spool file would be downloaded to
     * @memberof DownloadJobs
     */
    static getSpoolDownloadFilePath(parms: IDownloadSpoolContentParms): string;
    /**
     * Getter for brightside logger
     * @returns {Logger}
     */
    private static get log();
}
