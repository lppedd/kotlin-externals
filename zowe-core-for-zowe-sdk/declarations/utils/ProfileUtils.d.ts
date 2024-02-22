import { IProfile } from "@zowe/imperative";
/**
 * Retrieves the Zowe CLI home directory. In the situation Imperative has
 * not initialized it we mock a default value.
 * @returns {string} - Returns the Zowe home directory
 */
export declare function getZoweDir(): string;
/**
 * Loads default z/OSMF profile. The profile must have already been
 * created using Zowe CLI, and not rely on base profiles
 *
 * @param {string} profileType - The name of the profile type
 * @param {boolean} mergeWithBase - Whether or not to merge with the base profile
 * @returns {IProfile} - The default profile (or merged profile, if requested)
 */
export declare function getDefaultProfile(profileType: string, mergeWithBase?: boolean): Promise<IProfile>;
