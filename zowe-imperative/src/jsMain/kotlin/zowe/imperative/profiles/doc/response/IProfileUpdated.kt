package zowe.imperative.profiles.doc.response

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * The success response to the profile "update()" API.
 */
@JsPlainObject
external interface IProfileUpdated {
  /**
   * The path to the profile that was updated
   */
  var path: String

  /**
   * A message for display purposes
   */
  var message: String

  /**
   * The contents of the profile
   */
  var profile: IProfile?
}
