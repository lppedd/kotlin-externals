import { IMountFsMode } from "./IMountFsMode";
import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * Interface for the options to the mount file-system API.
 * @export
 * @interface IMountFsOptions
 */
export interface IMountFsOptions extends IZosFilesOptions {
    /**
     * The file system type to mount
     * @type {string}
     */
    "fs-type"?: string;
    /**
     * The mode for mounting the file system
     * @type {IMountFsMode}
     */
    mode?: IMountFsMode;
}
