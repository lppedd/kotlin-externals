@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.response.parms.ICommandResponseParms
import zowe.imperative.cmd.doc.response.response.ICommandResponse
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactory
import zowe.imperative.cmd.yargs.doc.IYargsParms
import zowe.imperative.cmd.yargs.doc.IYargsResponse
import zowe.imperative.cmd.yargs.doc.ImperativeYargsCommandAction
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.api.IProfileManagerFactory

/**
 * Abstract Yargs Bright Command - Contains base methods for defining commands and groups
 */
abstract external class AbstractCommandYargs {
  /**
   * Construct the yargs command instance for imperative. Provides the ability to define Imperative
   * commands to Yargs.
   *
   * @param yargsParms Parameter object contains parms for Imperative/Yargs and command response objects
   */
  constructor(yargsParms: IYargsParms)

  var yargsParms: IYargsParms
  var log: Logger

  /**
   * Accessor for the root command name for the CLI
   */
  val rootCommandName: String

  /**
   * Accessor for the command line
   */
  val commandLine: String

  /**
   * Accessor for the Environmental variable prefix
   */
  val envVariablePrefix: String

  /**
   * Accessor for the CLI prompt phrase
   */
  val promptPhrase: String

  /**
   * Accessor for the command response parms (for subclasses)
   */
  val responseParms: ICommandResponseParms

  /**
   * Accessor for the help generator factory.
   */
  val helpGeneratorFactory: IHelpGeneratorFactory

  /**
   * Accessor for the profile manager factory
   */
  val profileManagerFactory: IProfileManagerFactory<*>

  /**
   * Returns a copy of the definition.
   */
  val definition: ICommandDefinition

  /**
   * Returns the Yargs instance.
   */
  val yargs: Any /* Argv */ // TODO(Edoardo): use Argv from yargs

  /**
   * Get the array of parents.
   *
   * @return The array of parents.
   */
  val parents: Array<GroupCommandYargs>

  /**
   * Construct the Bright command definition "tree" - the full definition document including all
   * parents.
   *
   * @return The command definition "tree".
   */
  fun constructDefinitionTree(): ICommandDefinition

  /**
   * Define the command to Yargs - Accepts the callback to be invoked when this command has
   * executed.
   *
   * @param commandExecuted Invoked after the command is executed.
   */
  open fun defineCommandToYargs(commandExecuted: YargsCommandCompleted)

  @Deprecated("Use getZoweYargsResponse instead")
  fun getBrightYargsResponse(
    successful: Boolean,
    responseMessage: String,
    action: ImperativeYargsCommandAction,
    responses: Array<ICommandResponse> = definedExternally,
  ): IYargsResponse

  /**
   * Build The Bright Yargs response for the callback. Includes the Bright command response and
   * status info.
   *
   * @param successful True if the command succeeded
   * @param responseMessage Response message for display purposes.
   * @param action
   * @param responses
   */
  fun getZoweYargsResponse(
    successful: Boolean,
    responseMessage: String,
    action: ImperativeYargsCommandAction,
    responses: Array<ICommandResponse> = definedExternally,
  ): IYargsResponse

  /**
   * Execute the help Command for the definition.
   *
   * @param args The arguments passed by the user - used for -y.
   * @param commandExecuted The callback when help is complete.
   */
  fun executeHelp(
    args: ICommandArguments, // TODO(Edoardo): use Arguments from yargs
    commandExecuted: YargsCommandCompleted,
  )

  /**
   * Get examples for all commands of a group
   */
  fun getDepthExamples(): ICommandDefinition

  /**
   * Execute the web help Command for the definition.
   *
   * @param args The arguments passed by the user - used for -y.
   * @param commandExecuted The callback when help is complete.
   */
  fun executeWebHelp(
    args: ICommandArguments, // TODO(Edoardo): use Arguments from yargs
    commandExecuted: YargsCommandCompleted,
  )

  companion object {
    /**
     * TODO: REMOVE THIS, workaround for yargs.fail() problem
     */
    var STOP_YARGS: Boolean
  }
}
