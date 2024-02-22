import { ConfigApi } from "./ConfigApi";
import { IConfigVault } from "../doc/IConfigVault";
/**
 * API Class for manipulating config layers.
 */
export declare class ConfigSecure extends ConfigApi {
    private mLoadFailed;
    /**
     * Load the secure application properties from secure storage using the
     * specified vault interface. The vault interface is placed into our
     * Config object. The secure values are placed into our Config layers.
     *
     * @param vault Interface for loading and saving to secure storage.
     */
    load(vault?: IConfigVault): Promise<void>;
    /**
     * Save the secure application properties into secure storage using
     * the vault interface from our config object.
     *
     * @param allLayers Specify true to save all config layers instead of only the active one
     */
    save(allLayers?: boolean): Promise<void>;
    /**
     * List full paths of all secure properties found in a team config file.
     *
     * @param opts The user and global flags that specify one of the four
     *             config files (aka layers).
     * @returns Array of secure property paths
     *          (e.g., "profiles.lpar1.properties.password")
     */
    secureFields(opts?: {
        user: boolean;
        global: boolean;
    }): string[];
    /**
     * List names of secure properties for a profile. They may be defined at
     * the profile's level, or at a higher level if the config is nested.
     * @param profileName Profile name to search for
     * @returns Array of secure property names
     */
    securePropsForProfile(profileName: string): string[];
    /**
     * Delete secure properties stored for team config files that do not exist.
     * @returns Array of file paths for which properties were deleted
     */
    rmUnusedProps(): string[];
    /**
     * Return true if the secure load method was called and threw an error, or
     * it was never called because the CredentialManager failed to initialize.
     */
    get loadFailed(): boolean;
}
