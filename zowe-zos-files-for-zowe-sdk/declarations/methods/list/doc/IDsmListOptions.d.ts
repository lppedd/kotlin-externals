import { ITaskWithStatus } from "@zowe/imperative";
import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the list data sets matching function
 */
export interface IDsmListOptions extends IZosFilesOptions {
    /**
     * Exclude data sets that match these DSLEVEL patterns. Any data sets that match
     * this pattern will not be listed
     * @example "ibmuser.**.jcl, ibmuser.rexa.*"
     */
    excludePatterns?: string[];
    /**
     * The maximum REST requests to perform at once
     * Increasing this value results in faster requests but increases resource consumption
     * on z/OS and risks encountering an error caused
     * by making too many requests at once.
     * Default: 1
     */
    maxConcurrentRequests?: number;
    /**
     * Task status object used by CLI handlers to create progress bars
     * Optional
     * @type {ITaskWithStatus}
     */
    task?: ITaskWithStatus;
}
