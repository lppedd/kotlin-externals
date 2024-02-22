/**
 * This interface defines the information that is stored in the download data set API return object
 */
export interface IUSSFileListResponse {
    /**
     * The name of the dataset
     */
    name: string;
    /**
     * The block size of the dataset
     */
    mode?: string;
    /**
     * The catalog in which the dataset entry is stored
     */
    size?: string;
    /**
     * The dataset creation date
     */
    uid?: string;
    /**
     * The type of the device the dataset is stored on
     */
    user?: string;
    /**
     * The type of the dataset
     */
    gid?: string;
}
