import { IConfigLayer } from "../doc/IConfigLayer";
import { ConfigApi } from "./ConfigApi";
import { IConfig } from "../doc/IConfig";
/**
 * API Class for manipulating config layers.
 */
export declare class ConfigLayers extends ConfigApi {
    /**
     * Read a config layer from disk into memory for application use.
     *
     * @param opts The user and global flags that indicate which of the four
     *             config files (aka layers) is to be read.
     */
    read(opts?: {
        user: boolean;
        global: boolean;
    }): void;
    /**
     * Write a config layer to disk.
     *
     * @param opts The user and global flags that indicate which of the four
     *             config files (aka layers) is to be written.
     */
    write(opts?: {
        user: boolean;
        global: boolean;
    }): void;
    /**
     * Select which layer is the currently active layer.
     *
     * @param user True if you want the user layer.
     * @param global True if you want the global layer.
     * @param inDir The directory to which you want to set the file path
     *              for this layer.
     */
    activate(user: boolean, global: boolean, inDir?: string): void;
    /**
     * Gets a json object that represents the currently active layer.
     *
     * @returns The json object
     */
    get(): IConfigLayer;
    /**
     * Set the the currently active layer to the supplied json object.
     *
     * @param user True if you want the user layer.
     */
    set(cnfg: IConfig): void;
    /**
     * Merge properties from the supplied Config object into the active layer.
     * If dryRun is specified, merge is applied to a copy of the layer and returned.
     * If dryRun is not specified, merge is applied directly to the layer and nothing is returned.
     *
     * @param cnfg The Config object to merge.
     * @returns The merged config layer or void
     */
    merge(cnfg: IConfig, dryRun?: boolean): void | IConfigLayer;
    /**
     * Finds the highest priority layer where a profile is stored.
     * @param profileName Profile name to search for
     * @returns User and global properties, or undefined if profile does not exist
     */
    find(profileName: string): {
        user: boolean;
        global: boolean;
    };
}
