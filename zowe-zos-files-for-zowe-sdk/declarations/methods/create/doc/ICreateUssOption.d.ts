import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * Interface for the options to the create uss file or directory API.
 * @export
 * @interface ICreateUssOptions
 */
export interface ICreateUssOptions extends IZosFilesOptions {
    /**
     * The request type
     * @type {string}
     */
    type: string;
    /**
     * 	Specifies the file or directory permission bits to be used in creating the file or directory.
     * @type {string}
     */
    mode?: string;
}
