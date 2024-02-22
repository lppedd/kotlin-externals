@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.profiles

import js.promise.Promise
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.doc.profiles.parms.ICliLoadAllProfiles
import zowe.imperative.cmd.doc.profiles.parms.ICliLoadProfile
import zowe.imperative.profiles.BasicProfileManager
import zowe.imperative.profiles.doc.parms.IDeleteProfile
import zowe.imperative.profiles.doc.parms.ISaveProfileFromCliArgs
import zowe.imperative.profiles.doc.parms.IUpdateProfileFromCliArgs
import zowe.imperative.profiles.doc.parms.IValidateProfileForCLI
import zowe.imperative.profiles.doc.response.*

/**
 * A profile management API compatible with transforming command line arguments into profiles
 */
external class CliProfileManager : BasicProfileManager<ICommandProfileTypeConfiguration> {
  /**
   * NOTE: This is just a copy of BasicProfileManager.loadAll REASON: We needed the Abstract profile
   * manager to call the CLI profile manager to handle loading of secure properties Loads all
   * profiles from every type. Profile types are determined by reading all directories within the
   * profile root directory.
   *
   * @return The list of all profiles for every type
   */
  fun loadAll(params: ICliLoadAllProfiles = definedExternally): Promise<Array<IProfileLoaded>>

  /**
   * Overridden saveProfile functionality. If CLI args are provided, profile fields are built from
   * the args. Otherwise BaseProfileManager functionality is used.
   *
   * @param parms parameters for the save, potentially including CLI args
   * @return promise which fulfills with the save results
   */
  fun saveProfile(parms: ISaveProfileFromCliArgs): Promise<IProfileSaved>

  /**
   * Overridden updateProfile functionality If CLI args are provided, profile fields are built from
   * the arguments. Otherwise the BaseProfileManager update functionality is used
   *
   * @param parms parameters, potentially including CLI args
   * @return promise which contains the updated profile, path, and
   *   message when fulfilled
   */
  fun updateProfile(parms: IUpdateProfileFromCliArgs): Promise<IProfileUpdated>

  /**
   * Overridden loadProfile functionality After the BasicProfileManager loads the profile, we
   * process the secured properties for the CLi to use
   *
   * @param parms Load control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  fun loadProfile(parms: ICliLoadProfile): Promise<IProfileLoaded>

  /**
   * Overridden loadProfile functionality Before the BasicProfileManager deletes the profile, we
   * remove the secure properties associated with the profile
   *
   * @param parms Delete control params - see the interface for full details
   * @return Promise that is fulfilled when complete (or rejected with
   *   an Imperative Error)
   */
  override fun deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>

  /**
   * Validate a profile's structure, skipping the validation if we haven't built the profile's
   * fields from the CLI arguments yet.
   *
   * @param parms validate profile parameters. if these don't have
   *   readyForValidation = true, validation is skipped
   */
  fun validateProfile(parms: IValidateProfileForCLI): Promise<IProfileValidated>
}
