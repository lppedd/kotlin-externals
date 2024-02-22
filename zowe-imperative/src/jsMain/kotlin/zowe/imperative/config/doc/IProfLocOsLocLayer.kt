package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Layer information for IProfLocOsLoc
 */
@JsPlainObject
external interface IProfLocOsLocLayer {
  /**
   * Determines if the osLoc is coming from a user layer
   */
  var user: Boolean

  /**
   * Determines if the osLoc is coming form a global layer
   */
  var global: Boolean
}
