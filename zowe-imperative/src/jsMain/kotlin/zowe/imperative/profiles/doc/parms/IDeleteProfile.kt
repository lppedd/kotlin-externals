package zowe.imperative.profiles.doc.parms

import kotlin.js.plain.JsPlainObject

/**
 * Parameters to the profile manager "delete" API.
 */
@JsPlainObject
external interface IDeleteProfile {
  /**
   * The name of the profile to delete - the type is specified by the current manager object.
   */
  var name: String

  /**
   * If true, rejects the deletion of the profile if it is found to be a dependency of another
   * profile.
   */
  var rejectIfDependency: Boolean?
}
