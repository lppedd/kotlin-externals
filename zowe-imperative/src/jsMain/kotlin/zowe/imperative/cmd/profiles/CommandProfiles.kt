@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.profiles

import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.doc.response.IProfileLoaded

/**
 * Profiles map created by the command profile loader and passed to the handler via parameters.
 * Handlers can retreive loaded profiles from the map via the profile type.
 */
external class CommandProfiles {
  /**
   * Creates an instance of CommandProfiles.
   *
   * @param map The map of profiles
   */
  constructor(
    map: Map<String, Array<IProfile>>,
    metaMap: Map<String, Array<IProfileLoaded>> = definedExternally,
  )

  /**
   * Gets the first (or by name) meta profile in the map - automatically throws an exception (unless
   * disabled)
   *
   * @param type The profile type
   * @param name The name of the profile to retrieve. Default: ""
   * @param failNotFound Automatically throws an imperative exception if not
   *   profiles are not found - this is provided as convince for the handlers (will fail your
   *   command if not found) - This would normally be the result of a command configuration problem.
   *   Default: true
   * @return The first profile in the map (or the one located by name)
   */
  @Deprecated("")
  fun <T : IProfileLoaded> getMeta(
    type: String,
    failNotFound: Boolean = definedExternally,
    name: String = definedExternally,
  ): T

  /**
   * Gets the first (or by name) profile in the map - automatically throws an exception (unless
   * disabled)
   *
   * @param type The profile type
   * @param name The name of the profile to retrieve. Default: ""
   * @param failNotFound Automatically throws an imperative exception if not
   *   profiles are not found - this is provided as convince for the handlers (will fail your
   *   command if not found) - This would normally be the result of a command configuration problem.
   *   Default: true
   * @return The first profile in the map (or the one located by name)
   */
  @Deprecated("Load profile properties from IHandlerParameters.arguments property instead")
  fun <T : IProfile> get(
    type: String,
    failNotFound: Boolean = definedExternally,
    name: String = definedExternally,
  ): T

  /**
   * Gets all profiles for the type specified,
   *
   * @param type The profile type to retrieve loaded profiles
   * @param failNotFound Automatically throws an imperative exception if not
   *   profiles are not found - this is provided as convince for the handlers (will fail your
   *   command if not found) - This would normally be the result of a command configuration problem.
   *   Default: true
   * @return The list of profile types
   */
  @Deprecated("")
  fun <T : IProfile> getAll(
    type: String,
    failNotFound: Boolean = definedExternally,
  ): Array<T>
}
