/**
 * This interface defines the map option that can be sent into the upload uss directory function
 */
export interface IUploadFile {
    /**
     * The indicator to upload the data set in binary mode
     */
    binary: boolean;
    /**
     * File name to be uploaded in binary or ascii
     */
    fileName: string;
}
