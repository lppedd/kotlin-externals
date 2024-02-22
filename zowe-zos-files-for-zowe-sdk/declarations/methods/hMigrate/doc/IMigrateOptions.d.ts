import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the migrate data set function.
 */
export interface IMigrateOptions extends IZosFilesOptions {
    /**
     * If true then the function waits for completion of the request.
     * If false (default) the request is queued.
     */
    wait?: boolean;
}
