package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * The attributes of a profile argument.
 */
@JsPlainObject
external interface IProfArgAttrs {
  /**
   * The name of the argument
   */
  var argName: String

  /**
   * The type of data for this property
   */
  var dataType: IProfDataType

  /**
   * The value for the argument
   */
  var argValue: IProfArgValue

  /**
   * The location of this argument
   */
  var argLoc: IProfLoc

  /**
   * Whether the argument value is stored securely
   */
  var secure: Boolean?

  /**
   * Whether the argument value is defined in the schema file
   */
  var inSchema: Boolean?
}
