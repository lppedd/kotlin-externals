import { IConfigProfile } from "../doc/IConfigProfile";
import { ConfigApi } from "./ConfigApi";
/**
 * API Class for manipulating config profiles.
 */
export declare class ConfigProfiles extends ConfigApi {
    /**
     * Set a profile object at the location identified by the path
     * within the currently active layer.
     *
     * @param path The dotted path of the location in which to set the profile.
     * @param profile The JSON profile object to set into the specified location,
     */
    set(path: string, profile: IConfigProfile): void;
    /**
     * Get the profile object located at the specified location.
     *
     * @param path The dotted path of the location at which to set the profile.
     * @param mustExist If false, outer layer profile values will still be
     *        returned when the dotted path does not exist. Default is true.
     */
    get(path: string, mustExist?: boolean): {
        [key: string]: string;
    };
    /**
     * Reports whether or not a profile exists at the specified location.
     *
     * @param path The dotted path of desired location.
     *
     * @returns True if a profile exists. False otherwise.
     */
    exists(path: string): boolean;
    /**
     * Set the default value for the specified type of profile within
     * the currently active layer.
     *
     * @param profileType The name of the desired type of profile (like zosmf).
     * @param value The dotted node path to the profile (like ca32.zosmf).
     */
    defaultSet(profileType: string, value: string): void;
    /**
     * Get the profile contents for the default profile of the specified type
     * of profile within the currently active layer.
     *
     * @param profileType The name of the desired type of profile (like zosmf).
     *
     * @returns An object containing the desired profile,
     *          for example {"host": "lpar.your.domain.net", port: 1234}
     */
    defaultGet(profileType: string): {
        [key: string]: string;
    };
    /**
     * Expands a short path into an expanded path.
     *
     * @param shortPath The short path.
     *
     * @returns The expanded path.
     *
     * @deprecated Please use getProfilePathFromName
     */
    expandPath(shortPath: string): string;
    /**
     * Expands a short path into an expanded path.
     *
     * @param shortPath The short path.
     *
     * @returns The expanded path.
     */
    getProfilePathFromName(shortPath: string): string;
    /**
     * Obtain the profile name (either nested or not) based on a property path.
     *
     * @param path The property path.
     *
     * @returns The corresponding profile name.
     *
     * @note This may be useful for supporting token authentication in a nested configuration
     *
     */
    getProfileNameFromPath(path: string): string;
    /**
     * Build the set of properties contained within a set of nested profiles.
     *
     * @param path The dotted path of desired location.
     * @param profiles A set of nested profile objects.
     *
     * @returns The desired profile object. An empty object if profiles is empty.
     */
    buildProfile(path: string, profiles: {
        [key: string]: IConfigProfile;
    }): {
        [key: string]: string;
    };
    /**
     * Find a profile at a specified location from within a set of
     * nested profiles.
     *
     * @param path The dotted path of desired location.
     * @param profiles A set of nested profile objects.
     *
     * @returns The profile object that was found. null if not found.
     */
    private findProfile;
}
