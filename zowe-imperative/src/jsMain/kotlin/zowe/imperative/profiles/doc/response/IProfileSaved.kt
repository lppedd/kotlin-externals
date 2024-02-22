package zowe.imperative.profiles.doc.response

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * The success response to the profile "save()" API.
 */
@JsPlainObject
external interface IProfileSaved {
  /**
   * The path that the new profile was written to
   */
  var path: String

  /**
   * A message describing the result of the profile creation - for display purposes
   */
  var message: String

  /**
   * True if the profile saved overwrote an existing profile of the same name/type.
   */
  var overwritten: Boolean

  /**
   * The contents of the profile saved.
   */
  var profile: IProfile?
}
