import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the delete data set function.
 */
export interface IDeleteDatasetOptions extends IZosFilesOptions {
    /**
     * The volume where the data set resides.
     */
    volume?: string;
}
