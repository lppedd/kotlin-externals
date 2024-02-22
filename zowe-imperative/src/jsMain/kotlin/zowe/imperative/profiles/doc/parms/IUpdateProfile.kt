package zowe.imperative.profiles.doc.parms

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * Parameters to update a profile - The basic implementation simply overwrites the existing profile
 * with the new contents specified, unless merge is true, and the contents of the old profile are
 * merged with the contents from the update profile.
 *
 * Note: This profile could contains the following additional arguments, which will only be kept in
 * memory (for a short period of time) and NOT saved to a file.
 */
@JsPlainObject
external interface IUpdateProfile {
  /**
   * The name of the profile to update.
   */
  var name: String?

  /**
   * Should the contents of the new profile be merged with the contents of the old one?
   */
  var merge: Boolean?

  /**
   * The contents of the profile for the update - if merge is NOT specified, simply overwrites the
   * existing profile with the contents specified here.
   */
  var profile: IProfile?
}
