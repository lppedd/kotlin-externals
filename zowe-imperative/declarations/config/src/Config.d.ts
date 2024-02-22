import { IConfig } from "./doc/IConfig";
import { IConfigLayer } from "./doc/IConfigLayer";
import { IConfigOpts } from "./doc/IConfigOpts";
import { ConfigLayers, ConfigPlugins, ConfigProfiles, ConfigSecure } from "./api";
import { IConfigSchemaInfo } from "./doc/IConfigSchema";
/**
 * The Config class provides facilities for reading and writing team
 * configuration files. It is used by Imperative to perform low-level
 * operations on a team configuration. The intent is that consumer
 * apps will not typically use the Config class, since end-users are
 * expected to write team configuration files by directly editing them
 * in an editor like VSCode.
 */
export declare class Config {
    opts?: IConfigOpts;
    /**
     * The trailing portion of a shared config file name
     */
    private static readonly END_OF_TEAM_CONFIG;
    /**
     * The trailing portion of a user-specific config file name
     */
    private static readonly END_OF_USER_CONFIG;
    /**
     * Cached version of Config APIs
     */
    private mApi;
    /**
     * Constructor for Config class. Don't use this directly. Await `Config.load` instead.
     * @param opts Options to control how Config class behaves
     * @private
     */
    private constructor();
    /**
     * Return a Config interface with required fields initialized as empty.
     */
    static empty(): IConfig;
    /**
     * Load config files from disk and secure properties from vault.
     * @param app App name used in config filenames (e.g., *my_cli*.config.json)
     * @param opts Options to control how Config class behaves
     * @throws An ImperativeError if the configuration does not load successfully
     */
    static load(app: string, opts?: IConfigOpts): Promise<Config>;
    /**
     * Reload config files from disk in the current project directory.
     * @param opts Options to control how Config class behaves
     * @throws An ImperativeError if the configuration does not load successfully
     */
    reload(opts?: IConfigOpts): Promise<void>;
    /**
     * Save config files to disk and store secure properties in vault.
     * @param allLayers Specify true to save all config layers instead of only the active one
     */
    save(allLayers?: boolean): Promise<void>;
    /**
     * Access the config API for manipulating profiles, plugins, layers, and secure values.
     */
    get api(): {
        profiles: ConfigProfiles;
        plugins: ConfigPlugins;
        layers: ConfigLayers;
        secure: ConfigSecure;
    };
    /**
     * True if any config layers exist on disk, otherwise false.
     */
    get exists(): boolean;
    /**
     * List of absolute file paths for all config layers.
     */
    get paths(): string[];
    /**
     * List of all config layers.
     * Returns a clone to prevent accidental edits of the original object.
     */
    get layers(): IConfigLayer[];
    /**
     * List of properties across all config layers.
     * Returns a clone to prevent accidental edits of the original object.
     */
    get properties(): IConfig;
    /**
     * App name used in config filenames (e.g., *my_cli*.config.json)
     */
    get appName(): string;
    /**
     * Filename used for config JSONC files
     */
    get configName(): string;
    /**
     * Filename used for user config JSONC files
     */
    get userConfigName(): string;
    /**
     * Filename used for config schema JSON files
     */
    get schemaName(): string;
    /**
     * Schema file path used by the active layer
     */
    getSchemaInfo(): IConfigSchemaInfo;
    /**
     * Search up the directory tree for the directory containing the
     * specified config file.
     *
     * @param file Contains the name of the desired config file
     * @param opts.ignoreDirs Contains an array of directory names to be
     *        ignored (skipped) during the search.
     * @param opts.startDir Contains the name of the directory where the
     *        search should be started. Defaults to working directory.
     *
     * @returns The full path name to config file or null if not found.
     */
    static search(file: string, opts?: {
        ignoreDirs?: string[];
        startDir?: string;
    }): string;
    /**
     * The properties object with secure values masked.
     * @type {IConfig}
     * @memberof Config
     */
    get maskedProperties(): IConfig;
    /**
     * Set value of a property in the active config layer.
     * TODO: more validation
     *
     * @param propertyPath Property path
     * @param value Property value
     * @param opts Optional parameters to change behavior
     * * `parseString` - If true, strings will be converted to a more specific
     *                   type like boolean or number when possible
     * * `secure` - If true, the property will be stored securely.
     *              If false, the property will be stored in plain text.
     */
    set(propertyPath: string, value: any, opts?: {
        parseString?: boolean;
        secure?: boolean;
    }): void;
    /**
     * Unset value of a property in the active config layer.
     * @param propertyPath Property path
     * @param opts Include `secure: false` to preserve property in secure array
     */
    delete(propertyPath: string, opts?: {
        secure?: boolean;
    }): void;
    /**
     * Set the $schema value at the top of the config JSONC.
     * Also save the schema to disk if an object is provided.
     * @param schema The URI of JSON schema, or a schema object to use
     */
    setSchema(schema: string | object): void;
    /**
     * Check if a layer exists in the given path
     *
     * @param inDir The directory to which you want to look for the layer.
     */
    layerExists(inDir: string, user?: boolean): boolean;
    /**
     * Form the path name of the team config file to display in messages.
     * Always return the team name (not the user name).
     * If the a team configuration is active, return the full path to the
     * config file.
     *
     * @param options - a map containing option properties. Currently, the only
     *                  property supported is a boolean named addPath.
     *                  {addPath: true | false}
     *
     * @returns The path (if requested) and file name of the team config file.
     */
    formMainConfigPathNm(options: any): string;
}
