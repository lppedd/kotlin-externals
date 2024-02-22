import { IProfile } from "../doc/definition/IProfile";
import { IMetaProfile } from "../doc/definition/IMetaProfile";
import { IProfileTypeConfiguration } from "../doc/config/IProfileTypeConfiguration";
/**
 * Profile IO methods for writing/reading profiles to disk. The profile managers never invoke "fs" directly.
 * All "fs" calls are wrapped here and errors are transformed to ImperativeError for error handling/flow throughout
 * Imperative.
 *
 * @export
 * @class ProfileIO
 */
export declare class ProfileIO {
    /**
     * The yamljs package requires you to indicate the depth for conversion to yaml. Set to max of 9999.
     * @static
     * @type {number}
     * @memberof ProfileIO
     */
    static readonly MAX_YAML_DEPTH: number;
    /**
     * Creates the full set of directories indicated by the path. Used to create the profile root directory and
     * type directories.
     * @static
     * @param {string} path - The directory path to create - creates all necessary subdirectories.
     * @memberof ProfileIO
     */
    static createProfileDirs(path: string): void;
    /**
     * Read the profile meta file using Yaml "safeLoad" (ensures that no code executes, etc. during the load). The
     * meta profile file for a type contains the default profile specification. The meta profile is ALWAYS in YAML
     * format (controlled exclusively by the Imperative framework).
     * @static
     * @param {string} path - The path to the meta profile
     * @returns {IMetaProfile} - The meta profile
     * @memberof ProfileIO
     */
    static readMetaFile<T extends IProfileTypeConfiguration>(path: string): IMetaProfile<T>;
    /**
     * Accepts a profile object and writes the profile to the specified location (and optionally converts
     * the profile to YAML format - the default for Imperative profiles).
     * @static
     * @param {string} fullFilePath - the fully qualified profile path, file, & extension.
     * @param {IProfile} profile - the profile object to write to disk.
     * @memberof ProfileIO
     */
    static writeProfile(fullFilePath: string, profile: IProfile): void;
    /**
     * Delete the profile and ensure it is gone.
     * @static
     * @param {string} name - the profile object - really only used for error messages
     * @param {string} fullFilePath - the full file path to delete
     * @memberof ProfileIO
     */
    static deleteProfile(name: string, fullFilePath: string): void;
    /**
     * Checks if the file specified exists.
     * @static
     * @param {string} path - The file path
     * @returns {string} - the path to the existing file or NULL if not found
     * @memberof ProfileIO
     */
    static exists(path: string): string;
    /**
     * Converts the meta to yaml and writes to disk
     * @static
     * @param {IMetaProfile} meta - The meta profile contents to write to disk
     * @param {string} path - The path to the meta profile
     * @memberof ProfileIO
     */
    static writeMetaFile(meta: IMetaProfile<IProfileTypeConfiguration>, path: string): void;
    /**
     * Extracts the profile name from the file path/name
     * @static
     * @param {string} file - the file path to extract the profile name
     * @param {string} ext - the extension of the file
     * @returns {string} - the profile name
     * @memberof ProfileIO
     */
    static fileToProfileName(file: string, ext: string): string;
    /**
     * Accepts the profiles root directory and returns all directories within. The directories within the root
     * directory are all assumed to be profile type directories (potentially containing a meta file and profiles
     * of that type).
     * @static
     * @param {string} profileRootDirectory - The profiles root directory to obtain all profiles from.
     * @returns {string[]} - The list of profiles returned or a blank array
     * @memberof ProfileIO
     */
    static getAllProfileDirectories(profileRootDirectory: string): string[];
    /**
     * Accepts the profile directory location for a type, reads all filenames, and returns a list of
     * profile names that are present within the directory (excluding the meta profile)
     * @static
     * @param {string} profileTypeDir - The directory for the type
     * @param {string} ext - the extension for the profile files (normally YAML)
     * @param {string} metaNameForType - the meta name for this type
     * @returns {string[]} - A list of all profile names (without path/ext)
     * @memberof ProfileIO
     */
    static getAllProfileNames(profileTypeDir: string, ext: string, metaNameForType: string): string[];
    /**
     * Read a profile from disk. Profiles are always assumed to be YAML (YAML "safeLoad" is invoked to perform the load).
     * @static
     * @param {string} filePath - Path to the profile.
     * @param {string} type - The profile type; used to populate the "type" in the profile object (type property not persisted on disk).
     * @returns {IProfile} - The profile object.
     * @memberof ProfileIO
     */
    static readProfileFile(filePath: string, type: string): IProfile;
    /**
     * Crash if we detect that we are running in team-config mode.
     * You should not be able to operate on old-school profiles
     * when you are in team-config mode. Give a meaningful
     * message as part of our crash.
     */
    private static crashInTeamConfigMode;
    /**
     * Error IO tag for Imperative Errors
     * @private
     * @static
     * @type {string}
     * @memberof ProfileIO
     */
    private static ERROR_ID;
}
