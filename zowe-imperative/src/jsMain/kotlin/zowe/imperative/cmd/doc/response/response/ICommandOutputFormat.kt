package zowe.imperative.cmd.doc.response.response

import kotlin.js.plain.JsPlainObject

/**
 * The output format object is returned from a successful command handler to dictate how the output
 * for the command should be formatted. This is an optional feature for Imperative and handlers are
 * not required to return this object (they can format their own output).
 *
 * These properties represent the defaults for the handler. If the command definition includes the
 * output format options, the options take precedence over the default values (see
 * ICommandDefinition for details).
 */
@JsPlainObject
external interface ICommandOutputFormat {
  /**
   * The output data to format. Common output data includes arrays of strings/objects, JSON objects,
   * strings.
   */
  var output: Any?

  /**
   * The output format type (see the type for details). In most cases, any data type returned (on
   * the output property) can be formatted according to the type specified here.
   */
  var format: OutputFormat

  /**
   * If the response is an object (or an array of objects) these are the top level properties to
   * keep. For example, if an array of homogeneous objects are returned in the output, the fields
   * that are NOT specified in this array are removed/deleted from each object.
   */
  var fields: Array<String>?

  /**
   * If response format table is specified, print the table headings
   */
  var header: Boolean?
}
