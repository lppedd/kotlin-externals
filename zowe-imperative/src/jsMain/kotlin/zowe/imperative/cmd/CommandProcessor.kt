@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd

import js.promise.Promise
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.parms.IInvokeCommandParms
import zowe.imperative.cmd.doc.processor.ICommandProcessorParms
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.doc.response.response.ICommandResponse
import zowe.imperative.cmd.doc.response.response.ICommandValidatorResponse
import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.cmd.response.CommandResponse
import zowe.imperative.config.Config
import zowe.imperative.profiles.doc.api.IProfileManagerFactory

/**
 * The command processor for imperative - accepts the command definition for the command being
 * issued (and a pre-built) response object and validates syntax, loads profiles, instantiates
 * handlers, & invokes the handlers.
 */
external class CommandProcessor {
  /**
   * Creates an instance of CommandProcessor.
   *
   * @param params See the interface for details.
   */
  constructor(params: ICommandProcessorParms)

  /**
   * Accessor for the root command name
   */
  val rootCommand: String

  /**
   * Accessor for the command line
   */
  val commandLine: String

  /**
   * Accessor for the environment variable prefix
   */
  val envVariablePrefix: String

  /**
   * Accessor for the prompt phrase
   */
  val promptPhrase: String

  /**
   * Accessor for the help generator passed to this instance of the command processor
   */
  val helpGenerator: IHelpGenerator

  /**
   * Accessor for the app config
   */
  val config: Config

  /**
   * Accessor for the profile manager factory in use for this command processor.
   */
  val profileFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>

  /**
   * Obtain a copy of the command definition
   *
   * @return The Bright Commands definition document.
   */
  val definition: ICommandDefinition

  /**
   * Obtain a copy of the command definition
   *
   * @return The Bright Commands definition document.
   */
  val fullDefinition: ICommandDefinition

  /**
   * Generates the help for the command definition passed.
   *
   * @param response The command response object
   */
  fun help(response: CommandResponse): ICommandResponse

  /**
   * Generates the help for the command definition passed.
   *
   * @param inContext Name of page for group/command to jump to
   * @param response The command response object
   */
  fun webHelp(
    inContext: String,
    response: CommandResponse,
  ): ICommandResponse

  /**
   * Validates the input arguments/options for the command (Performs additional validation outside
   * of what Yargs already provides - ideally, we would like to maintain control over all errors and
   * messages for consistency).
   *
   * @param commandArguments The input command arguments from the command line.
   * @param responseObject Response object to print.
   * @return Promise to be fulfilled when validation is complete.
   */
  fun validate(
    commandArguments: ICommandArguments,
    responseObject: CommandResponse,
  ): Promise<ICommandValidatorResponse>

  /**
   * Invoke the command handler. Locates and requires the module specified by the command definition
   * document, creates a new object, creates a response object, and invokes the handler. The handler
   * is responsible for fulfilling the promise when complete.
   *
   * @param params The parameters passed to the invoke function
   * @return The promise that is fulfilled. A rejection if the promise
   *   indicates a truly exceptional condition (should not occur).
   */
  fun invoke(params: IInvokeCommandParms): Promise<ICommandResponse>
}
