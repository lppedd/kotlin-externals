package zowe.imperative.cmd.doc.processor

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.config.Config
import zowe.imperative.imperative.doc.IDaemonContext
import zowe.imperative.profiles.doc.api.IProfileManagerFactory
import kotlin.js.plain.JsPlainObject

/**
 * Parameters to create an instance of the Command Processor. Contains the command definition (for
 * the command being executed) and help, profiles, etc.
 */
@JsPlainObject
external interface ICommandProcessorParms {
  /**
   * The command definition node for the command being executed. The command definition is assumed
   * to have a handler (or handlers).
   */
  var definition: ICommandDefinition

  /**
   * The help generator for the command being executed.
   */
  var helpGenerator: IHelpGenerator

  /**
   * The profile manager factory allows the command processor to obtain an instance of the profile
   * manager for the command being issued.
   */
  var profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>

  /**
   * The root command name for the CLI - used in help generation, etc.
   */
  var rootCommandName: String

  /**
   * The command line.
   */
  var commandLine: String

  /**
   * Environmental variable name prefix used to construct configuration environmental variables.
   */
  var envVariablePrefix: String

  /**
   * All ancestors (parents) of the command definition for the command being executed. Used in help
   * generation.
   */
  var fullDefinition: ICommandDefinition?

  /**
   * The phrase used to indicate the user wants to enter the value of an argument in a hidden text
   * prompt
   */
  var promptPhrase: String

  /**
   * Config object used to load profiles from active config layers.
   */
  var config: Config?

  /**
   * The context object defined when in daemon mode.
   */
  var daemonContext: IDaemonContext?
}
