/**
 * This interface defines results of the download dir-from-uss command.
 * @export
 * @interface IDownloadUssDirResult
 */
export interface IDownloadUssDirResult {
    /**
     * List of file names that have downloaded successfully.
     */
    downloaded: string[];
    /**
     * List of file names that were not downloaded because they already existed on the system.
     */
    skippedExisting: string[];
    /**
     * Object containing key-value pairs of files and errors for uss files that failed to download.
     */
    failedWithErrors: {
        [key: string]: Error;
    };
}
