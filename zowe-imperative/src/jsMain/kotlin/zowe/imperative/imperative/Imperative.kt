@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import js.promise.Promise
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.cmd.help.doc.IHelpGeneratorParms
import zowe.imperative.imperative.api.ImperativeApi
import zowe.imperative.imperative.doc.IDaemonContext
import zowe.imperative.imperative.doc.IImperativeConfig
import zowe.imperative.logger.Logger

/**
 * Main class of the Imperative framework, returned when you require("@zowe/imperative")
 * e.g. const imperative = require("@zowe/imperative");
 */
external class Imperative {
  companion object {
    val DEFAULT_DEBUG_FILE: String

    /**
     * Retrieve the root command name.
     *
     * For example, in "banana a b --c", "banana" is the root command name.
     *
     * @return root command name
     */
    val rootCommandName: String

    /**
     * Retrieve the command line.
     *
     * For example, in "banana a b --c", "a b --c" is the command line.
     *
     * @return command line
     */
    var commandLine: String

    /**
     * Get the complete full command tree
     */
    val fullCommandTree: ICommandDefinition

    /**
     * Initialize the configuration for your CLI. Wipes out any existing config that has already
     * been set.
     *
     * @param config Configuration for Imperative provided by your
     *   application. If this parameter is not set, we will look in the closest package.json up the
     *   directory tree from the main entry point of your cli.
     *
     *   package.imperative.configurationModule should point to the compiled module that exports the
     *   configuration.
     *
     * @return A promise indicating that we are done here.
     */
    fun init(config: IImperativeConfig = definedExternally): Promise<Unit>

    /**
     * Returns the default console object to be used for messaging for imperative fails to
     * initialize or to be used before logging is initialized.
     *
     * @return an instance of the default console object
     */
    val console: Logger

    /**
     * Parse command line arguments and issue the user's specified command
     *
     * @return this, for chaining syntax
     */
    fun parse(
      args: String = definedExternally,
      context: IDaemonContext = definedExternally,
    ): Imperative

    /**
     * Parse command line arguments and issue the user's specified command
     *
     * @return this, for chaining syntax
     */
    fun parse(
      args: Array<String> = definedExternally,
      context: IDaemonContext = definedExternally,
    ): Imperative

    /**
     * @param type the profile type to search for configuration for
     * @return The profile configuration if found,
     *   otherwise, undefined.
     */
    fun getProfileConfiguration(type: String): ICommandProfileTypeConfiguration?

    /**
     * Get the configured help generator for your CLI. If you have not specified a custom generator,
     * the DefaultHelpGenerator will be used. You probably won't need to call this from your CLI,
     * but it is used internally.
     *
     * @param parms parameters to the help generator including command
     *   definition
     * @return The help generator for the command
     */
    fun getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator

    /**
     * Returns the imperative API object containing various framework API methods for usage in your
     * CLI implemenation.
     *
     * @return The api object.
     */
    val api: ImperativeApi

    /**
     * Highlight text with your configured (or default) primary color
     *
     * @param text the text to highlight
     * @return the highlighted text
     */
    fun highlightWithPrimaryColor(text: String): String

    /**
     * Get the configured environmental variable prefix for the user's CLI
     *
     * @return the configured or default prefix for environmental variables for use in
     *   the environmental variable service
     */
    @Deprecated("Please use ImperativeConfig.instance.envVariablePrefix")
    val envVariablePrefix: String

    /**
     * Highlight text with your configured (or default) secondary color
     *
     * @param text the text to highlight
     * @return the highlighted text
     */
    fun highlightWithSecondaryColor(text: String): String
  }
}
