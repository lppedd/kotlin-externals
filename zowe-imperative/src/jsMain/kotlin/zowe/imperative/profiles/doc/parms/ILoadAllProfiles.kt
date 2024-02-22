package zowe.imperative.profiles.doc.parms

import kotlin.js.plain.JsPlainObject

/**
 * Optional parameters to profile manager load all profiles
 */
@JsPlainObject
external interface ILoadAllProfiles {
  /**
   * If true, do not load secure fields
   */
  var noSecure: Boolean?

  /**
   * If true, loads only the profiles of the current instance of the profile managers "type" -
   * specified when allocating the profile manager.
   */
  var typeOnly: Boolean?
}
