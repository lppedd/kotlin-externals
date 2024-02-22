/**
 * This interface defines results of the download data sets matching command.
 * @export
 * @interface IDownloadDsmResult
 */
export interface IDownloadDsmResult {
    /**
     * List of data set names that have downloaded successfully.
     */
    downloaded: string[];
    /**
     * List of data set names that failed to download because they are archived.
     */
    failedArchived: string[];
    /**
     * List of data set names that failed to download because they are an
     * unsupported type.
     */
    failedUnsupported: string[];
    /**
     * Object containing key-value pairs of data set names and errors for data
     * sets that failed to download.
     */
    failedWithErrors: {
        [key: string]: Error;
    };
}
