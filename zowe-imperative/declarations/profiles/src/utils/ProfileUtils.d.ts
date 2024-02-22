import { IProfileTypeConfiguration } from "../doc/config/IProfileTypeConfiguration";
import { IProfileLoaded } from "../doc/response/IProfileLoaded";
/**
 * Set of static utility methods to assist with creating profile option names from profile types, constructing the
 * root directory, reforming responses for different purposes, etc.
 *
 * @export
 * @class ProfileUtils
 */
export declare class ProfileUtils {
    /**
     * Construct the profiles root directory, given the "home" directory.
     *
     * @static
     * @param home - The home directory - normally supplied by Imperative.
     * @returns {string} - The profiles root directory
     * @memberof ProfileUtils
     */
    static constructProfilesRootDirectory(home: string): string;
    /**
     * Accepts an array of responses, which, depending on the depedencies, may have nested depedency arrays, and
     * flattens to a single level (for ease of printing, etc.).
     *
     * @static
     * @param {IProfileLoaded[]} dependencyResponses - The list of load responses
     * @returns {IProfileLoaded[]} - The list of load responses flattened to a single level
     * @memberof ProfileUtils
     */
    static flattenDependencies(dependencyResponses: IProfileLoaded[]): IProfileLoaded[];
    /**
     * Accepts the profile configuration document and returns an array of all types.
     *
     * @static
     * @param {IProfileTypeConfiguration[]} profileConfigs - All profile type configuration documents.
     * @returns {string[]} - An array of profile types.
     * @memberof ProfileUtils
     */
    static getAllTypeNames(profileConfigs: IProfileTypeConfiguration[]): string[];
    /**
     * Construct the profile option - e.g banana-profile - Used to append to commands automatically
     * and by the command processor to check if profile options are present.
     * @param {string} type: The module name (e.g. banana)
     * @return {string} -  The full option name
     */
    static getProfileOption(type: string): string;
    /**
     * Construct the profile option alias - e.g banana-p- Used to append to commands automatically
     * and by the command processor to check if profile options are present.
     * @param {string} type: The module name (e.g. banana)
     * @return {string} -  The alias for the profile option
     */
    static getProfileOptionAlias(type: string): string;
    /**
     * Returns the standard profile option name like "banana-profile" and its alias
     * @param {string} type: The type of the profile
     * @return {[string , string]}: The option and its alias
     */
    static getProfileOptionAndAlias(type: string): [string, string];
    /**
     * Create a mapKey value to identify a profile
     * @param {string} type - Type of the profile
     * @param {string} name - Name of the profile
     * @return {string} - Key identifying the profile
     */
    static getProfileMapKey(type: string, name: string): string;
    /**
     * Create a key value to identify a property on a profile
     * @param {string} type - Type of the profile
     * @param {string} name - Name of the profile
     * @param {string} name - Name of the profile
     * @return {string} - Key identifying the profile
     */
    static getProfilePropertyKey(type: string, name: string, field: string): string;
}
