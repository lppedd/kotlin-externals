package zowe.imperative.cmd.doc.profiles.parms

import kotlin.js.plain.JsPlainObject

/**
 * Command profile loader internal parameters.
 * Indicates the profile to be loaded (by name) and other options/control parameters.
 */
@JsPlainObject
external interface ICommandLoadProfile {
  /**
   * The type of the profile to load.
   */
  var type: String

  /**
   * The name of the profile to load for the type specified.
   */
  var name: String

  /**
   * Indicates that the user specifically named this profile to be loaded (not a default, etc.)
   */
  var userSpecified: Boolean

  /**
   * Load the default profile for the group. If this option is specified, name is ignored.
   */
  var loadDefault: Boolean

  /**
   * Indicates that a failure to load this profile is not a problem.
   */
  var optional: Boolean
}
