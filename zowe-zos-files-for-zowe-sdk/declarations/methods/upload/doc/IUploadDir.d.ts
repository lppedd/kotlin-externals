/**
 * This interface defines the map option that can be sent into the upload uss directory function
 */
export interface IUploadDir {
    /**
     * directory name
     */
    dirName: string;
    /**
     * full path specification (on local host)
     */
    fullPath: string;
}
