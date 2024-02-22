package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * The identifying attributes of a profile.
 */
@JsPlainObject
external interface IProfAttrs {
  /**
   * The name of the profile
   */
  var profName: String

  /**
   * The profile type (eg. "zosmf")
   */
  var profType: String

  /**
   * Indicates if this is the default profile for this type
   */
  var isDefaultProfile: Boolean

  /**
   * Location of this profile. profNmLoc.ProfLocType can never be ProfLocType.ENV or
   * ProfLocType.DEFAULT, because this is the location of a profile, not an argument value.
   */
  var profLoc: IProfLoc
}
