package zowe.imperative.profiles.doc.response

import kotlin.js.plain.JsPlainObject

/**
 * The success response to the profile "delete()" API.
 */
@JsPlainObject
external interface IProfileDeleted {
  /**
   * The path to the profile that was deleted.
   */
  var path: String

  /**
   * The message - for display purposes - e.g. The profile was successfully deleted.
   */
  var message: String

  /**
   * Specifies whether the default profile was cleared.
   */
  var defaultCleared: Boolean?
}
