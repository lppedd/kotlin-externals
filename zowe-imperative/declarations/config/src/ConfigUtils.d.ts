import { ICommandArguments } from "../../cmd";
import { ImperativeError } from "../../error";
export declare class ConfigUtils {
    /**
     * Coeerces string property value to a boolean or number type.
     * @param value String value
     * @param type Property type defined in the schema
     * @returns Boolean, number, or string
     */
    static coercePropValue(value: any, type?: string): any;
    /**
     * Retrieves the name of the active profile for the given type. If no such
     * profile exists, returns the default name which can be used to create a new profile.
     * @param profileType The type of CLI profile
     * @param cmdArguments CLI arguments which may specify a profile
     * @param defaultProfileName Name to fall back to if profile doesn't exist. If
     *                           not specified, the profile type will be used.
     * @returns The profile name
     */
    static getActiveProfileName(profileType: string, cmdArguments?: ICommandArguments, defaultProfileName?: string): string;
    /**
     * Checks if partial path is equal to or nested inside full path
     * @param fullPath JSON path to profile 1
     * @param partialPath JSON path to profile 2
     */
    static jsonPathMatches(fullPath: string, partialPath: string): boolean;
    /**
     * Form an error message for failures to securely save a value.
     * @param solution Text that our caller can supply for a solution.
     * @returns ImperativeError to be thrown
     */
    static secureSaveError(solution?: string): ImperativeError;
}
