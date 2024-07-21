import { IProfArgAttrs } from "./doc/IProfArgAttrs";
import { IProfAttrs } from "./doc/IProfAttrs";
import { IProfLocOsLoc } from "./doc/IProfLoc";
import { IProfMergeArgOpts } from "./doc/IProfMergeArgOpts";
import { IProfMergedArg } from "./doc/IProfMergedArg";
import { IConfigSchema } from "./doc/IConfigSchema";
import { IProfOpts } from "./doc/IProfOpts";
import { Config } from "./Config";
import { IConfigOpts } from "./doc/IConfigOpts";
import { IProfileLoaded, IProfileSchema } from "../../profiles";
import { IOptionsForAddConnProps, ISession, Session } from "../../rest";
import { IProfInfoUpdateKnownPropOpts, IProfInfoUpdatePropOpts } from "./doc/IProfInfoUpdatePropOpts";
import { IGetAllProfilesOptions } from "./doc/IProfInfoProps";
import { IProfInfoRemoveKnownPropOpts } from "./doc/IProfInfoRemoveKnownPropOpts";
import { IAddProfTypeResult, IExtenderTypeInfo } from "./doc/IExtenderOpts";
import { IConfigLayer } from "..";
/**
 * This class provides functions to retrieve profile-related information.
 * It can load the relevant configuration files, merge all possible
 * profile argument values using the Zowe order-of-precedence, and
 * access desired profile attributes from the Zowe configuration settings.
 *
 * Pseudocode examples:
 * <pre>
 *    // Construct a new object. Use it to read the profiles from disk.
 *    // ProfileInfo functions throw a ProfInfoErr exception for errors.
 *    // You can catch those errors and test the errorCode for known
 *    // values. We are only showing the try/catch on the function
 *    // below, but it applies to any ProfileInfo function.
 *    profInfo = new ProfileInfo("zowe");
 *    try {
 *        await profInfo.readProfilesFromDisk();
 *    } catch(err) {
 *        if (err instanceof ProfInfoErr) {
 *            if (err.errcode == ProfInfoErr.CANT_GET_SCHEMA_URL) {
 *                youTakeAnAlternateAction();
 *            } else {
 *                // report the error
 *            }
 *        } else {
 *            // handle other exceptions
 *        }
 *    }
 *
 *    // Maybe you want the list of all zosmf profiles
 *    let arrayOfProfiles = profInfo.getAllProfiles("zosmf");
 *    youDisplayTheListOfProfiles(arrayOfProfiles);
 *
 *    // Maybe you want the default zosmf profile
 *    let zosmfProfile = profInfo.getDefaultProfile("zosmf");
 *    youUseTheProfile(zosmfProfile);
 *
 *    // Maybe you want the arg values for the default JCLCheck profile
 *    let jckProfile = profInfo.getDefaultProfile("jclcheck");
 *    let jckMergedArgs = profInfo.mergeArgsForProfile(jckProfile);
 *    let jckFinalArgs = youPromptForMissingArgsAndCombineWithKnownArgs(
 *        jckMergedArgs.knownArgs, jckMergedArgs.missingArgs
 *    );
 *    youRunJclCheck(jckFinalArgs);
 *
 *    // Maybe no profile of type "zosmf" even exists.
 *    let zosmfProfiles = profInfo.getAllProfiles("zosmf");
 *    if (zosmfProfiles.length == 0) {
 *        // No zosmf profile exists
 *        // Merge any required arg values for the zosmf profile type
 *        let zosmfMergedArgs =
 *            profInfo.mergeArgsForProfileType("zosmf");
 *
 *        // Values of secure arguments must be loaded separately. You can
 *        // freely log the contents of zosmfMergedArgs without leaking secure
 *        // argument values, until they are loaded with the lines below.
 *        zosmfMergedArgs.knownArgs.forEach((arg) => {
 *            if (arg.secure) arg.argValue = profInfo.loadSecureArg(arg);
 *        });
 *
 *        let finalZosmfArgs =
 *            youPromptForMissingArgsAndCombineWithKnownArgs(
 *                zosmfMergedArgs.knownArgs,
 *                zosmfMergedArgs.missingArgs
 *            );
 *        youRunSomeZosmfCommand(finalZosmfArgs);
 *    }
 *
 *    // So you want to write to a config file? You must use your own
 *    // old-school techniques to write to old-school profiles.
 *    // You then use alternate logic for a team config.
 *    // You must use the Config API to write to a team configuration.
 *    // See the Config class documentation for functions to set
 *    // and save team config arguments.
 *
 *    // Let's save some zosmf arguments from the example above.
 *    let yourZosmfArgsToWrite: IProfArgAttrs =
 *        youSetValuesToOverwrite(
 *            zosmfMergedArgs.knownArgs, zosmfMergedArgs.missingArgs
 *        );
 *    if (profInfo.usingTeamConfig {
 *        let configObj: Config = profInfo.getTeamConfig();
 *        youWriteArgValuesUsingConfigObj(
 *            configObj, yourZosmfArgsToWrite
 *        );
 *    } else {
 *        youWriteOldSchoolProfiles(yourZosmfArgsToWrite);
 *    }
 * </pre>
 */
export declare class ProfileInfo {
    private mLoadedConfig;
    private mUsingTeamConfig;
    private mAppName;
    private mImpLogger;
    private mOldSchoolProfileCache;
    private mOldSchoolProfileRootDir;
    private mOldSchoolProfileDefaults;
    private mOldSchoolProfileTypes;
    private mOverrideWithEnv;
    private mHasValidSchema;
    /**
     * Cache of profile schema objects mapped by profile type and config path
     * if applicable. Examples of map keys:
     *  - For team config: "/root/.zowe/zowe.config.json:zosmf"
     *  - For old profiles: "zosmf"
     */
    private mProfileSchemaCache;
    private mCredentials;
    private mExtendersJson;
    /**
     * Constructor for ProfileInfo class.
     *
     * @param appName
     *        The name of the application (like "zowe" in zowe.config.json)
     *        whose configuration you want to access.
     *
     * @param profInfoOpts
     *        Options that will control the behavior of ProfileInfo.
     */
    constructor(appName: string, profInfoOpts?: IProfOpts);
    /**
     * Update a given property regardless of whether it's found in the config file or not
     * This function supports v1 profiles
     * @param options Set of options needed to update a given property
     */
    updateProperty(options: IProfInfoUpdatePropOpts): Promise<void>;
    /**
     * Update a given property with the value provided.
     * This function only works for properties that can be found in the config files (including secure arrays).
     * If the property cannot be found, this function will resolve to false
     * This function supports v1 profiles
     * @param options Set of options required to update a known property
     */
    updateKnownProperty(options: IProfInfoUpdateKnownPropOpts): Promise<boolean>;
    /**
     * Remove a known property from the ProfileInfo class
     * This method will call the updateKnownProperty method with a value set to `undefined` and serves as a helper function
     * to make is easier to understand when a known property is removed.
     * @example
     * The example below describes how to remove a property
     * ```
     *     // Using the removeKnownProperty method
     *     profileInfo.removeKnownProperty({mergedArgs, property: "someProperty"});
     *     // Using the updateKnownProperty method
     *     profileInfo.updateKnownProperty({mergedArgs, property: "someProperty", value: undefined, isSecure: false});
     * ```
     * @param options Set of options required to remove a known property
     * @returns Returns a boolean indicating if the property has been removed
     */
    removeKnownProperty(options: IProfInfoRemoveKnownPropOpts): Promise<boolean>;
    /**
     * Get all of the typed profiles in the configuration.
     *
     * @param profileType
     *        Limit selection to only profiles of the specified type.
     *        If not supplied, the names of all typed profiles are returned.
     *
     * @returns An array of profile attribute objects.
     *          In addition to the name, you get the profile type,
     *          an indicator of whether the profile is the default profile
     *          for that type, and the location of that profile.
     *
     *          If no profile exists for the specified type (or if
     *          no profiles of any kind exist), we return an empty array
     *          ie, length is zero.
     */
    getAllProfiles(profileType?: string, options?: IGetAllProfilesOptions): IProfAttrs[];
    /**
     * Get the default profile for the specified profile type.
     *
     * @param profileType
     *        The type of profile of interest.
     *
     * @returns The default profile. If no profile exists
     *          for the specified type, we return null;
     */
    getDefaultProfile(profileType: string): IProfAttrs | null;
    /**
     * Get the Config object used to manipulate the team configuration on disk.
     *
     * Our current market direction is to encourage customers to edit the
     * team configuration files in their favorite text editor.
     *
     * If you must ignore this recommended practice, you must use the Config
     * class to manipulate the team config files. This class has a more detailed
     * and therefore more complicated API, but it does contain functions to
     * write data to the team configuration files.
     *
     * You must call ProfileInfo.readProfilesFromDisk() before calling this function.
     *
     * @returns An instance of the Config class that can be used to manipulate
     *          the team configuration on disk.
     */
    getTeamConfig(): Config;
    /**
     * Helper function to identify if the existing config is secure or not
     * @returns true if the teamConfig is storing credentials securely, false otherwise
     */
    isSecured(): boolean;
    /**
     * Create a session from profile arguments that have been retrieved from
     * ProfileInfo functions.
     *
     * @param profArgs
     *      An array of profile arguments.
     *
     * @param connOpts
     *      Options that alter our actions. See IOptionsForAddConnProps.
     *      The connOpts parameter need not be supplied.
     *      Default properties may be added to any supplied connOpts.
     *      The only option values used by this function are:
     *          connOpts.requestToken
     *          connOpts.defaultTokenType
     *
     * @returns A session that can be used to connect to a remote host.
     */
    static createSession(profArgs: IProfArgAttrs[], connOpts?: IOptionsForAddConnProps): Session;
    /**
     * Merge all of the available values for arguments defined for the
     * specified profile. Values are retrieved from the following sources.
     * Each successive source will override the previous source.
     * - A default value for the argument that is defined in the profile definition.
     * - A value defined in the base profile.
     * - A value defined in the specified service profile.
     * - For a team configuration, both the base profile values and the
     *   service profile values will be overridden with values from a
     *   zowe.config.user.json file (if it exists).
     * - An environment variable for that argument (if environment overrides
     *   are enabled).
     *
     * @param profile
     *        The profile whose arguments are to be merged.
     *
     * @param mergeOpts
     *        Options to use when merging arguments.
     *        This parameter is not required. Defaults will be used.
     *
     * @returns An object that contains an array of known profile argument
     *          values and an array of required profile arguments which
     *          have no value assigned. Either of the two arrays could be
     *          of zero length, depending on the user's configuration and
     *          environment.
     *
     *          We will return null if the profile does not exist
     *          in the current Zowe configuration.
     */
    mergeArgsForProfile(profile: IProfAttrs, mergeOpts?: IProfMergeArgOpts): IProfMergedArg;
    /**
     * Merge all of the available values for arguments defined for the
     * specified profile type. See mergeArgsForProfile() for details
     * about the merging algorithm.
     * The intended use is when no profile of a specific type exists.
     * The consumer app can prompt for values for missing arguments
     * and then perform the desired operation.
     *
     * @param profileType
     *        The type of profile of interest.
     *
     * @param mergeOpts
     *        Options to use when merging arguments.
     *        This parameter is not required. Defaults will be used.
     *
     * @returns The complete set of required properties;
     */
    mergeArgsForProfileType(profileType: string, mergeOpts?: IProfMergeArgOpts): IProfMergedArg;
    /**
     * Convert an IProfAttrs object into an IProfileLoaded objects
     * This is a convenience function. IProfileLoaded was frequently passed
     * among functions. This conversion function allows existing code to
     * acquire values in the IProfAttrs structure but pass those values
     * around in the older IProfileLoaded structure. The IProfAttrs
     * properties will be copied as follows:
     *
     *      IProfileLoaded.name    <-- IProfAttrs.profName
     *      IProfileLoaded.type    <-- IProfAttrs.profType
     *      IProfileLoaded.profile <-- profAttrs
     *
     * @param profAttrs
     *      A profile attributes object.
     *
     * @param dfltProfLoadedVals
     *      A JSON object containing additional names from IProfileLoaded for
     *      which a value should be supplied. IProfileLoaded contains more
     *      properties than IProfAttrs. The items in this object will be
     *      placed into the resulting IProfileLoaded object.
     *      We use type "any" because all of the required properties of
     *      IProfileLoaded will not be supplied by dfltProfLoadedVals.
     *      If dfltProfLoadedVals is not supplied, only the following minimal
     *      set if hard-coded properties will be added to the IProfileLoaded object.
     *
     *      IProfileLoaded.message      <-- "" (an empty string)
     *      IProfileLoaded.failNotFound <-- false
     *
     * @returns An IProfileLoaded object;
     */
    static profAttrsToProfLoaded(profAttrs: IProfAttrs, dfltProfLoadedVals?: any): IProfileLoaded;
    /**
     * Read either the new team configuration files (if any exist) or
     * read the old-school profile files.
     *
     * @param teamCfgOpts
     *        The optional choices used when reading a team configuration.
     *        This parameter is ignored, if the end-user is using old-school
     *        profiles.
     */
    readProfilesFromDisk(teamCfgOpts?: IConfigOpts): Promise<void>;
    /**
     * Function to ensure the credential manager will load successfully
     * Returns true if it will load, or the credentials are not secured. Returns false if it will not load.
     */
    profileManagerWillLoad(): Promise<boolean>;
    /**
     * Returns an indicator of whether we are using a team configuration or
     * old-school profiles.
     *
     * You must call ProfileInfo.readProfilesFromDisk() before calling this function.
     *
     * @returns True when we are using a team config. False means old-school profiles.
     */
    get usingTeamConfig(): boolean;
    /**
     * Returns whether a valid schema was found (works for v1 and v2 configs)
     */
    get hasValidSchema(): boolean;
    /**
     * Gather information about the paths in osLoc
     * @param profile Profile attributes gathered from getAllProfiles
     */
    getOsLocInfo(profile: IProfAttrs): IProfLocOsLoc[];
    /**
     * Load value of secure argument from the vault.
     * @param arg Secure argument object
     */
    loadSecureArg(arg: IProfArgAttrs): any;
    /**
     * Initialize a session configuration object with the arguments
     * from profArgs
     *
     * @param profArgs
     *      An array of profile argument attributes.
     * @param argNames
     *      An array of argument names to load from the profile. Defaults to
     *      all arguments that have an associated ISession property.
     *
     * @returns A session containing all of the supplied profile argument
     *          attributes that are relevant to a session.
     */
    static initSessCfg(profArgs: IProfArgAttrs[], argNames?: string[]): ISession;
    /**
     * Ensures that ProfileInfo.readProfilesFromDisk() is called before
     * an operation that requires that information.
     */
    private ensureReadFromDisk;
    /**
     * Perform a rudimentary initialization of some Imperative utilities.
     * We must do this because VSCode apps do not typically call imperative.init.
     */
    private initImpUtils;
    /**
     * Load any profile schema objects found on disk and cache them. For team
     * config, we check each config layer and load its schema JSON if there is
     * one associated. For old school profiles, we load the meta YAML file for
     * each profile type if it exists in the profile root directory.
     */
    private loadAllSchemas;
    /**
     * Adds a profile type to the loaded Zowe config.
     * The profile type must first be added to the schema using `addProfileTypeToSchema`.
     *
     * @param {string} profileType The profile type to add
     * @param [layerPath] A dot-separated path that points to a layer in the config (default: top-most layer)
     *
     * Example: “outer.prod” would add a profile into the “prod” layer (which is contained in “outer” layer)
     * @returns {boolean} `true` if added to the loaded config; `false` otherwise
     */
    addProfileToConfig(profileType: string, layerPath?: string): boolean;
    /**
     * Updates the schema of the provided config layer to contain the new profile type.
     *
     * @param {string} profileType The profile type to add into the schema
     * @param {IProfileSchema} typeSchema The schema for the profile type
     * @param {IConfigLayer} layer The config layer that matches the schema to update
     * @param [versionChanged] Whether the version has changed for the schema (optional)
     * @returns {boolean} `true` if added to the schema; `false` otherwise
     */
    private updateSchemaAtLayer;
    /**
     * This helper function removes all command-related properties from the given schema properties object and returns it.
     * This is so we can easily compare schemas from disk with those that are registered with type ICommandProfileSchema.
     * It's also been added to avoid a breaking change (as we currently allow ICommandProfileSchema objects to be registered).
     * @param obj The properties object from the schema
     * @returns The properties object, but with all of the command-related properties removed
     */
    private omitCmdPropsFromSchema;
    private addToGlobalSchema;
    /**
     * Adds a profile type to the schema, and tracks its contribution in extenders.json.
     *
     * NOTE: `readProfilesFromDisk` must be called at least once before adding new profile types.
     *
     * @param {string} profileType The new profile type to add to the schema
     * @param {IExtenderTypeInfo} typeInfo Type metadata for the profile type (schema, source app., optional version)
     * @param [updateProjectSchema] Automatically update a project-level schema if one exists.
     * @returns {IAddProfTypeResult} the result of adding the profile type to the schema
     */
    addProfileTypeToSchema(profileType: string, typeInfo: IExtenderTypeInfo, updateProjectSchema?: boolean): IAddProfTypeResult;
    /**
     * Builds the entire schema based on the available profile types and application sources.
     *
     * @param [sources] Include profile types contributed by these sources when building the schema
     *   - Source applications are tracked in the “from” list for each profile type in extenders.json
     * @param [layer] The config layer to build a schema for
     *   - If a layer is not specified, `buildSchema` will use the active layer.
     * @returns {IConfigSchema} A config schema containing all applicable profile types
     */
    buildSchema(sources?: string[], layer?: IConfigLayer): IConfigSchema;
    /**
     * @param [sources] (optional) Only include available types from the given list of sources
     * @returns a list of all available profile types
    */
    getProfileTypes(sources?: string[]): string[];
    /**
     * Returns the schema object belonging to the specified profile type.
     *
     * @param {string} profileType The profile type to retrieve the schema from
     * @returns {IProfileSchema} The schema object provided by the specified profile type
     */
    getSchemaForType(profileType: string): IProfileSchema;
    /**
     * Get all of the subprofiles in the configuration.
     *
     * @param path
     *          The short form profile name dotted path
     * @param jsonPath
     *          The long form profile dotted path
     * @param profObj
     *          The profiles object from the parent profile.
     *          Contains the subprofiles to search through.
     * @param profileType
     *          Limit selection to only profiles of the specified type.
     *          If not supplied, the names of all typed profiles are returned.
     *
     * @returns An array of profile attribute objects.
     *          In addition to the name, you get the profile type,
     *          an indicator of whether the profile is the default profile
     *          for that type, and the location of that profile.
     *
     *          If no profile exists for the specified type (or if
     *          no profiles of any kind exist), we return an empty array
     *          ie, length is zero.
     */
    private getTeamSubProfiles;
    /**
     *
     * @param path
     *              The short form profile name dotted path
     * @param profileType
     *              Limit selection to profiles of the specified type
     * @returns A boolean true if the profile is a default profile,
     *          and a boolean false if the profile is not a default profile
     */
    private isDefaultTeamProfile;
    /**
     *
     * @param jsonPath The long form JSON path of the profile we are searching for.
     * @param excludeHomeDir The long form JSON path of the profile we are searching for.
     * @returns A string array containing the location of all files containing the specified team profile
     */
    private findTeamOsLocation;
    /**
     * Get arg data type from a "typeof" string. Arg data types can be basic
     * types like string, number, and boolean. If they are any other type or a
     * union of types, their type will be represented simply as object.
     * @param propType The type of a profile property
     */
    private argDataType;
    /**
     * Given a profile name and property name, compute the profile location
     * object containing OS and JSON locations.
     * @param opts Set of options that allow this method to get the profile location
     */
    private argTeamConfigLoc;
    /**
     * Given a profile name and type, compute the profile location object
     * containing OS location.
     * @param profileName Name of an old school profile (e.g., LPAR1)
     * @param profileType Type of an old school profile (e.g., zosmf)
     */
    private argOldProfileLoc;
    /**
     * Given a profile name and type, return the OS location of the associated
     * YAML file.
     * @param profileName Name of an old school profile (e.g., LPAR1)
     * @param profileType Type of an old school profile (e.g., zosmf)
     */
    private oldProfileFilePath;
    /**
     * Load the cached schema object for a profile type. Returns null if
     * schema is not found in the cache.
     * @param profile Profile attributes object
     */
    private loadSchema;
    /**
     * Override values in a merged argument object with values found in
     * environment variables. The choice to override enviroment variables is
     * controlled by an option on the ProfileInfo constructor.
     *
     * @param mergedArgs
     *      On input, this must be an object containing merged arguments
     *      obtained from configuration settings. This function will override
     *      values in mergedArgs.knownArgs with values found in environment
     *      variables. It will also move arguments from mergedArgs.missingArgs
     *      into mergedArgs.knownArgs if a value is found in an environment
     *      variable for any missingArgs.
     */
    private overrideWithEnv;
}
