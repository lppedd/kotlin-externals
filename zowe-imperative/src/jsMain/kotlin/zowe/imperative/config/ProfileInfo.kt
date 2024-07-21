@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import js.promise.Promise
import zowe.imperative.config.doc.*
import zowe.imperative.profiles.doc.definition.IProfileSchema
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.Session
import zowe.imperative.rest.session.doc.IOptionsForAddConnProps
import zowe.imperative.rest.session.doc.ISession

/**
 * This class provides functions to retrieve profile-related information. It can load the relevant
 * configuration files, merge all possible profile argument values using the Zowe
 * order-of-precedence, and access desired profile attributes from the Zowe configuration settings.
 *
 * Pseudocode examples:
 *
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
 */
external class ProfileInfo {
  /**
   * Constructor for ProfileInfo class.
   *
   * @param appName The name of the application (like "zowe" in zowe.config.json) whose
   *   configuration you want to access.
   * @param profInfoOpts Options that will control the behavior of ProfileInfo.
   */
  constructor(appName: String, profInfoOpts: IProfOpts = definedExternally)

  /**
   * Update a given property regardless of whether it's found in the config file or not This
   * function supports v1 profiles
   *
   * @param options Set of options needed to update a given property
   */
  fun updateProperty(options: IProfInfoUpdatePropOpts): Promise<Unit>

  /**
   * Update a given property with the value provided. This function only works for properties that
   * can be found in the config files (including secure arrays). If the property cannot be found,
   * this function will resolve to false This function supports v1 profiles
   *
   * @param options Set of options required to update a known property
   */
  fun updateKnownProperty(options: IProfInfoUpdateKnownPropOpts): Promise<Boolean>

  /**
   * Remove a known property from the ProfileInfo class This method will call the
   * updateKnownProperty method with a value set to `undefined` and serves as a helper function to
   * make is easier to understand when a known property is removed.
   *
   * The example below describes how to remove a property
   *
   *     // Using the removeKnownProperty method
   *     profileInfo.removeKnownProperty({mergedArgs, property: "someProperty"});
   *     // Using the updateKnownProperty method
   *     profileInfo.updateKnownProperty({mergedArgs, property: "someProperty", value: undefined, isSecure: false});
   *
   * @param options Set of options required to remove a known property
   * @return Returns a boolean indicating if the property has been removed
   */
  fun removeKnownProperty(options: IProfInfoRemoveKnownPropOpts): Promise<Boolean>

  /**
   * Get all of the typed profiles in the configuration.
   *
   * @param profileType Limit selection to only profiles of the specified type. If not supplied, the
   *   names of all typed profiles are returned.
   * @return An array of profile attribute objects. In addition to the name, you get the profile
   *   type, an indicator of whether the profile is the default profile for that type, and the
   *   location of that profile.
   *
   *   If no profile exists for the specified type (or if no profiles of any kind exist), we return
   *   an empty array ie, length is zero.
   */
  fun getAllProfiles(
    profileType: String = definedExternally,
    options: IGetAllProfilesOptions = definedExternally,
  ): Array<IProfAttrs>

  /**
   * Get the default profile for the specified profile type.
   *
   * @param profileType The type of profile of interest.
   * @return The default profile. If no profile exists for the specified type, we return null;
   */
  fun getDefaultProfile(profileType: String): IProfAttrs?

  /**
   * Get the Config object used to manipulate the team configuration on disk.
   *
   * Our current market direction is to encourage customers to edit the team configuration files in
   * their favorite text editor.
   *
   * If you must ignore this recommended practice, you must use the Config class to manipulate the
   * team config files. This class has a more detailed and therefore more complicated API, but it
   * does contain functions to write data to the team configuration files.
   *
   * You must call ProfileInfo.readProfilesFromDisk() before calling this function.
   *
   * @return An instance of the Config class that can be used to manipulate the team configuration
   *   on disk.
   */
  fun getTeamConfig(): Config

  /**
   * Helper function to identify if the existing config is secure or not
   *
   * @return true if the teamConfig is storing credentials securely, false otherwise
   */
  fun isSecured(): Boolean

  /**
   * Merge all of the available values for arguments defined for the specified profile. Values are
   * retrieved from the following sources. Each successive source will override the previous source.
   * - A default value for the argument that is defined in the profile definition.
   * - A value defined in the base profile.
   * - A value defined in the specified service profile.
   * - For a team configuration, both the base profile values and the service profile values will be
   *   overridden with values from a zowe.config.user.json file (if it exists).
   * - An environment variable for that argument (if environment overrides are enabled).
   *
   * @param profile The profile whose arguments are to be merged.
   * @param mergeOpts Options to use when merging arguments. This parameter is not required.
   *   Defaults will be used.
   * @return An object that contains an array of known profile argument values and an array of
   *   required profile arguments which have no value assigned. Either of the two arrays could be of
   *   zero length, depending on the user's configuration and environment.
   *
   *   We will return null if the profile does not exist in the current Zowe configuration.
   */
  fun mergeArgsForProfile(
    profile: IProfAttrs,
    mergeOpts: IProfMergeArgOpts = definedExternally,
  ): IProfMergedArg

  /**
   * Merge all of the available values for arguments defined for the specified profile type. See
   * mergeArgsForProfile() for details about the merging algorithm. The intended use is when no
   * profile of a specific type exists. The consumer app can prompt for values for missing arguments
   * and then perform the desired operation.
   *
   * @param profileType The type of profile of interest.
   * @param mergeOpts Options to use when merging arguments. This parameter is not required.
   *   Defaults will be used.
   * @return The complete set of required properties;
   */
  fun mergeArgsForProfileType(
    profileType: String,
    mergeOpts: IProfMergeArgOpts = definedExternally,
  ): IProfMergedArg

  /**
   * Read either the new team configuration files (if any exist) or read the old-school profile
   * files.
   *
   * @param teamCfgOpts The optional choices used when reading a team configuration. This parameter
   *   is ignored, if the end-user is using old-school profiles.
   */
  fun readProfilesFromDisk(teamCfgOpts: IConfigOpts = definedExternally): Promise<Unit>

  /**
   * Function to ensure the credential manager will load successfully
   * Returns true if it will load, or the credentials are not secured. Returns false if it will not load.
   */
  fun profileManagerWillLoad(): Promise<Boolean>

  /**
   * Returns an indicator of whether we are using a team configuration or old-school profiles.
   *
   * You must call ProfileInfo.readProfilesFromDisk() before calling this function.
   *
   * @return True when we are using a team config. False means old-school profiles.
   */
  val usingTeamConfig: Boolean

  /**
   * Returns whether a valid schema was found (works for v1 and v2 configs)
   */
  val hasValidSchema: Boolean

  /**
   * Gather information about the paths in osLoc
   *
   * @param profile Profile attributes gathered from getAllProfiles
   */
  fun getOsLocInfo(profile: IProfAttrs): Array<IProfLocOsLoc>

  /**
   * Load value of secure argument from the vault.
   *
   * @param arg Secure argument object
   */
  fun loadSecureArg(arg: IProfArgAttrs): Any?

  /**
   * Adds a profile type to the loaded Zowe config. The profile type must first be added to the
   * schema using `addProfileTypeToSchema`.
   *
   * @param profileType The profile type to add
   * @param layerPath A dot-separated path that points to a layer in the config (default: top-most
   *   layer)
   *
   *   Example: “outer.prod” would add a profile into the “prod” layer (which is contained in “outer”
   *   layer)
   *
   * @return `true` if added to the loaded config; `false` otherwise
   */
  fun addProfileToConfig(
    profileType: String,
    layerPath: String = definedExternally,
  ): Boolean

  /**
   * Adds a profile type to the schema, and tracks its contribution in extenders.json.
   *
   * NOTE: `readProfilesFromDisk` must be called at least once before adding new profile types.
   *
   * @param profileType The new profile type to add to the schema
   * @param typeInfo Type metadata for the profile type (schema, source app.,
   *   optional version)
   * @return The result of adding the profile type to the schema
   */
  fun addProfileTypeToSchema(
    profileType: String,
    typeInfo: IExtenderTypeInfo,
  ): IAddProfTypeResult

  /**
   * Adds a profile type to the schema, and tracks its contribution in extenders.json.
   *
   * NOTE: `readProfilesFromDisk` must be called at least once before adding new profile types.
   *
   * @param profileType The new profile type to add to the schema
   * @param typeInfo Type metadata for the profile type (schema, source app.,
   *   optional version)
   * @param updateProjectSchema Automatically update a project-level schema if one exists
   * @return The result of adding the profile type to the schema
   */
  fun addProfileTypeToSchema(
    profileType: String,
    typeInfo: IExtenderTypeInfo,
    updateProjectSchema: Boolean,
  ): IAddProfTypeResult

  /**
   * Builds the entire schema based on the available profile types and application sources.
   *
   * @param sources Include profile types contributed by these sources when building the schema
   *     - Source applications are tracked in the “from” list for each profile type in
   *       extenders.json
   *
   * @param layer The config layer to build a schema for
   *     - If a layer is not specified, `buildSchema` will use the active layer.
   *
   * @return A config schema containing all applicable profile types
   */
  fun buildSchema(
    sources: Array<String> = definedExternally,
    layer: IConfigLayer = definedExternally,
  ): IConfigSchema

  /**
   * @param sources (optional) Only include available types from the given list of sources
   * @return a list of all available profile types
   */
  fun getProfileTypes(sources: Array<String> = definedExternally): Array<String>

  /**
   * Returns the schema object belonging to the specified profile type.
   *
   * @param profileType The profile type to retrieve the schema from
   * @return The schema object provided by the specified profile type
   */
  fun getSchemaForType(profileType: String): IProfileSchema

  companion object {
    /**
     * Create a session from profile arguments that have been retrieved from ProfileInfo functions.
     *
     * @param profArgs An array of profile arguments.
     * @param connOpts Options that alter our actions. See IOptionsForAddConnProps. The connOpts
     *   parameter need not be supplied. Default properties may be added to any supplied connOpts.
     *   The only option values used by this function are: connOpts.requestToken
     *   connOpts.defaultTokenType
     * @return A session that can be used to connect to a remote host.
     */
    fun createSession(
      profArgs: Array<IProfArgAttrs>,
      connOpts: IOptionsForAddConnProps = definedExternally,
    ): Session

    /**
     * Convert an IProfAttrs object into an IProfileLoaded objects This is a convenience function.
     * IProfileLoaded was frequently passed among functions. This conversion function allows
     * existing code to acquire values in the IProfAttrs structure but pass those values around in
     * the older IProfileLoaded structure. The IProfAttrs properties will be copied as follows:
     *
     *      IProfileLoaded.name    <-- IProfAttrs.profName
     *      IProfileLoaded.type    <-- IProfAttrs.profType
     *      IProfileLoaded.profile <-- profAttrs
     *
     * @param profAttrs A profile attributes object.
     * @param dfltProfLoadedVals A JSON object containing additional names from IProfileLoaded for
     *   which a value should be supplied. IProfileLoaded contains more properties than IProfAttrs.
     *   The items in this object will be placed into the resulting IProfileLoaded object. We use
     *   type "any" because all of the required properties of IProfileLoaded will not be supplied by
     *   dfltProfLoadedVals. If dfltProfLoadedVals is not supplied, only the following minimal set
     *   if hard-coded properties will be added to the IProfileLoaded object.
     *
     *   IProfileLoaded.message <-- "" (an empty string) IProfileLoaded.failNotFound <-- false
     *
     * @return An IProfileLoaded object;
     */
    fun profAttrsToProfLoaded(
      profAttrs: IProfAttrs,
      dfltProfLoadedVals: Any? = definedExternally,
    ): IProfileLoaded

    /**
     * Initialize a session configuration object with the arguments from profArgs
     *
     * @param profArgs An array of profile argument attributes.
     * @param argNames An array of argument names to load from the profile. Defaults to all
     *   arguments that have an associated ISession property.
     * @return A session containing all of the supplied profile argument attributes that are
     *   relevant to a session.
     */
    fun initSessCfg(
      profArgs: Array<IProfArgAttrs>,
      argNames: Array<String> = definedExternally,
    ): ISession
  }
}
