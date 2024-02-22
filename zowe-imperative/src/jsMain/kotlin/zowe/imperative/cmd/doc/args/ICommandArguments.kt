package zowe.imperative.cmd.doc.args

import kotlin.js.plain.JsPlainObject

/**
 * Imperative command arguments. Originally created by Yargs parse and
 * completed by Imperative. Passed to command handlers.
 *
 * The object contains two properties always present ($0 and _) and the rest of
 * the object will contain the option names, in both camel, kebab, and alias as
 * the keys with their values being plugged in by from CLI options, ENV vars,
 * profiles, or default values.
 */
@JsPlainObject
external interface ICommandArguments {
  /**
   * The "executable" - normally the main entry point of the node application.
   *
   * Example: "main.js"
   */
  var `$0`: String

  /**
   * The set of command segments and positional operands in an array.
   *
   * Example: ["create", "file", "text.txt"]
   */
  var `_`: Array<String>

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
