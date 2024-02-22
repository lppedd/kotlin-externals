import { IMigrateOptions } from "../../hMigrate";
/**
 * This interface defines the options that can be sent into the delete data set function.
 */
export interface IDeleteOptions extends IMigrateOptions {
    /**
     * If true then the function uses the PURGE=YES on ARCHDEL request.
     * If false (default) the function uses the PURGE=NO on ARCHDEL request.
     */
    purge?: boolean;
}
