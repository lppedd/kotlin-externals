@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.doc.response.parms.ICommandResponseParms
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactory
import zowe.imperative.profiles.doc.api.IProfileManagerFactory

/**
 * Imperative Command Definer - Defines the Imperative command objects to Yargs for processing.
 */
external class YargsDefiner {
  /**
   * Build the definer - maintains the Yargs instance for all future definitions.
   *
   * @param yargsInstance The Yargs instance used to define the commands.
   * @param primaryHighlightColor main color to highlight help text headings and other text with
   * @param rootCommandName the display name of the root command (e.g. "bright" or "sample-cli")
   * @param envVariablePrefix the environment variable prefix
   * @param profileManagerFactory profile manager factory that can be used to instantiate new profile managers
   * @param helpGeneratorFactory help generator factory that can be used to instantiate new help generators
   * @param experimentalCommandDescription optionally overridden experimental command description
   *   to propagate to yargs services
   */
  constructor(
    yargsInstance: Any, /* Argv */ // TODO(Edoardo): use Argv from yargs
    primaryHighlightColor: String,
    rootCommandName: String,
    commandLine: String,
    envVariablePrefix: String,
    profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>,
    helpGeneratorFactory: IHelpGeneratorFactory,
    experimentalCommandDescription: String,
    promptPhrase: String,
  )

  /**
   * Accepts an Imperative command definition document and defines to Yargs.
   *
   * @param definition The Imperative JSON command definition document.
   * @param commandExecuted An "event-style" callback that is invoked upon
   *   completion of a command execution for this definition.
   * @param responseParms The response object parameters used when
   *   invoking commands and help
   */
  fun define(
    definition: ICommandDefinition,
    commandExecuted: YargsCommandCompleted,
    responseParms: ICommandResponseParms,
  )
}
