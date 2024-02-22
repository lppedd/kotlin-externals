@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles

import js.promise.Promise
import zowe.imperative.profiles.abstract.AbstractProfileManager
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.doc.parms.*
import zowe.imperative.profiles.doc.response.*

/**
 * Basic Profile Manager is the most basic implementation of the Imperative Profile Manager. In
 * general, it invokes all of the utility/services from the Abstract Profile manager to load, save,
 * delete, validate, etc. Imperative profiles. See the "AbstractProfileManager" header for more
 * profile management details.
 *
 * The main differences between the abstract and the basic include:
 * 1) The "loadAll()" API in the basic profile manager loads ALL profiles from all types.
 * 2) The Basic Profile Manager includes the "initialize()" API, which will create all type
 *    directories and persist the schema in the meta files.
 *
 * The Basic Profile Manager can be used "stand-alone" from an Imperative CLI. The intent is to
 * provide apps built using Imperative CLI's to take advantage of the profiles that the user has
 * defined, without having to "locate" the configuration documents used to construct the CLI's. This
 * is why the initialize() API persists the configuration documents within the meta files for each
 * type.
 */
open external class BasicProfileManager<T : IProfileTypeConfiguration> : AbstractProfileManager<T> {
  /**
   * Loads all profiles from every type. Profile types are deteremined by reading all directories
   * within the profile root directory.
   *
   * @return The list of all profiles for every type
   */
  fun loadAll(): Promise<Array<IProfileLoaded>>

  /**
   * Loads all dependencies for the profile specified - returns the list in the response structure.
   * Sub-dependencies are also loaded.
   *
   * @param name the name of hte profile to load dependencies for
   * @param profile The profile to load dependencies.
   * @param failNotFound Indicates that you want to avoid failing the request for
   *   "not found" errors.
   * @return The list of profiles loaded with all dependencies.
   */
  override fun loadDependencies(
    name: String,
    profile: IProfile,
    failNotFound: Boolean,
  ): Promise<Array<IProfileLoaded>>

  /**
   * Loads all dependencies for the profile specified - returns the list in the response structure.
   * Sub-dependencies are also loaded.
   *
   * @param name the name of hte profile to load dependencies for
   * @param profile The profile to load dependencies.
   * @return The list of profiles loaded with all dependencies.
   */
  // Note(Edoardo): artificial overload
  fun loadDependencies(
    name: String,
    profile: IProfile,
  ): Promise<Array<IProfileLoaded>>

  /**
   * Save the profile to disk. First ensures that all dependencies are valid and writes the profile.
   *
   * @param parms Save control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  override fun saveProfile(parms: ISaveProfile): Promise<IProfileSaved>

  /**
   * Load a profile from disk - invokes the "loadSpecificProfile" method in the abstract to perform
   * the load.
   *
   * @param parms Load control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  override fun loadProfile(parms: ILoadProfile): Promise<IProfileLoaded>

  /**
   * Delete a profile from disk - invokes the "deleteProfileFromDisk" method in the abstract to
   * perform the load.
   *
   * @param parms Delete control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  override fun deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>

  /**
   * Validate profile - ensures that the profile is valid agaisnt the schema and configuration
   * document
   *
   * @param parms Validate control params - see the interface for
   *   full details
   * @return Promise that is fulfilled when complete (or rejected
   *   with an Imperative Error)
   */
  override fun validateProfile(parms: IValidateProfileWithSchema): Promise<IProfileValidated>

  /**
   * Update a profile - Accepts the "new" version of the profile and overwrites the existing profile
   * on disk.
   *
   * @param parms Update control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  override fun updateProfile(parms: IUpdateProfile): Promise<IProfileUpdated>

  companion object {
    /**
     * Static method to initialize the profile environment. Accepts the profile root directory
     * (normally supplied by your Imperative configuration documents) and all profile "type"
     * configuration documents and constructs the directories needed to manage profiles of all
     * types. You must execute this method before beginning to use profiles OR you must supply all
     * the type configuration documents (normally obtained from your Imperative configuration
     * document) to the constructor of
     */
    fun initialize(parms: IProfileManagerInit): Promise<Array<IProfileInitialized>>
  }
}
