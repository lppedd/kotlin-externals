package zowe.imperative.cmd.doc.response.response

/**
 * The available format types for formatting of output.
 *
 * list
 * ====
 * Formats the output data as a list of strings. If an array of objects is present in the output,
 * each is stringified and printed on a newline.
 *
 * table
 * =====
 * Formats the output data as a table using the properties as the column headers. You must ensure
 * that the array of objects is homogeneous for the table to print properly.
 *
 * string
 * ======
 * Formats the output data as a string. If the output data is an object/array it is stringified.
 *
 * object
 * ======
 * Formats the output a prettified JSON object.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface OutputFormat {
  companion object {
    @seskar.js.JsValue("list")
    val list: OutputFormat

    @seskar.js.JsValue("table")
    val table: OutputFormat

    @seskar.js.JsValue("string")
    val string: OutputFormat

    @seskar.js.JsValue("object")
    val `object`: OutputFormat
  }
}
