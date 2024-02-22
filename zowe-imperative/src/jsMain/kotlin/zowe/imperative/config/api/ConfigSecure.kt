@file:JsModule("@zowe/imperative")

package zowe.imperative.config.api

import js.promise.Promise
import zowe.imperative.config.doc.IConfigVault

/**
 * API Class for manipulating config layers.
 */
external class ConfigSecure : ConfigApi {
  /**
   * Load the secure application properties from secure storage using the specified vault interface.
   * The vault interface is placed into our Config object. The secure values are placed into our
   * Config layers.
   *
   * @param vault Interface for loading and saving to secure storage.
   */
  fun load(vault: IConfigVault = definedExternally): Promise<Unit>

  /**
   * Save the secure application properties into secure storage using the vault interface from our
   * config object.
   *
   * @param allLayers Specify true to save all config layers instead of only the active one
   */
  fun save(allLayers: Boolean = definedExternally): Promise<Unit>

  /**
   * List full paths of all secure properties found in a team config file.
   *
   * @param opts The user and global flags that specify one of the four config files (aka layers).
   * @return Array of secure property paths (e.g., "profiles.lpar1.properties.password")
   */
  fun secureFields(opts: ConfigSecureSecureFieldsOpts = definedExternally): Array<String>

  /**
   * List names of secure properties for a profile. They may be defined at the profile's level, or
   * at a higher level if the config is nested.
   *
   * @param profileName Profile name to search for
   * @return Array of secure property names
   */
  fun securePropsForProfile(profileName: String): Array<String>

  /**
   * Delete secure properties stored for team config files that do not exist.
   *
   * @return Array of file paths for which properties were deleted
   */
  fun rmUnusedProps(): Array<String>

  /**
   * Return true if the secure load method was called and threw an error, or it was never called
   * because the CredentialManager failed to initialize.
   */
  val loadFailed: Boolean
}
