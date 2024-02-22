import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the zfs function
 */
export interface IFsOptions extends IZosFilesOptions {
    /**
     * Specifies the path where the file system is mounted
     */
    path?: string;
    /**
     * Specifies the name of the mounted file system
     */
    fsname?: string;
    /**
     * Specifies the maximum number of items to return
     */
    maxLength?: number;
}
