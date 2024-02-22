package zowe.imperative.profiles.doc.response

import kotlin.js.plain.JsPlainObject

/**
 * The success response to the profile "validate()" APi.
 */
@JsPlainObject
external interface IProfileValidated {
  /**
   * Message - for display purposes - e.g. The profile was updated.
   */
  var message: String
}
