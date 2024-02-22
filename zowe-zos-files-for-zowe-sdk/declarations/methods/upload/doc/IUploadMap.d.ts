/**
 * This interface defines the map option that can be sent into the upload uss directory function
 */
export interface IUploadMap {
    /**
     * The indicator to upload the data set in binary mode
     */
    binary?: boolean;
    /**
     * List of file names to be uploaded in binary or asci
     */
    fileNames: string[];
}
