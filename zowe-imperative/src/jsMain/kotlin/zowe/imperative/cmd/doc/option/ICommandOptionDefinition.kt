package zowe.imperative.cmd.doc.option

import js.array.JsTuple2
import js.objects.Record
import kotlin.js.plain.JsPlainObject

/**
 * Used on a command definition to define option flags.
 */
@JsPlainObject
external interface ICommandOptionDefinition {
  /**
   * The canonical/primary name for your option.
   * This is the first form of the option shown to the user and is
   * generally how you should refer to your option in documentation and programmatically.
   *
   * Note: yargs automatically places the values for --hyphenated-options in a camelCase format
   * after parsing the command line arguments, so you would be able to access params.arguments.hyphenatedOptions
   * from your handler as well as params.arguments["hyphenated-options"]'
   */
  var name: String

  /**
   * Aliases for your option. These allow the user to specify
   * the option with a shorter or otherwise alternate name
   * e.g.  name: "puppy", aliases: ["p", "pup"] -
   *       the user can specify --puppy, -p, or --pup
   */
  var aliases: Array<String>?

  /**
   * The description of your option - displayed in the help text
   * for your command.
   */
  var description: String

  /**
   * What type of value will the user specify for this option?
   */
  var type: CommandOptionType

  /**
   * Option is hidden from help
   */
  var hidden: Boolean?

  /**
   * If the user doesn't specify this option, you can specify a default value here
   * that will be filled in automatically.
   */
  var defaultValue: Any?

  /**
   * The group/category for this option.
   * Options with the same group on the same command are grouped together
   * under a heading with this text.
   */
  var group: String?

  /**
   * Is this option required? If it's required and the user
   * does not specify it, they will get a syntax error.
   *
   * Note: if you give a defaultValue to an option, it will always be
   * considered to have been specified.
   */
  var required: Boolean?

  /**
   * Defines which options this one conflicts with.
   *
   * Example:
   *
   * **A and B can't be specified together**
   * ```
   * const def: ICommandOptionDefinition =
   * {
   *   name: "B",
   *   description
   *   conflictsWith: ["A"]
   * }
   * ```
   */
  var conflictsWith: Array<String>?

  /**
   * If this option is specified, all options whose name appear in the "implies"
   * field must also be specified.
   * e.g. if this option is "vacation", and ["seat", "meal"] is the value for "implies",
   * then the user will get a syntax error if they specify --vacation but not --seat and --meal
   */
  var implies: Array<String>?

  /**
   * If this option is specified, at least one of the options whose name appear in the "impliesOneOf"
   * field must also be specified.
   * e.g. if this option is "vacation", and ["seat", "meal"] is the value for "impliesOneOf",
   * then the user will get a syntax error if they specify --vacation but not either --seat or --meal
   */
  var impliesOneOf: Array<String>?

  /**
   * Not specifying these options implies that you should specify
   * all options listed in "absenceImplications".
   *
   * e.g. if the user does not specify "vacation" then they must specify --job and --hours
   */
  var absenceImplications: Array<String>?

  /**
   * What values can be specified for this option?
   * See the type below for more details.
   */
  var allowableValues: ICommandOptionAllowableValues?

  /**
   * Acceptable value range for number type options.
   * the first number is the minimum. the second is the maximum
   * So the value specified by the user must be  min <=  value <= max
   */
  var numericValueRange: JsTuple2<Number, Number>?

  /**
   * Acceptable length range for string type options.
   * the first number is the minimum. the second is the maximum
   * So the length specified by the user must be  min <=  length <= max
   */
  var stringLengthRange: JsTuple2<Number, Number>?

  /**
   * If the type is array, this option defines if duplicate values in array
   * are allowed. Default is true.
   */
  var arrayAllowDuplicate: Boolean?

  /**
   * If the user specifies a certain value for this option,
   * then they must also specify other options (similar to a conditional "implies")
   */
  var valueImplications: Record<String, ICommandOptionValueImplications>?
}
