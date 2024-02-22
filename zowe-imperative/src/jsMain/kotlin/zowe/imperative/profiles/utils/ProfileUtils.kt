@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.utils

import js.array.JsTuple2
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import zowe.imperative.profiles.doc.response.IProfileLoaded

/**
 * Set of static utility methods to assist with creating profile option names from profile types, constructing the
 * root directory, reforming responses for different purposes, etc.
 */
external class ProfileUtils {
  companion object {
    /**
     * Construct the profiles root directory, given the "home" directory.
     *
     * @param home The home directory - normally supplied by Imperative.
     * @return The profiles root directory
     */
    fun constructProfilesRootDirectory(home: String): String

    /**
     * Accepts an array of responses, which, depending on the depedencies, may have nested depedency arrays, and
     * flattens to a single level (for ease of printing, etc.).
     *
     * @param dependencyResponses The list of load responses
     * @return The list of load responses flattened to a single level
     */
    fun flattenDependencies(dependencyResponses: Array<IProfileLoaded>): Array<IProfileLoaded>

    /**
     * Accepts the profile configuration document and returns an array of all types.
     *
     * @param profileConfigs All profile type configuration documents.
     * @return An array of profile types.
     */
    fun getAllTypeNames(profileConfigs: Array<IProfileTypeConfiguration>): Array<String>

    /**
     * Construct the profile option - e.g banana-profile - Used to append to commands automatically
     * and by the command processor to check if profile options are present.
     *
     * @param type The module name (e.g. banana)
     * @return The full option name
     */
    fun getProfileOption(type: String): String

    /**
     * Construct the profile option alias - e.g banana-p- Used to append to commands automatically
     * and by the command processor to check if profile options are present.
     *
     * @param type The module name (e.g. banana)
     * @return The alias for the profile option
     */
    fun getProfileOptionAlias(type: String): String

    /**
     * Returns the standard profile option name like "banana-profile" and its alias
     *
     * @param type The type of the profile
     * @return The option and its alias
     */
    fun getProfileOptionAndAlias(type: String): JsTuple2<String, String>

    /**
     * Create a mapKey value to identify a profile
     *
     * @param type Type of the profile
     * @param name Name of the profile
     * @return Key identifying the profile
     */
    fun getProfileMapKey(
      type: String,
      name: String,
    ): String

    /**
     * Create a key value to identify a property on a profile
     *
     * @param type Type of the profile
     * @param name Name of the profile
     * @param name Name of the profile
     * @return Key identifying the profile
     */
    fun getProfilePropertyKey(
      type: String,
      name: String,
      field: String,
    ): String
  }
}
