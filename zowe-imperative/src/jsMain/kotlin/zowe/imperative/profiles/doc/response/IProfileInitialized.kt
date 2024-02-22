package zowe.imperative.profiles.doc.response

import kotlin.js.plain.JsPlainObject

/**
 * Response to the Basic profile manager's initialize API - normally provided as an array to the
 * caller indicating each profile type that was initialized.
 */
@JsPlainObject
external interface IProfileInitialized {
  /**
   * The message indicating that the profile type was initialized or re-initialized.
   */
  var message: String
}
