package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * The extended osLoc information
 */
@JsPlainObject
external interface IProfLocOsLoc : IProfLocOsLocLayer {
  /**
   * The name of the profile
   */
  var name: String

  /**
   * Contains the osLoc path information
   */
  var path: String
}
