package zowe.imperative.cmd.doc.option

import js.array.JsTuple2
import kotlin.js.plain.JsPlainObject

/**
 * Positional option definition - used on a command definition to define positional operands.
 * Positional operands do not use --dashes. They are values specified after the full command string
 *  e.g.  group group group group command  mypositional --dash-option
 */
@JsPlainObject
external interface ICommandPositionalDefinition {
  /**
   * The name of the positional operand.
   *
   * This name cannot contain a dash (-) or else the positional argument will not function properly.
   * This is a limitation of yargs.
   *
   * Appending "..." to the end of a name will allow for a space delimited
   * array of arguments. So if you specify `name = "abcd..."` and then
   * "a b c d" is specified for the positional argument, abcd = ["a", "b", "c", "d"]
   */
  var name: String

  /**
   * The option type - used to validate that the user provided value is acceptable.
   */
  var type: CommandOptionType

  /**
   * The description for the positional operand - used in the help and error messages.
   */
  var description: String

  /**
   * True if this positional is required.
   */
  var required: Boolean?

  /**
   * A regex that will be used to match the input for this positional for validation.
   */
  var regex: String?

  /**
   * What is an acceptable length range for your positional? e.g. between 1 and 8 characters: [1,8]
   */
  var stringLengthRange: JsTuple2<Int, Int>?
}
