import { Logger } from "../../../logger";
import { IDeleteProfile, ILoadProfile, IProfile, IProfileDeleted, IProfileLoaded, IProfileManager, IProfileSaved, IProfileSchema, IProfileTypeConfiguration, IProfileUpdated, IProfileValidated, ISaveProfile, IUpdateProfile, IValidateProfile, IValidateProfileWithSchema, ILoadAllProfiles } from "../doc/";
/**
 * The abstract profile manager contains most (if not all in some cases) methods to manage Imperative profiles. Profiles
 * are user configuration documents intended to be used on commands, as a convenience, to supply a slew of additional
 * input and configuration (normally more than would be feasible as command arguments). See the "IProfile" interface
 * for a detailed description of profiles, their use case, and examples.
 *
 * The abstract manager is implemented by (at least as part of Imperative) the BasicProfileManager. The BasicProfileManager
 * implements the save, load, update, etc. methods in, as the name implies, a "basic" way. In general, the abstract
 * manager contains all parameter and profile validation code, methods to write/read/etc and the Basic Manager uses
 * most of the internal methods to perform the "work". The basic manager does in some cases change the default abstract
 * behavior (such as for loadAll profile and loadDependencies).
 *
 * Imperative, however, uses the the "Cli Profile Manager", which extends the "Basic Profile Manager". The CLI Manager includes
 * additional capabilities, such as creating or updating a profile from command line arguments.
 *
 * In general, Imperative CLI's will use the "Cli Profile Manager", where the "Basic Profile Manager" is normally sufficient
 * for usage outside of Imperative (for usage in building extensions to editors, Electron apps, programmatic usage of
 * APIs built by implementations of Imperative, etc.), although either can be used.
 *
 * It is not an absolute requirement, but in the case of an Imperative CLI, the "Basic Profile Manager initialize()" API
 * is invoked to create the required directories and sub-directories. This is NOT a requirement, but avoiding "initialize()"
 * means you must supply all configuration information to the manager when creating an instance. See the "initialize()" API
 * method in the "BasicProfileManager" for full details.
 *
 * @export
 * @abstract
 * @class AbstractProfileManager
 */
export declare abstract class AbstractProfileManager<T extends IProfileTypeConfiguration> {
    /**
     * The default profile file extension (YAML format) - all profiles are stored in YAML format including
     * the meta profile file.
     * @static
     * @type {string}
     * @memberof ProfileManager
     */
    static readonly PROFILE_EXTENSION: string;
    /**
     * The meta file suffix - always appended to the meta file to distinguish from other profiles. Users then cannot
     * supply a profile name that would conflict with the meta file.
     * @static
     * @type {string}
     * @memberof AbstractProfileManager
     */
    static readonly META_FILE_SUFFIX: string;
    /**
     * Load counter for this instance of the imperative profile manager. The load counter ensures that we are not
     * attempting to load circular dependencies by checking if a load (with dependencies) is attempting a load of
     * the same profile twice. The counts are reset when the loads complete, so state should be preserved correctly.
     * @private
     * @static
     * @type {Map<string, number>}
     * @memberof AbstractProfileManager
     */
    private mLoadCounter;
    /**
     * Parameters passed on the constructor (normally used to create additional instances of profile manager objects)
     * @private
     * @type {IProfileManager}
     * @memberof AbstractProfileManager
     */
    private mConstructorParms;
    /**
     * The profile root directory is normally supplied on an Imperative configuration document, but it is the
     * location where all profile type directories are stored.
     * @private
     * @type {string}
     * @memberof AbstractProfileManager
     */
    private mProfileRootDirectory;
    /**
     * The full set of profile type configurations. The manager needs to ensure that A) the profile type configuration
     * is among the set (because it contains schema and dependency specifications) and B) That other type configurations
     * are available to verify/load dependencies, etc.
     * @private
     * @type {T[]}
     * @memberof AbstractProfileManager
     */
    private mProfileTypeConfigurations;
    /**
     * The profile "type" for this manager - indicating the profile/schema that this manager is working directly with.
     * @private
     * @type {string}
     * @memberof AbstractProfileManager
     */
    private mProfileType;
    /**
     * The profile configuration document for the "type" defined to this manager. Contains the schema and dependency
     * specifications for the profile type.
     * @private
     * @type {T}
     * @memberof AbstractProfileManager
     */
    private mProfileTypeConfiguration;
    /**
     * The profile schema for the "type". The JSON schema is used to validate any profiles loaded or saved by this
     * profile manager for the type.
     * @private
     * @type {IProfileSchema}
     * @memberof AbstractProfileManager
     */
    private mProfileTypeSchema;
    /**
     * The root directory for the type (contained within the profile root directory).
     * @private
     * @type {string}
     * @memberof AbstractProfileManager
     */
    private mProfileTypeRootDirectory;
    /**
     * The meta file name for this profile type. Of the form "<type>_meta".
     * @private
     * @type {string}
     * @memberof AbstractProfileManager
     */
    private mProfileTypeMetaFileName;
    /**
     * Product display name of the CLI.
     * @private
     * @type {string}
     * @memberof AbstractProfileManager
     */
    private mProductDisplayName;
    /**
     * Logger instance - must be log4js compatible. Can be the Imperative logger (normally), but is required for
     * profile manager operation.
     * @private
     * @type {Logger}
     * @memberof AbstractProfileManager
     */
    private mLogger;
    /**
     * Creates an instance of ProfileManager - Performs basic parameter validation and will create the required
     * profile root directory (if it does not exist) and will attempt to load type configurations from the
     * existing profile root directory (unless the type definitions are passed on the constructor parameters).
     *
     * @param {IProfileManager} parms - See the interface for details.
     * @memberof ProfileManager
     */
    constructor(parms: IProfileManager<T>);
    /**
     * Accessor for the load counter (protects against circular loading)
     * @readonly
     * @protected
     * @type {Map<string, number>}
     * @memberof AbstractProfileManager
     */
    protected get loadCounter(): Map<string, number>;
    /**
     * Accessor for the logger instance - passed on the constructor
     * @readonly
     * @protected
     * @type {Logger}
     * @memberof AbstractProfileManager
     */
    protected get log(): Logger;
    /**
     * Accessor the input parameters to the constructor - used sometimes to create other instances of profile managers.
     * @readonly
     * @protected
     * @type {IProfileManager}
     * @memberof AbstractProfileManager
     */
    protected get managerParameters(): IProfileManager<T>;
    /**
     * Accessor for the profile type specified on the constructor.
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractProfileManager
     */
    protected get profileType(): string;
    /**
     * Accesor for the product display name.
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractProfileManager
     */
    protected get productDisplayName(): string;
    /**
     * Accessor for the profile type configuration for this manager.
     * @readonly
     * @protected
     * @type {T}
     * @memberof AbstractProfileManager
     */
    protected get profileTypeConfiguration(): T;
    /**
     * Accessor for the full set of type configurations - passed on the constructor or obtained from reading
     * the profile root directories and meta files.
     * @readonly
     * @protected
     * @type {T[]}
     * @memberof AbstractProfileManager
     */
    protected get profileTypeConfigurations(): T[];
    /**
     * Accessor for the schema of this type - JSON schema standard
     * @readonly
     * @protected
     * @type {IProfileSchema}
     * @memberof AbstractProfileManager
     */
    protected get profileTypeSchema(): IProfileSchema;
    /**
     * Accessor for the profile type root directory (contained within the profile root directory and named by the type itself)
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractProfileManager
     */
    protected get profileTypeRootDirectory(): string;
    /**
     * Accessor for the profile meta file name - constructed as "<type>_meta"
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractProfileManager
     */
    protected get profileTypeMetaFileName(): string;
    /**
     * Accessor for the profile root directory - supplied on the constructor - used to construct the profile type
     * directory.
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractProfileManager
     */
    protected get profileRootDirectory(): string;
    /**
     * Obtains all profile names for the profile "type" specified on the manager. The names are obtained from the
     * filesystem (in the profile type directory) and the meta file is NOT returned in the list.
     * @returns {string[]} - The list of profile names (obtained from disk).
     * @memberof AbstractProfileManager
     */
    getAllProfileNames(): string[];
    /**
     * Accessor that returns a copy of of the profile configuration document.
     * @readonly
     * @type {IProfileTypeConfiguration[]}
     * @memberof AbstractProfileManager
     */
    get configurations(): IProfileTypeConfiguration[];
    /**
     * Save a profile to disk. Ensures that the profile specified is valid (basic and schema validation) and invokes the implementations
     * "saveProfile" method to perform the save and formulate the response.
     * @template S
     * @param {ISaveProfile} parms - See interface for details
     * @returns {Promise<IProfileSaved>} - The promise that is fulfilled with the response object (see interface for details) or rejected
     * with an Imperative Error.
     * @memberof AbstractProfileManager
     */
    save<S extends ISaveProfile>(parms: S): Promise<IProfileSaved>;
    /**
     * Load a profile from disk. Ensures that the parameters are valid and loads the profile specified by name OR the default profile if
     * requested. If load default is requested, any name supplied is ignored.
     * @template L
     * @param {ILoadProfile} parms - See the interface for details.
     * @returns {Promise<IProfileLoaded>} - The promise that is fulfilled with the response object (see interface for details) or rejected
     * with an Imperative Error.
     * @memberof AbstractProfileManager
     */
    load<L extends ILoadProfile>(parms: L): Promise<IProfileLoaded>;
    /**
     * Validate a profile. Includes basic and schema validation. Can be called explicitly, but is also called during
     * loads and saves to protect the integrity of the profiles against the type definitions.
     * @template V
     * @param {IValidateProfile} parms - See the interface for details
     * @returns {Promise<IProfileValidated>} - The promise that is fulfilled with the response object (see interface for details) or rejected
     * with an Imperative Error.
     * @memberof AbstractProfileManager
     */
    validate<V extends IValidateProfile>(parms: V): Promise<IProfileValidated>;
    /**
     * Merge two profiles together. Useful when updating existing profiles with a few new
     * fields, for example.
     * @param {IProfile} oldProfile - the old profile, fields on this will have lower precedence
     * @param {IProfile} newProfile - the new profile, fields on this will have higher precedence
     * @returns {IProfile} - the merged profile
     */
    mergeProfiles(oldProfile: IProfile, newProfile: IProfile): IProfile;
    /**
     * Deletes a profile from disk. Ensures that the parameters are correct and removes the profile. If the profile is listed as a dependency of
     * other profiles it will NOT delete the profile unless "rejectIfDependency" is set to false.
     * @template D
     * @param {IDeleteProfile} parms - See the interface for details
     * @returns {Promise<IProfileDeleted>} - The promise that is fulfilled with the response object (see interface for details) or rejected
     * with an Imperative Error.
     * @memberof AbstractProfileManager
     */
    delete<D extends IDeleteProfile>(parms: D): Promise<IProfileDeleted>;
    /**
     * Update the profile - The action performed is dictacted by the implementation of the Abstract manager.
     * @template U
     * @param {IUpdateProfile} parms - See the interface for details
     * @returns {Promise<IProfileUpdated>} - The promise that is fulfilled with the response object (see interface for details) or rejected
     * with an Imperative Error.
     * @memberof AbstractProfileManager
     */
    update<U extends IUpdateProfile>(parms: U): Promise<IProfileUpdated>;
    /**
     * Sets the default profile for the profile managers type.
     * @param {string} name - The name of the new default
     * @returns {string} - The response string (or an error is thrown if the request cannot be completed);
     * @memberof AbstractProfileManager
     */
    setDefault(name: string): string;
    /**
     * Clears the default profile for the profile managers type.
     * @returns {string} - The response string (or an error is thrown if the request cannot be completed);
     * @memberof AbstractProfileManager
     */
    clearDefault(): string;
    /**
     * Returns the default profile name for this "type" or "undefined" if no default is set.
     * @returns {string} - The default profile name or undefined.
     * @memberof AbstractProfileManager
     */
    getDefaultProfileName(): string;
    /**
     * Load all profiles - the behavior is dictated by the implementation.
     * @abstract
     * @param {ILoadAllProfiles} [parms] - the load parameters - See interface for details
     * @returns {Promise<IProfileLoaded[]>} - The list of profiles when the promise is fulfilled or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    abstract loadAll(parms?: ILoadAllProfiles): Promise<IProfileLoaded[]>;
    /**
     * Save profile - performs the profile save according to the implementation - invoked when all parameters are valid
     * (according the abstract manager).
     * @protected
     * @abstract
     * @param {ISaveProfile} parms - See interface for details
     * @returns {Promise<IProfileSaved>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract saveProfile(parms: ISaveProfile): Promise<IProfileSaved>;
    /**
     * Save profile - performs the profile load according to the implementation - invoked when all parameters are valid
     * (according the abstract manager).
     * @protected
     * @abstract
     * @param {ILoadProfile} parms - See interface for details
     * @returns {Promise<IProfileLoaded>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract loadProfile(parms: ILoadProfile): Promise<IProfileLoaded>;
    /**
     * Delete profile - performs the profile delete according to the implementation - invoked when all parameters are valid
     * (according the abstract manager).
     * @protected
     * @abstract
     * @param {IDeleteProfile} parms - See interface for details
     * @returns {Promise<IProfileDeleted>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>;
    /**
     * Validate profile - performs the profile validation according to the implementation - invoked when all parameters are valid
     * (according the abstract manager).
     * @protected
     * @abstract
     * @param {IValidateProfileWithSchema} parms - See interface for details
     * @returns {Promise<IProfileValidated>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract validateProfile(parms: IValidateProfileWithSchema): Promise<IProfileValidated>;
    /**
     * Update profile - performs the profile update according to the implementation - invoked when all parameters are valid
     * (according the abstract manager).
     * @protected
     * @abstract
     * @param {IUpdateProfile} parms - See interface for details
     * @returns {Promise<IProfileUpdated>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract updateProfile(parms: IUpdateProfile): Promise<IProfileUpdated>;
    /**
     * Load a profiles dependencies - dictacted by the implementation.
     * @protected
     * @abstract
     * @param {string} name - the name of the profile to load dependencies for
     * @param {IProfile} profile - The profile to load dependencies for.
     * @param {boolean} failNotFound - True to fail "not found" errors
     * @returns {Promise<IProfileLoaded[]>} - The promise fulfilled with response or rejected with an ImperativeError.
     * @memberof AbstractProfileManager
     */
    protected abstract loadDependencies(name: string, profile: IProfile, failNotFound: boolean): Promise<IProfileLoaded[]>;
    /**
     * Invokes the profile IO method to delete the profile from disk.
     * @protected
     * @param {string} name - The name of the profile to delete.
     * @returns {string} - The path where the profile was.
     * @memberof AbstractProfileManager
     */
    protected deleteProfileFromDisk(name: string): string;
    /**
     * Performs basic validation of a profile object - ensures that all fields are present (if required).
     * @protected
     * @param name - the name of the profile to validate
     * @param type - the type of profile to validate
     * @param {IProfile} profile - The profile to validate.
     * @memberof AbstractProfileManager
     */
    protected validateProfileObject(name: string, type: string, profile: IProfile): void;
    /**
     * Validates the profile against the schema for its type and reports and errors located.
     * @protected
     * @param name - the name of the profile to validate
     * @param {IProfile} profile - The profile to validate.
     * @param {boolean} [strict=false] - Set to true to enable the "ban unknown properties" specification of the JSON schema spec. In other words,
     * prevents profiles with "unknown" or "not defined" proeprties according to the schema document.
     * @memberof AbstractProfileManager
     */
    protected validateProfileAgainstSchema(name: string, profile: IProfile, strict?: boolean): void;
    /**
     * Constructs the full path to the profile of the managers "type".
     * @protected
     * @param {string} name - The profile name to construct the path
     * @param {any} [type=this.profileType] - The type - normally the type specified in the manager.
     * @returns {string} - The full profile directory.
     * @memberof AbstractProfileManager
     */
    protected constructFullProfilePath(name: string, type?: string): string;
    /**
     * Locate the existing profile for the name specified.
     * @protected
     * @param {string} name - The profile to locate
     * @returns {string} - The fully qualified path or undefined if not found.
     * @memberof AbstractProfileManager
     */
    protected locateExistingProfile(name: string): string;
    /**
     * Standard load failed error message and Imperative Error.
     * @protected
     * @param {string} name - The name of the profile for which the load failed.
     * @memberof AbstractProfileManager
     */
    protected loadFailed(name: string): void;
    /**
     * Checks if the profile object passed is "empty" - meaning it has no contents other than that type or name.
     * A profile can only specify "dependencies", in the event that it is just acting as a "pointer" to another profile.
     * @protected
     * @param {IProfile} profile - The profile to check for "emptiness".
     * @returns {boolean} True if the profile object is empty.
     * @memberof AbstractProfileManager
     */
    protected isProfileEmpty(profile: IProfile): boolean;
    /**
     * Loads a specific profile (by name).
     * @protected
     * @param {string} name - The name of the profile to load.
     * @param {boolean} [failNotFound=true] - Specify false to ignore "not found" errors.
     * @param {boolean} [loadDependencies=true] - Specify false to NOT load dependencies.
     * @returns {Promise<IProfileLoaded>} - The promise to fulfill with the response OR reject with an ImperativeError
     * @memberof AbstractProfileManager
     */
    protected loadSpecificProfile(name: string, failNotFound?: boolean, loadDependencies?: boolean): Promise<IProfileLoaded>;
    /**
     * Validates a profiles contents against the required dependencies specified on the profile configuration type document. If the document
     * indicates that a dependency is required and that dependency is missing from the input profile, an error is thrown.
     * @private
     * @param {IProfile} profile - The profile to validate dependency specs
     * @memberof AbstractProfileManager
     */
    protected validateRequiredDependenciesAreSpecified(profile: IProfile): void;
    /**
     * Checks if the profile (by name) is listed as a dependency of any other profile passed. The type of the profiled named is
     * the type of the current manager object.
     * @private
     * @param {IProfileLoaded[]} profilesToSearch - The list of profiles to search for the dependency.
     * @param {string} name
     * @returns {IProfile[]}
     * @memberof AbstractProfileManager
     */
    private isDependencyOf;
    /**
     * Protects a against an overwrite on a profile save (if requested).
     * @private
     * @param {string} name - The name of the profile to check for existance.
     * @param {boolean} overwrite - False to protect against overwrite.
     * @memberof AbstractProfileManager
     */
    private protectAgainstOverwrite;
    /**
     * Builds the meta profile name for this type. Normally of the form "<type>_meta". This method does NOT include the extension
     * @private
     * @param {any} [type=this.profileType] - The profile type - defaults to this manager's type.
     * @returns {string}
     * @memberof AbstractProfileManager
     */
    private constructMetaName;
    /**
     * Create's the directory for this profile manager's type.
     * @private
     * @returns {string} - The directory created
     * @memberof AbstractProfileManager
     */
    private createProfileTypeDirectory;
    /**
     * Set the default profile name in the meta profile for this type.
     * @private
     * @param {IMetaProfile<T>} meta - The meta profile contents.
     * @param {string} defaultProfileName - The name to set as default.
     * @memberof AbstractProfileManager
     */
    private setDefaultInMetaObject;
    /**
     * Construct the default response for the situation when a profile is not found (on a load/save/update/etc), but ignore not found is true.
     * @private
     * @param {string} name - The name of the profile that was not found
     * @returns {IProfileLoaded} - The default response.
     * @memberof AbstractProfileManager
     */
    private failNotFoundDefaultResponse;
    /**
     * Reads all configuration documents from the meta and collects all type configuration documents.
     * @private
     * @returns {T[]}
     * @memberof AbstractProfileManager
     */
    private collectAllConfigurations;
    /**
     * Validate that the schema document passed is well formed for the profile manager usage. Ensures that the
     * schema is not overloading reserved properties.
     * @private
     * @param {IProfileSchema} schema - The schema document to validate.
     * @param type - the type of profile for the schema - defaults to the current type for this manager
     * @memberof AbstractProfileManager
     */
    private validateSchema;
    /**
     * Validates the basic configuration document to ensure it contains all the proper fields
     * @private
     * @param {T} typeConfiguration - The type configuration document
     * @memberof AbstractProfileManager
     */
    private validateConfigurationDocument;
    /**
     * Validate that a meta profile (one read from disk in particular) is valid.
     * @private
     * @param {IMetaProfile<T>} meta - The meta profile to validate
     * @param {string} [type=this.profileType] - The profile type of this meta file.
     * @memberof AbstractProfileManager
     */
    private validateMetaProfile;
    /**
     * Read the meta profile and validate the contents.
     * @private
     * @param {string} path - path to the meta profile
     * @param {string} [type=this.profileType] - The profile type
     * @returns {IMetaProfile<T>} - The meta profile read from disk.
     * @memberof AbstractProfileManager
     */
    private readMeta;
}
