package zowe.imperative.profiles.doc.parms

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * Parameters to the "save()" profile API.
 *
 * Note: This profile could contain the following additional arguments, which will only be kept in
 * memory (for a short period of time) and NOT saved to a file.
 */
@JsPlainObject
external interface ISaveProfile {
  /**
   * The profile contents - must extend the IProfile interface to function properly with Imperative.
   * The contents are always validated against the schema documents (and basic validation occurs)
   */
  var profile: IProfile

  /**
   * The name of the profile to save
   */
  var name: String

  /**
   * The type of profile to save
   */
  var type: String

  /**
   * Set to true to update the default profile for the profile type.
   */
  var updateDefault: Boolean?

  /**
   * Set to true to overwrite an existing profile of the same name. If false, an error is thrown if
   * the profile already exists.
   */
  var overwrite: Boolean?

  /**
   * The argument to disable populating defaults
   */
  var disableDefaults: Boolean?
}
