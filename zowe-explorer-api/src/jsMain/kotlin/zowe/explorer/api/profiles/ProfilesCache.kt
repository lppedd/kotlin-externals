@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.objects.Record
import js.promise.Promise
import node.Module
import vscode.JsInt
import vscode.JsString
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.profiles.CliProfileManager
import zowe.imperative.config.ProfileInfo
import zowe.imperative.config.doc.IProfAttrs
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.doc.response.IProfileLoaded

@JsString("_")
external val CONTEXT_PREFIX: String

@JsInt(443)
external val DEFAULT_PORT: Int

external class ProfilesCache {
  constructor(log: Logger, cwd: String = definedExternally)

  var log: Logger
  var cwd: String?
  var profilesForValidation: Array<IProfileValidation>
  var profilesValidationSetting: Array<IValidationSetting>
  var allProfiles: Array<IProfileLoaded>
  var profileTypeConfigurations: Array<ICommandProfileTypeConfiguration>
  var allTypes: Array<String>
  var allExternalTypes: Set<String>
  var profilesByType: Map<String, Array<IProfileLoaded>>
  var defaultProfileByType: Map<String, IProfileLoaded>
  var profileManagerByType: Map<String, CliProfileManager>

  fun addToConfigArray(extendermetadata: Array<ICommandProfileTypeConfiguration>)

  fun getConfigArray(): Array<ICommandProfileTypeConfiguration>

  fun getProfileInfo(_envTheia: Boolean = definedExternally): Promise<ProfileInfo>

  /**
   * Loads the named profile from allProfiles
   *
   * @param {string} name Name of Profile
   * @param {string} type Type of Profile, optional
   *
   * @return {IProfileLoaded}
   */
  fun loadNamedProfile(
    name: String,
    type: String = definedExternally,
  ): IProfileLoaded

  /**
   * Updates profile in allProfiles array and if default updates defaultProfileByType
   *
   * @param {string} profileLoaded
   *
   * @return {void}
   */
  fun updateProfilesArrays(profileLoaded: IProfileLoaded)

  /**
   * This returns default profile by type from defaultProfileByType
   *
   * @param {string} type Name of Profile, defaults to "zosmf" if nothing passed.
   *
   * @return {IProfileLoaded}
   */
  fun getDefaultProfile(type: String = definedExternally): IProfileLoaded

  /**
   * Gets default Profile attributes from imperative
   *
   * @param {ProfileInfo} mProfileInfo
   * @param {string} profileType Type of Profile
   *
   * @return {IProfAttrs}
   */
  fun getDefaultConfigProfile(
    mProfileInfo: ProfileInfo,
    profileType: String,
  ): IProfAttrs

  /**
   * Gets array of profiles by type
   *
   * @param {string} type Type of Profile, defaults to "zosmf" if nothing passed.
   *
   * @return {IProfileLoaded[]}
   */
  fun getProfiles(type: String = definedExternally): Array<IProfileLoaded>

  /**
   * Used for extenders to register with Zowe Explorer that do not need their
   * profile type in the existing MVS, USS, and JES
   *
   * @param {string} profileTypeName Type of Profile
   *
   * @return {void}
   */
  fun registerCustomProfilesType(profileTypeName: String)

  fun refresh(apiRegister: ZoweExplorerApi.IApiRegisterClient = definedExternally): Promise<Unit>

  fun validateAndParseUrl(newUrl: String): IUrlValidator

  /**
   * V1 Profile specific
   * gets schema from /.zowe/profiles/profileType directory
   * used by Zowe Explorer for creation & update of v1 profiles
   * TO DO: put in request for public readonly api for this on Imperative.
   * @param profileType
   */
  fun getSchema(profileType: String): Record<String, Any?>

  /**
   * get array of profile types
   * @return string[]
   */
  fun getAllTypes(): Array<String>

  /**
   * get array of Profile names by type
   * @param type  profile type
   * @return string[]
   */
  fun getNamesForType(type: String): Promise<Array<String>>

  /**
   * get array of IProfileLoaded by type
   * @param type profile type
   * @return IProfileLoaded[]
   */
  fun fetchAllProfilesByType(type: String): Promise<Array<IProfileLoaded>>

  /**
   * get array of IProfileLoaded for all profiles
   * @return IProfileLoaded[]
   */
  fun fetchAllProfiles(): Promise<Array<IProfileLoaded>>

  /**
   * Direct load and return of particular IProfileLoaded
   * @param type profile type
   * @param name profile name
   * @return IProfileLoaded
   */
  fun directLoad(
    type: String,
    name: String,
  ): Promise<IProfileLoaded?>

  fun getProfileFromConfig(
    profileName: String,
    profileType: String = definedExternally,
  ): Promise<IProfAttrs?>

  fun getLoadedProfConfig(
    profileName: String,
    profileType: String = definedExternally,
  ): Promise<IProfileLoaded?>

  /**
   * V1 Profile specific
   * Used by Zowe Explorer to handle v1 profiles
   * @param type string, profile type
   * @return zowe.imperative.CliProfileManager
   */
  fun getCliProfileManager(type: String): CliProfileManager?

  fun getBaseProfile(): IProfileLoaded?

  fun fetchBaseProfile(): Promise<IProfileLoaded?>

  /**
   * This returns true or false depending on if credentials are stored securely.
   *
   * @return {boolean}
   */
  fun isCredentialsSecured(): Promise<Boolean>

  /**
   * This returns true or false depending on if SCS plugin is installed. Use isCredentialsSecured().
   * @deprecated
   * @return {boolean}
   */
  fun isSecureCredentialPluginActive(): Boolean

  fun getProfileLoaded(
    profileName: String,
    profileType: String,
    profile: IProfile,
  ): IProfileLoaded

  fun deleteProfileOnDisk(profileInfo: IProfileLoaded): Promise<Unit>

  fun saveProfile(
    profileInfo: Record<String, Any?>,
    profileName: String,
    profileType: String,
  ): Promise<IProfile>

  fun checkMergingConfigAllProfiles()

  fun checkMergingConfigSingleProfile(profile: IProfileLoaded): IProfileLoaded

  fun getMergedAttrs(
    mProfileInfo: ProfileInfo,
    profAttrs: IProfAttrs,
  ): IProfile

  fun updateBaseProfileFileLogin(
    profile: IProfileLoaded,
    updProfile: IProfile,
    forceUpdate: Boolean = definedExternally,
  ): Promise<Unit>

  fun updateBaseProfileFileLogout(profile: IProfileLoaded): Promise<Unit>

  companion object {
    fun requireKeyring(/* this: void */): Module
  }
}
