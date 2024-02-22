@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import js.promise.Promise
import zowe.imperative.*
import zowe.imperative.cmd.*
import zowe.imperative.cmd.builders.*
import zowe.imperative.cmd.constants.*
import zowe.imperative.cmd.doc.*
import zowe.imperative.cmd.doc.args.*
import zowe.imperative.cmd.doc.handler.*
import zowe.imperative.cmd.doc.option.*
import zowe.imperative.cmd.doc.parms.*
import zowe.imperative.cmd.doc.processor.*
import zowe.imperative.cmd.doc.profiles.*
import zowe.imperative.cmd.doc.profiles.definition.*
import zowe.imperative.cmd.doc.response.*
import zowe.imperative.cmd.doc.response.api.handler.IPromptOptions
import zowe.imperative.cmd.doc.response.response.*
import zowe.imperative.cmd.handlers.*
import zowe.imperative.cmd.help.*
import zowe.imperative.cmd.help.abstract.*
import zowe.imperative.cmd.help.doc.*
import zowe.imperative.cmd.profiles.*
import zowe.imperative.cmd.response.*
import zowe.imperative.cmd.syntax.*
import zowe.imperative.cmd.types.*
import zowe.imperative.cmd.utils.*
import zowe.imperative.cmd.yargs.*
import zowe.imperative.cmd.yargs.doc.*
import zowe.imperative.config.*
import zowe.imperative.config.api.*
import zowe.imperative.config.doc.*
import zowe.imperative.console.*
import zowe.imperative.console.doc.*
import zowe.imperative.constants.*
import zowe.imperative.error.*
import zowe.imperative.error.doc.*
import zowe.imperative.expect.*
import zowe.imperative.imperative.*
import zowe.imperative.imperative.api.*
import zowe.imperative.imperative.api.doc.*
import zowe.imperative.imperative.auth.builders.*
import zowe.imperative.imperative.auth.doc.*
import zowe.imperative.imperative.auth.handlers.*
import zowe.imperative.imperative.config.*
import zowe.imperative.imperative.doc.*
import zowe.imperative.imperative.env.*
import zowe.imperative.imperative.handlers.*
import zowe.imperative.imperative.help.*
import zowe.imperative.imperative.plugins.*
import zowe.imperative.imperative.plugins.cmd.install.*
import zowe.imperative.imperative.plugins.cmd.list.*
import zowe.imperative.imperative.plugins.cmd.showfirststeps.*
import zowe.imperative.imperative.plugins.cmd.uninstall.*
import zowe.imperative.imperative.plugins.cmd.update.*
import zowe.imperative.imperative.plugins.cmd.validate.*
import zowe.imperative.imperative.plugins.doc.*
import zowe.imperative.imperative.plugins.errors.*
import zowe.imperative.imperative.plugins.utilities.*
import zowe.imperative.imperative.profiles.*
import zowe.imperative.imperative.profiles.builders.*
import zowe.imperative.imperative.profiles.handlers.*
import zowe.imperative.interfaces.doc.*
import zowe.imperative.interfaces.types.*
import zowe.imperative.io.*
import zowe.imperative.logger.*
import zowe.imperative.logger.doc.*
import zowe.imperative.messages.*
import zowe.imperative.messages.doc.*
import zowe.imperative.operations.*
import zowe.imperative.operations.doc.*
import zowe.imperative.profiles.*
import zowe.imperative.profiles.abstract.*
import zowe.imperative.profiles.constants.*
import zowe.imperative.profiles.doc.api.*
import zowe.imperative.profiles.doc.config.*
import zowe.imperative.profiles.doc.definition.*
import zowe.imperative.profiles.doc.parms.*
import zowe.imperative.profiles.doc.response.*
import zowe.imperative.profiles.utils.*
import zowe.imperative.profiles.validation.api.*
import zowe.imperative.profiles.validation.doc.*
import zowe.imperative.rest.client.*
import zowe.imperative.rest.client.doc.*
import zowe.imperative.rest.client.types.*
import zowe.imperative.rest.session.*
import zowe.imperative.rest.session.doc.*
import zowe.imperative.security.*
import zowe.imperative.security.abstract.*
import zowe.imperative.security.doc.*
import zowe.imperative.security.errors.*
import zowe.imperative.settings.*
import zowe.imperative.settings.doc.*
import zowe.imperative.settings.errors.*
import zowe.imperative.settings.persistance.*
import zowe.imperative.utilities.diff.*
import zowe.imperative.utilities.diff.doc.*
import zowe.imperative.utilities.doc.*
import kotlin.ts.Union

/**
 * Cli Utils contains a set of static methods/helpers that are CLI related (forming options,
 * censoring args, etc.)
 */
external class CliUtils {
  companion object {
    /**
     * Used as the place holder when censoring arguments in messages/command output
     */
    @JsString("****")
    val CENSOR_RESPONSE: String

    /**
     * A list of cli options/keywords that should normally be censored
     */
    var CENSORED_OPTIONS: Array<String>

    /**
     * Get the 'dash form' of an option as it would appear in a user's command, appending the proper
     * number of dashes depending on the length of the option name
     *
     * @param optionName e.g. my-option
     * @return e.g. --my-option
     */
    fun getDashFormOfOption(optionName: String): String

    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     *
     * @param args The args list to censor
     */
    fun censorCLIArgs(args: Array<String>): Array<String>

    /**
     * Copy and censor a yargs argument object before logging
     *
     * @param args the args to censor
     * @return a censored copy of the arguments
     */
    fun censorYargsArguments(args: ICommandArguments): ICommandArguments

    /**
     * Accepts the full set of loaded profiles and attempts to match the option names supplied with
     * profile keys.
     *
     * @param profiles the map of type to loaded profiles. The key is
     *   the profile type and the value is an array of profiles loaded for that type.
     * @param definitions the profile definition on the command.
     * @param options the full set of command options for the command being processed
     */
    fun getOptValueFromProfiles(
      profiles: CommandProfiles,
      definitions: ICommandProfile,
      options: Array<Union<ICommandOptionDefinition, ICommandPositionalDefinition>>,
    ): Any?

    /**
     * Using Object.assign(), merges objects in the order they appear in call. Object.assign()
     * copies and overwrites existing properties in the target object, meaning property precedence
     * is least to most (left to right).
     *
     * See details on Object.assign() for nuance.
     *
     * @param args variadic set of objects to be merged
     * @return the merged object
     */
    fun mergeArguments(vararg args: Any?): Any?

    /**
     * Accepts the full set of command options and extracts their values from environment variables
     * that are set.
     *
     * @param options the full set of options specified on the command definition.
     *   Includes both the option definitions and the positional definitions.
     * @return the argument style object with both camel and kebab
     *   case keys for each option specified in environment variables.
     */
    fun extractEnvForOptions(
      envPrefix: String,
      options: Array<Union<ICommandOptionDefinition, ICommandPositionalDefinition>>,
    ): Any?

    /**
     * Convert an array of strings provided as an environment variable
     *
     * @param envValue String form of the array
     * @return String[] based on environment variable
     */
    fun extractArrayFromEnvValue(envValue: String): Array<String>

    /**
     * Get the value of an environment variable associated with the specified option name. The
     * environment variable name will be formed by concatenating an environment name prefix, and the
     * cmdOption using underscore as the delimiter.
     *
     * The cmdOption name can be specified in camelCase or in kabab-style. Regardless of the style,
     * it will be converted to upper case. We replace dashes in Kabab-style values with underscores.
     * We replace each uppercase character in a camelCase value with underscore and that character.
     *
     * The envPrefix will be used exactly as specified.
     *
     * Example: The values myEnv-Prefix and someOptionName would retrieve the value of an
     * environment variable named myEnv-Prefix_SOME_OPTION_NAME
     *
     * @param envPrefix The prefix for environment variables for this CLI. Our caller can
     *   use the value obtained by ImperativeConfig.instance.envVariablePrefix, which will use the
     *   envVariablePrefix from the Imperative config object, and will use the rootCommandName as a
     *   fallback value.
     * @param cmdOption The name of the option in either camelCase or kabab-style.
     * @return The value of the environment variable which corresponds to the
     *   supplied option for the supplied command. If no such environment variable exists we return null.
     */
    fun getEnvValForOption(
      envPrefix: String,
      cmdOption: String,
    ): String?

    /**
     * Constructs the yargs style positional argument string.
     *
     * @param positionalRequired Indicates that this positional is required
     * @param positionalName The name of the positional
     * @return The yargs style positional argument string (e.g. <name>);
     */
    fun getPositionalSyntaxString(
      positionalRequired: Boolean,
      positionalName: String,
    ): String

    /**
     * Format the help header - normally used in help generation etc.
     *
     * @param header
     * @param indent Default: " "
     * @param color
     */
    fun formatHelpHeader(
      header: String,
      indent: String,
      color: String,
    ): String

    /**
     * Display a message when the command is deprecated.
     *
     * @param handlerParms the IHandlerParameters supplied to a command handler's process() function.
     */
    fun showMsgWhenDeprecated(handlerParms: IHandlerParameters)

    /**
     * Accepts an option name, and array of option aliases, and their value and returns the
     * arguments style object.
     *
     * Example:
     *
     * **Create Argument Object**
     * ```
     * CliUtils.setOptionValue("my-option", ["mo", "o"], "value");
     *
     * // returns { "myOption": "value", "my-option": "value", "mo": "value", "o": "value" }
     * ```
     *
     * @param optName The command option name, usually in kebab case (or a single word)
     * @param optAliases An array of alias names for this option
     * @param value The value to assign to the argument
     * @return The argument style object
     */
    fun setOptionValue(
      optName: String,
      optAliases: Array<String>,
      value: Any?,
    ): Any?

    /**
     * Display a prompt that hides user input and reads from stdin DOES NOT WORK WITH COMMANDS THAT
     * ALSO READ STDIN Useful for prompting the user for sensitive info such as passwords
     * Synchronous
     *
     * @param message The message to display to the user e.g. "Please enter password:"
     * @return the value entered by the user
     */
    @Deprecated("Use the asynchronous method readPrompt instead")
    fun promptForInput(message: String): String

    /**
     * Sleep for the specified number of miliseconds.
     *
     * Example:
     *
     * **create a synchronous delay as follows**
     * ```
     * await CliUtils.sleep(3000);
     * ```
     *
     * @param timeInMs Number of miliseconds to sleep
     */
    fun sleep(timeInMs: Int): Promise<Any?>

    /**
     * Prompt the user with a question and wait for an answer, but only up to the specified timeout.
     *
     * Example:
     * ```
     * const answer = await CliUtils.promptWithTimeout("Type your answer here: ");
     *
     * if (answer === null) {
     *   // abort the operation that you wanted to perform
     * } else {
     *   // use answer in some operation
     * }
     * ```
     *
     * @param questionText The text with which we will prompt the user.
     * @param hideText Should we hide the text. True = display stars. False = display text. Default = false.
     * @param secToWait The number of seconds that we will wait for an answer. If not supplied, the default is 600 seconds.
     * @return A string containing the user's answer, or null if we timeout.
     */
    @Deprecated("Use readPrompt instead which supports more options")
    fun promptWithTimeout(
      questionText: String,
      hideText: Boolean = definedExternally,
      secToWait: Int = definedExternally,
    ): Promise<String>

    /**
     * Prompt the user with a question and wait for an answer, but only up to the specified timeout.
     *
     * Example:
     * ```
     * const answer = await CliUtils.readPrompt("Type your answer here: ");
     *
     * if (answer === null) {
     *   // abort the operation that you wanted to perform
     * } else {
     *   // use answer in some operation
     * }
     * ```
     *
     * @param message The text with which we will prompt the user.
     * @param opts.hideText Should we hide the text. True = display stars. False = display text.
     *   Default = false.
     * @param opts.secToWait The number of seconds that we will wait for an answer. If not supplied,
     *   the default is 10 minutes. If 0 is specified, we will never timeout. Numbers larger than
     *   3600 (1 hour) are not allowed.
     * @param opts.maskChar The character that should be used to mask hidden text. If null is
     *   specified, then no characters will be echoed back.
     * @return A string containing the user's answer, or null if we timeout.
     */
    fun readPrompt(
      message: String,
      opts: IPromptOptions = definedExternally,
    ): Promise<String?>

    /**
     * Accepts the yargs argument object and constructs the base imperative argument object. The
     * objects are identical to maintain compatibility with existing CLIs and plugins, but the
     * intent is to eventually phase out having CLIs import anything from Yargs (types, etc).
     *
     * @param args Yargs argument object
     * @return Imperative argument object
     */
    // TODO(Edoardo): use Arguments from yargs. ICommandArguments is not really the same thing
    fun buildBaseArgs(args: ICommandArguments): ICommandArguments

    /**
     * Takes a key and converts it to both camelCase and kebab-case.
     *
     * @param key The key to transform
     * @return An object that contains the new format.
     *
     * Example:
     *
     * **Conversion of keys**
     *
     * ```
     * CliUtils.getOptionFormat("helloWorld");
     *
     * // returns const return1 = { key: "helloWorld", camelCase: "helloWorld", kebabCase: "hello-world" }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello-world");
     *
     * // returns const return2 = { key: "hello-world", camelCase: "helloWorld", kebabCase: "hello-world" }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello--------world");
     *
     * // returns const return3 = { key: "hello--------world", camelCase: "helloWorld", kebabCase: "hello-world" }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello-World-");
     *
     * // returns const return4 = { key: "hello-World-", camelCase: "helloWorld", kebabCase: "hello-world" }
     * ```
     */
    fun getOptionFormat(key: String): IOptionFormat
  }
}
