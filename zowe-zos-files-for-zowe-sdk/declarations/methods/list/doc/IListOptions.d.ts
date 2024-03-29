import { ZosmfMigratedRecallOptions } from "../../../doc/types/ZosmfMigratedRecallOptions";
import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the dwanload data set function
 */
export interface IListOptions extends IZosFilesOptions {
    /**
     * The volume where the data set resides
     */
    volume?: string;
    /**
     * The indicator that we want to show more attributes
     */
    attributes?: boolean;
    /**
     * The indicator that we want to show less data sets or members
     */
    maxLength?: number;
    /**
     * An optional search parameter that specifies the first data set name to return in the response document
     */
    start?: string;
    /**
     * An optional parameter that specifies how to handle migrated data sets
     */
    recall?: ZosmfMigratedRecallOptions;
    /**
     * An optional pattern for restricting the response list
     */
    pattern?: string;
}
