package zowe.imperative.profiles.doc.parms

import kotlin.js.plain.JsPlainObject

/**
 * Parameters for the setDefault Profile Manager API.
 */
@JsPlainObject
external interface ISetDefaultProfile {
  /**
   * The name of the profile to set as the default (the type is indicated by the profile manager object).
   */
  var name: String
}
