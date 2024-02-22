@file:JsModule("@zowe/imperative")

package zowe.imperative.config.api

import js.objects.Record
import zowe.imperative.config.doc.IConfigProfile

/**
 * API Class for manipulating config profiles.
 */
external class ConfigProfiles : ConfigApi {
  /**
   * Set a profile object at the location identified by the path within the currently active layer.
   *
   * @param path The dotted path of the location in which to set the profile.
   * @param profile The JSON profile object to set into the specified location,
   */
  fun set(
    path: String,
    profile: IConfigProfile,
  )

  /**
   * Get the profile object located at the specified location.
   *
   * @param path The dotted path of the location at which to set the profile.
   * @param mustExist If false, outer layer profile values will still be returned when the dotted
   *   path does not exist. Default is true.
   */
  fun get(
    path: String,
    mustExist: Boolean = definedExternally,
  ): Record<String, String>

  /**
   * Reports whether or not a profile exists at the specified location.
   *
   * @param path The dotted path of desired location.
   * @return True if a profile exists. False otherwise.
   */
  fun exists(path: String): Boolean

  /**
   * Set the default value for the specified type of profile within the currently active layer.
   *
   * @param profileType The name of the desired type of profile (like zosmf).
   * @param value The dotted node path to the profile (like ca32.zosmf).
   */
  fun defaultSet(
    profileType: String,
    value: String,
  )

  /**
   * Get the profile contents for the default profile of the specified type of profile within the
   * currently active layer.
   *
   * @param profileType The name of the desired type of profile (like zosmf).
   * @return An object containing the desired profile, for example {"host": "lpar.your.domain.net", port: 1234}
   */
  fun defaultGet(profileType: String): Record<String, String>

  /**
   * Expands a short path into an expanded path.
   *
   * @param shortPath The short path.
   * @return The expanded path.
   */
  @Deprecated("Please use getProfilePathFromName")
  fun expandPath(shortPath: String): String

  /**
   * Expands a short path into an expanded path.
   *
   * @param shortPath The short path.
   * @return The expanded path.
   */
  fun getProfilePathFromName(shortPath: String): String

  /**
   * Obtain the profile name (either nested or not) based on a property path.
   *
   * Note: This may be useful for supporting token authentication in a nested configuration
   *
   * @param path The property path.
   * @return The corresponding profile name.
   */
  fun getProfileNameFromPath(path: String): String

  /**
   * Build the set of properties contained within a set of nested profiles.
   *
   * @param path The dotted path of desired location.
   * @param profiles A set of nested profile objects.
   * @return The desired profile object. An empty object if profiles is empty.
   */
  fun buildProfile(
    path: String,
    profiles: Record<String, IConfigProfile>,
  ): Record<String, String>
}
