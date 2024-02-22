package zowe.imperative.cmd.doc.option

import kotlin.js.plain.JsPlainObject

/**
 * Interface describing what values are allowable for a particular option.
 */
@JsPlainObject
external interface ICommandOptionAllowableValues {
  /**
   * Regular expressions for values that the user can specify for this option
   *
   * new RegExp(value).test(theValueSpecifiedByUser) will be called during syntax validation. If
   * none of the values match, the user will get a syntax error.
   */
  var values: Array<String>

  /**
   * Should these values be compared in a case sensitive manner?
   */
  var caseSensitive: Boolean?
}
