@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help

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
import zowe.imperative.cmd.doc.response.response.*
import zowe.imperative.cmd.handlers.*
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
import zowe.imperative.utilities.*
import zowe.imperative.utilities.diff.*
import zowe.imperative.utilities.diff.doc.*
import zowe.imperative.utilities.doc.*

/**
 * Imperative default help generator. Accepts the command definitions and constructs the full help
 * text for the command node.
 *
 * TODO - Consider removing word wrap on a fixed with and apply dynamically based on terminal sizes
 */
external class DefaultHelpGenerator : AbstractHelpGenerator {
  /**
   * Creates an instance of DefaultHelpGenerator.
   *
   * @param defaultParms Imperative config parameters for help
   *   generation - See interface for details
   * @param commandParms The command definitions for generating help - See
   *   interface for details
   */
  constructor(defaultParms: IHelpGeneratorFactoryParms, commandParms: IHelpGeneratorParms)

  /**
   * Construct the full help text for display.
   *
   * @return The full help text
   */
  override fun buildHelp(): String

  /**
   * Build the help text for a "group" - a group has a set of children The help text contains the
   * standard description/usage/etc., but unlike a command only displays the next set of "commands"
   * or "groups" that can be issued after the current node.
   *
   * @return the full group help text
   */
  fun buildFullGroupHelpText(): String

  /**
   * Returns the help text for the command definition - the help text contains the standard items
   * such as description/usage/etc. and also contains the full option descriptions for the command.
   *
   * @param includeGlobalOptions Include the global options in the help text
   * @return The help text for --help or markdown.
   */
  override fun buildFullCommandHelpText(includeGlobalOptions: Boolean): String

  /**
   * Returns the help text for the command definition - the help text contains the standard items
   * such as description/usage/etc. and also contains the full option descriptions for the command.
   *
   * @return The help text for --help or markdown.
   */
  // Note(Edoardo): this is an added overload as I can't specify a default value in this interface
  fun buildFullCommandHelpText(): String

  /**
   * Build a string containing the command name and aliases separated by the vertical bar:
   * command | c
   *
   * @param commandDefinition The definition for the command
   * @return Contains the command name followed by the aliases (e.g. command | c)
   */
  fun buildCommandAndAliases(commandDefinition: ICommandDefinition): String

  /**
   * Builds a table of commands/groups for display in the help:
   *
   * GROUPS
   * ------
   * group1 hello this is group1 group2 hello this is group2
   *
   * @return Returns the table for display.
   */
  fun buildChildrenSummaryTables(): String

  /**
   * Build the usage diagram for the command.
   *
   * TODO - very simple at the moment, should be enhanced with a "better" diagram
   */
  fun buildUsageDiagram(): String

  /**
   * Build the usage section of the help text:
   *
   * USAGE
   * -----
   * command blah [options]
   *
   * @return The usage help text section
   */
  fun buildUsageSection(): String

  /**
   * Build the global options section of the command help text.
   *
   * GLOBAL OPTIONS
   * --------------
   * ...
   *
   * @return The global options help text section
   */
  fun buildGlobalOptionsSection(): String

  /**
   * Build the command description section of the help text:
   *
   * DESCRIPTION
   * -----------
   * This command is great.
   *
   * @return The command description text
   */
  fun buildDescriptionSection(): String

  /**
   * Return the help text format for positional parameters - includes the parameter itself, the
   * optional regex, and the full description.
   *
   * @return The help text for each positional parameter.
   */
  fun buildPositionalArgumentsSection(): String

  /**
   * From the map of options (group to option), formulate the group and options in the form of:
   *
   * OPTION GROUP
   * ------------
   * option1
   *
   * Description of option1
   *
   * option2
   *
   * Description of option2
   */
  fun buildCommandOptionsSection(): String

  /**
   * Build the text for option:
   *
   * --option
   *
   * The description for this option
   *
   * @param optionString The option string (-- form or positional, etc.)
   * @param description The description for the option
   * @return The option text
   */
  fun buildOptionText(
    optionString: String,
    description: String,
  ): String

  /**
   * Produces a header for the current section in help:
   *
   * COMMANDS
   * --------
   * @param header the header text (e.g. COMMANDS)
   * @return The header
   */
  fun buildHeader(header: String): String

  /**
   * Build the examples text for the command. Examples include the command example (which normally
   * is able to be copy/pasted verbatim) and the description for the example.
   *
   * TODO - we should remove wordwrap from this
   *
   * @return The example text
   */
  fun buildExamplesSection(): String

  /**
   * Get a blurb explaining experimental commands if this command is experimental
   *
   * @return If this command is experimental, returns the experimental command
   *   explanation block
   */
  fun getExperimentalCommandSection(): String

  companion object {
    /**
     * The help indent for spacing/alignment
     */
    @JsString("   ")
    val HELP_INDENT: String
  }
}
