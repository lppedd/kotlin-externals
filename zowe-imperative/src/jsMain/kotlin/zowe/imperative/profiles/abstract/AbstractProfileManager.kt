@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.abstract

import js.collections.JsMap
import js.promise.Promise
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.doc.definition.IProfileSchema
import zowe.imperative.profiles.doc.parms.*
import zowe.imperative.profiles.doc.response.*

/**
 * The abstract profile manager contains most (if not all in some cases) methods to manage
 * Imperative profiles. Profiles are user configuration documents intended to be used on commands,
 * as a convenience, to supply a slew of additional input and configuration (normally more than
 * would be feasible as command arguments). See the "IProfile" interface for a detailed description
 * of profiles, their use case, and examples.
 *
 * The abstract manager is implemented by (at least as part of Imperative) the BasicProfileManager.
 * The BasicProfileManager implements the save, load, update, etc. methods in, as the name implies,
 * a "basic" way. In general, the abstract manager contains all parameter and profile validation
 * code, methods to write/read/etc and the Basic Manager uses most of the internal methods to
 * perform the "work". The basic manager does in some cases change the default abstract behavior
 * (such as for loadAll profile and loadDependencies).
 *
 * Imperative, however, uses the "Cli Profile Manager", which extends the "Basic Profile
 * Manager". The CLI Manager includes additional capabilities, such as creating or updating a
 * profile from command line arguments.
 *
 * In general, Imperative CLI's will use the "Cli Profile Manager", where the "Basic Profile
 * Manager" is normally sufficient for usage outside of Imperative (for usage in building extensions
 * to editors, Electron apps, programmatic usage of APIs built by implementations of Imperative,
 * etc.), although either can be used.
 *
 * It is not an absolute requirement, but in the case of an Imperative CLI, the "Basic Profile
 * Manager initialize()" API is invoked to create the required directories and subdirectories. This
 * is NOT a requirement, but avoiding "initialize()" means you must supply all configuration
 * information to the manager when creating an instance. See the "initialize()" API method in the
 * "BasicProfileManager" for full details.
 */
abstract external class AbstractProfileManager<T : IProfileTypeConfiguration> {
  /**
   * Creates an instance of ProfileManager - Performs basic parameter validation and will create the
   * required profile root directory (if it does not exist) and will attempt to load type
   * configurations from the existing profile root directory (unless the type definitions are passed
   * on the constructor parameters).
   *
   * @param parms See the interface for details.
   */
  constructor(parms: IProfileManager<T>)

  /**
   * Accessor for the load counter (protects against circular loading)
   */
  val loadCounter: JsMap<String, Double>

  /**
   * Accessor for the logger instance - passed on the constructor
   */
  val log: Logger

  /**
   * Accessor the input parameters to the constructor - used sometimes to create other instances of
   * profile managers.
   */
  val managerParameters: IProfileManager<T>

  /**
   * Accessor for the profile type specified on the constructor.
   */
  val profileType: String

  /**
   * Accesor for the product display name.
   */
  val productDisplayName: String

  /**
   * Accessor for the profile type configuration for this manager.
   */
  val profileTypeConfiguration: T

  /**
   * Accessor for the full set of type configurations - passed on the constructor or obtained from
   * reading the profile root directories and meta files.
   */
  val profileTypeConfigurations: Array<T>

  /**
   * Accessor for the schema of this type - JSON schema standard
   */
  val profileTypeSchema: IProfileSchema

  /**
   * Accessor for the profile type root directory (contained within the profile root directory and
   * named by the type itself)
   */
  val profileTypeRootDirectory: String

  /**
   * Accessor for the profile meta file name - constructed as "<type>_meta"
   */
  val profileTypeMetaFileName: String

  /**
   * Accessor for the profile root directory - supplied on the constructor - used to construct the
   * profile type directory.
   */
  val profileRootDirectory: String

  /**
   * Obtains all profile names for the profile "type" specified on the manager. The names are
   * obtained from the filesystem (in the profile type directory) and the meta file is NOT returned
   * in the list.
   *
   * @return The list of profile names (obtained from disk).
   */
  fun getAllProfileNames(): Array<String>

  /**
   * Accessor that returns a copy of the profile configuration document.
   */
  val configurations: Array<IProfileTypeConfiguration>

  /**
   * Save a profile to disk. Ensures that the profile specified is valid (basic and schema
   * validation) and invokes the implementations "saveProfile" method to perform the save and
   * formulate the response.
   *
   * @param parms See interface for details
   * @return The promise that is fulfilled with the response object (see
   *   interface for details) or rejected with an Imperative Error.
   */
  fun <S : ISaveProfile> save(parms: S): Promise<IProfileSaved>

  /**
   * Load a profile from disk. Ensures that the parameters are valid and loads the profile specified
   * by name OR the default profile if requested. If load default is requested, any name supplied is
   * ignored.
   *
   * @param parms See the interface for details.
   * @return The promise that is fulfilled with the response object
   *   (see interface for details) or rejected with an Imperative Error.
   */
  fun <L : ILoadProfile> load(parms: L): Promise<IProfileLoaded>

  /**
   * Validate a profile. Includes basic and schema validation. Can be called explicitly, but is also
   * called during loads and saves to protect the integrity of the profiles against the type
   * definitions.
   *
   * @param parms See the interface for details
   * @return The promise that is fulfilled with the response object
   *   (see interface for details) or rejected with an Imperative Error.
   */
  fun <V : IValidateProfile> validate(parms: V): Promise<IProfileValidated>

  /**
   * Merge two profiles together. Useful when updating existing profiles with a few new fields, for
   * example.
   *
   * @param oldProfile the old profile, fields on this will have lower precedence
   * @param newProfile the new profile, fields on this will have higher precedence
   * @return the merged profile
   */
  fun mergeProfiles(
    oldProfile: IProfile,
    newProfile: IProfile,
  ): IProfile

  /**
   * Deletes a profile from disk. Ensures that the parameters are correct and removes the profile.
   * If the profile is listed as a dependency of other profiles it will NOT delete the profile
   * unless "rejectIfDependency" is set to false.
   *
   * @param parms See the interface for details
   * @return The promise that is fulfilled with the response object
   *   (see interface for details) or rejected with an Imperative Error.
   */
  fun <D : IDeleteProfile> delete(parms: D): Promise<IProfileDeleted>

  /**
   * Update the profile - The action performed is dictacted by the implementation of the Abstract
   * manager.
   *
   * @param parms See the interface for details
   * @return The promise that is fulfilled with the response object
   *   (see interface for details) or rejected with an Imperative Error.
   */
  fun <U : IUpdateProfile> update(parms: U): Promise<IProfileUpdated>

  /**
   * Sets the default profile for the profile managers type.
   *
   * @param name The name of the new default
   * @return The response string (or an error is thrown if the request cannot be completed)
   */
  fun setDefault(name: String): String

  /**
   * Clears the default profile for the profile managers type.
   *
   * @return The response string (or an error is thrown if the request cannot be completed)
   */
  fun clearDefault(): String

  /**
   * Returns the default profile name for this "type" or "undefined" if no default is set.
   *
   * @return The default profile name or undefined.
   */
  fun getDefaultProfileName(): String

  /**
   * Load all profiles - the behavior is dictated by the implementation.
   *
   * @param parms the load parameters - See interface for details
   * @return The list of profiles when the promise is fulfilled or
   *   rejected with an ImperativeError.
   */
  open fun loadAll(parms: ILoadAllProfiles = definedExternally): Promise<Array<IProfileLoaded>>

  /**
   * Save profile - performs the profile save according to the implementation - invoked when all
   * parameters are valid (according the abstract manager).
   *
   * @param parms See interface for details
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun saveProfile(parms: ISaveProfile): Promise<IProfileSaved>

  /**
   * Save profile - performs the profile load according to the implementation - invoked when all
   * parameters are valid (according the abstract manager).
   *
   * @param parms See interface for details
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun loadProfile(parms: ILoadProfile): Promise<IProfileLoaded>

  /**
   * Delete profile - performs the profile delete according to the implementation - invoked when all
   * parameters are valid (according the abstract manager).
   *
   * @param parms See interface for details
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>

  /**
   * Validate profile - performs the profile validation according to the implementation - invoked
   * when all parameters are valid (according the abstract manager).
   *
   * @param parms See interface for details
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun validateProfile(parms: IValidateProfileWithSchema): Promise<IProfileValidated>

  /**
   * Update profile - performs the profile update according to the implementation - invoked when all
   * parameters are valid (according the abstract manager).
   *
   * @param parms See interface for details
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun updateProfile(parms: IUpdateProfile): Promise<IProfileUpdated>

  /**
   * Load a profiles dependencies - dictacted by the implementation.
   *
   * @param name the name of the profile to load dependencies for
   * @param profile The profile to load dependencies for.
   * @param failNotFound True to fail "not found" errors
   * @return The promise fulfilled with response or rejected with an
   *   ImperativeError.
   */
  open fun loadDependencies(
    name: String,
    profile: IProfile,
    failNotFound: Boolean,
  ): Promise<Array<IProfileLoaded>>

  /**
   * Invokes the profile IO method to delete the profile from disk.
   *
   * @param name The name of the profile to delete.
   * @return The path where the profile was.
   */
  fun deleteProfileFromDisk(name: String): String

  /**
   * Performs basic validation of a profile object - ensures that all fields are present (if
   * required).
   *
   * @param name the name of the profile to validate
   * @param type the type of profile to validate
   * @param profile The profile to validate.
   */
  fun validateProfileObject(
    name: String,
    type: String,
    profile: IProfile,
  )

  /**
   * Validates the profile against the schema for its type and reports and errors located.
   *
   * @param name the name of the profile to validate
   * @param profile The profile to validate.
   * @param strict Set to true to enable the "ban unknown properties"
   *   specification of the JSON schema spec. In other words, prevents profiles with "unknown" or
   *   "not defined" proeprties according to the schema document.
   */
  fun validateProfileAgainstSchema(
    name: String,
    profile: IProfile,
    strict: Boolean = definedExternally,
  )

  /**
   * Constructs the full path to the profile of the managers "type".
   *
   * @param name The profile name to construct the path
   * @param type The type - normally the type specified in the manager.
   * @return The full profile directory.
   */
  fun constructFullProfilePath(
    name: String,
    type: String = definedExternally,
  ): String

  /**
   * Locate the existing profile for the name specified.
   *
   * @param name The profile to locate
   * @return The fully qualified path or undefined if not found.
   */
  fun locateExistingProfile(name: String): String

  /**
   * Standard load failed error message and Imperative Error.
   *
   * @param name The name of the profile for which the load failed.
   */
  fun loadFailed(name: String)

  /**
   * Checks if the profile object passed is "empty" - meaning it has no contents other than that
   * type or name. A profile can only specify "dependencies", in the event that it is just acting as
   * a "pointer" to another profile.
   *
   * @param profile The profile to check for "emptiness".
   * @return True if the profile object is empty.
   */
  fun isProfileEmpty(profile: IProfile): Boolean

  /**
   * Loads a specific profile (by name).
   *
   * @param name The name of the profile to load.
   * @param failNotFound Specify false to ignore "not found" errors. Default: true
   * @param loadDependencies Specify false to NOT load dependencies. Default: true
   * @return The promise to fulfill with the response OR reject with an ImperativeError
   */
  fun loadSpecificProfile(
    name: String,
    failNotFound: Boolean = definedExternally,
    loadDependencies: Boolean = definedExternally,
  ): Promise<IProfileLoaded>

  /**
   * Validates a profiles contents against the required dependencies specified on the profile
   * configuration type document. If the document indicates that a dependency is required and that
   * dependency is missing from the input profile, an error is thrown.
   *
   * @param profile The profile to validate dependency specs
   */
  fun validateRequiredDependenciesAreSpecified(profile: IProfile)

  companion object {
    /**
     * The default profile file extension (YAML format) - all profiles are stored in YAML format
     * including the meta profile file.
     */
    val PROFILE_EXTENSION: String

    /**
     * The meta file suffix - always appended to the meta file to distinguish from other profiles.
     * Users then cannot supply a profile name that would conflict with the meta file.
     */
    val META_FILE_SUFFIX: String
  }
}
