export interface IUploadResult {
    /**
     * Upload status
     */
    success: boolean;
    /**
     * Name of input file
     */
    from: string;
    /**
     * Name of data set
     */
    to: string;
    /**
     * Optional, any error encounter while uploading the data
     */
    error?: any;
    /**
     * Optional, etag set when writing the file
     */
    etag?: string;
}
