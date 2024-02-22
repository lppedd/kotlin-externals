@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help.abstract

import js.objects.Record
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.option.CommandOptionType
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactoryParms
import zowe.imperative.cmd.help.doc.IHelpGeneratorParms
import zowe.imperative.logger.Logger

abstract external class AbstractHelpGenerator : IHelpGenerator {
  constructor(defaultParms: IHelpGeneratorFactoryParms, commandParms: IHelpGeneratorParms)

  /**
   * The command name being invoked by the user.
   *
   * For example, when using "banana --help", banana is the command name.
   */
  var mRootCommandName: String

  /**
   * The command definition for which we are building help
   */
  var mCommandDefinition: ICommandDefinition

  /**
   * The full command definition - which includes the parents of the command.
   */
  var mDefinitionTree: ICommandDefinition

  /**
   * Produce markdown - not help text.
   */
  var mProduceMarkdown: Boolean

  /**
   * Logger
   */
  var mLog: Logger
  var mPrimaryHighlightColor: String

  /**
   * The configured experimental command description.
   *
   * Has a default, generic description which can be overridden through parameters to the constructor
   */
  var mExperimentalCommandDescription: String

  /**
   * A map of group names to option names and aliases - useful in help text/doc generation
   *
   * e.g. this.grouptoOption["job options"] -> [ "--async | -a ", "--activate | -A"]
   */
  var groupToOption: Record<String, Array<String>>

  /**
   * A map of option names and aliases to their descriptions - useful in help text/doc generation
   *
   * e.g. this.optionToDescription["--async | a"] -> "Don't wait for this job to complete before
   * returning"
   */
  var optionToDescription: Record<String, String>

  /**
   * Get log instance
   */
  val log: Logger

  override fun buildHelp(): String

  fun getOptionAndAliasesString(
    option: ICommandOptionDefinition,
    caseSensitive: Boolean = definedExternally,
  ): String

  open fun buildFullCommandHelpText(includeGlobalOptions: Boolean): String

  fun buildOptionMaps()

  fun getCaseSensitiveFlagByOptionName(optionName: String): Boolean

  fun renderHelp(help: String): String

  fun explainType(type: CommandOptionType): String

  /**
   * Highlight text in dim grey (disabled if producing markdown)
   *
   * @param text the text you would like to highlight
   * @return the highlighted text
   */
  fun dimGrey(text: String): Any?

  /**
   * Highlight text in grey (disabled if producing markdown)
   *
   * @param text the text you would like to highlight
   * @return the highlighted text
   */
  fun grey(text: String): Any?

  companion object {
    var SHORT_DASH: String
    var LONG_DASH: String

    /**
     * Get a heading for the CLI / help
     *
     * @param header The text you want to display in the header
     * @param indent prefix the heading and dashes with this string (defaults to one space)
     * @param color the color to highlight the header in
     * @return the formatted/colored header
     */
    fun formatHelpHeader(
      header: String,
      indent: String,
      color: String,
    ): String
  }
}
