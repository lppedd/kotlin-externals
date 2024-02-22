@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.doc.option

/**
 * The type of value that should be specified for an option by the user.
 * - "array": an array of space delimited strings
 * - "boolean": a switch - the user specifies:  true "--option-name" or false: "--option-name false"
 * - "count" : accepting only whole numbers as input value
 * - "existingLocalFile": a file for which fs.existsSync returns true
 * - "json": a parseable JSON string
 * - "number" : accepting integers as input value
 * - "string" : string input that does not allow "" as a valid input value
 * - "stringOrEmpty" : allow string to be empty when defined
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommandOptionType {
  companion object {
    @seskar.js.JsValue("array")
    val array: CommandOptionType

    @seskar.js.JsValue("boolean")
    val boolean: CommandOptionType

    @seskar.js.JsValue("count")
    val count: CommandOptionType

    @seskar.js.JsValue("existingLocalFile")
    val existingLocalFile: CommandOptionType

    @seskar.js.JsValue("json")
    val json: CommandOptionType

    @seskar.js.JsValue("number")
    val number: CommandOptionType

    @seskar.js.JsValue("string")
    val string: CommandOptionType

    @seskar.js.JsValue("stringOrEmpty")
    val stringOrEmpty: CommandOptionType
  }
}
