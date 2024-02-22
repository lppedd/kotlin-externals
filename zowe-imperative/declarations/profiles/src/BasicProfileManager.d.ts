import { AbstractProfileManager } from "./abstract/AbstractProfileManager";
import { IDeleteProfile, ILoadProfile, IProfile, IProfileDeleted, IProfileInitialized, IProfileLoaded, IProfileManagerInit, IProfileSaved, IProfileTypeConfiguration, IProfileUpdated, IProfileValidated, ISaveProfile, IUpdateProfile, IValidateProfileWithSchema } from "./doc";
/**
 * Basic Profile Manager is the most basic implementation of the Imperative Profile Manager. In general, it invokes
 * all of the utility/services from the Abstract Profile manager to load, save, delete, validate, etc. Imperative
 * profiles. See the "AbstractProfileManager" header for more profile management details.
 *
 * The main differences between the abstract and the basic include:
 *
 * 1) The "loadAll()" API in the basic profile manager loads ALL profiles from all types.
 * 2) The Basic Profile Manager includes the "initialize()" API, which will create all type directories and persist
 *    the schema in the meta files.
 *
 * The Basic Profile Manager can be used "stand-alone" from an Imperative CLI. The intent is to provide apps built
 * using Imperative CLI's to take advantage of the profiles that the user has defined, without having to "locate" the
 * configuration documents used to construct the CLI's. This is why the initialize() API persists the configuration
 * documents within the meta files for each type.
 *
 * @export
 * @class BasicProfileManager
 * @extends {AbstractProfileManager<T>}
 * @template T
 */
export declare class BasicProfileManager<T extends IProfileTypeConfiguration> extends AbstractProfileManager<T> {
    /**
     * Static method to initialize the profile environment. Accepts the profile root directory (normally supplied by
     * your Imperative configuration documents) and all profile "type" configuration documents and constructs the directories
     * needed to manage profiles of all types. You must execute this method before beginning to use profiles OR you must
     * supply all the type configuration documents (normally obtained from your Imperative configuration document) to
     * the constructor of
     * @static
     * @param {IProfileManagerInit} parms
     * @returns {Promise<IProfileInitialized[]>}
     * @memberof AbstractProfileManager
     */
    static initialize(parms: IProfileManagerInit): Promise<IProfileInitialized[]>;
    /**
     * Loads all profiles from every type. Profile types are deteremined by reading all directories within the
     * profile root directory.
     * @returns {Promise<IProfileLoaded[]>} - The list of all profiles for every type
     * @memberof BasicProfileManager
     */
    loadAll(): Promise<IProfileLoaded[]>;
    /**
     * Loads all dependencies for the profile specified - returns the list in the response structure. Sub-dependencies
     * are also loaded.
     * @protected
     * @param {string} name - the name of hte profile to load dependencies for
     * @param {IProfile} profile - The profile to load dependencies.
     * @param {boolean} [failNotFound=true] - Indicates that you want to avoid failing the request for "not found" errors.
     * @returns {Promise<IProfileLoaded[]>} - The list of profiles loaded with all dependencies.
     * @memberof BasicProfileManager
     */
    protected loadDependencies(name: string, profile: IProfile, failNotFound?: boolean): Promise<IProfileLoaded[]>;
    /**
     * Save the profile to disk. First ensures that all dependencies are valid and writes the profile.
     * @protected
     * @param {ISaveProfile} parms - Save control params - see the interface for full details
     * @returns {Promise<IProfileSaved>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     * @memberof BasicProfileManager
     */
    protected saveProfile(parms: ISaveProfile): Promise<IProfileSaved>;
    /**
     * Load a profile from disk - invokes the "loadSpecificProfile" method in the abstract to perform the load.
     * @protected
     * @param {ILoadProfile} parms - Load control params - see the interface for full details
     * @returns {Promise<IProfileSaved>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     * @memberof BasicProfileManager
     */
    protected loadProfile(parms: ILoadProfile): Promise<IProfileLoaded>;
    /**
     * Delete a profile from disk - invokes the "deleteProfileFromDisk" method in the abstract to perform the load.
     * @protected
     * @param {IDeleteProfile} parms - Delete control params - see the interface for full details
     * @returns {Promise<IProfileDeleted>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     * @memberof BasicProfileManager
     */
    protected deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>;
    /**
     * Validate profile - ensures that the profile is valid agaisnt the schema and configuration document
     * @protected
     * @param {IValidateProfileWithSchema} parms - Validate control params - see the interface for full details
     * @returns {Promise<IProfileValidated>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     * @memberof BasicProfileManager
     */
    protected validateProfile(parms: IValidateProfileWithSchema): Promise<IProfileValidated>;
    /**
     * Update a profile - Accepts the "new" version of the profile and overwrites the existing profile on disk.
     * @protected
     * @param {IUpdateProfile} parms - Update control params - see the interface for full details
     * @returns {Promise<IProfileUpdated>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     * @memberof BasicProfileManager
     */
    protected updateProfile(parms: IUpdateProfile): Promise<IProfileUpdated>;
}
