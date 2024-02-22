package zowe.imperative.cmd.yargs.doc

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.response.parms.ICommandResponseParms
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactory
import zowe.imperative.cmd.yargs.GroupCommandYargs
import zowe.imperative.profiles.doc.api.IProfileManagerFactory

/**
 * Imperative Yargs parameters - used to define imperative commands to Yargs and provides
 * guidance/parameters for how response objects should be handled when yargs invokes the handlers.
 */
external interface IYargsParms {
  /**
   * The instance of Yargs to define the commands.
   */
  var yargsInstance: Any /* Argv */ // TODO(Edoardo): use Argv from yargs

  /**
   * The command definition document.
   */
  var commandDefinition: ICommandDefinition

  /**
   * The command response parameters normally scraped from the Imperative configuration document.
   */
  var commandResponseParms: ICommandResponseParms

  /**
   * The help generator factory to be used in this CLI help generation
   */
  var helpGeneratorFactory: IHelpGeneratorFactory

  /**
   * The profile manager factory to use in this CLI profile management.
   */
  var profileManagerFactory: IProfileManagerFactory<*>

  /**
   * Optionally override the experimental command help text block. Used to propagate the user's
   * configuration down to different yargs/cmd services.
   */
  var experimentalCommandDescription: String

  /**
   * Root command name of the CLI.
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
   * The Yargs Parent object - only has meaning for nested/group commands.
   */
  var yargsParent: GroupCommandYargs?

  /**
   * The phrase used to indicate the user wants to enter the value of an argument in a hidden text prompt
   */
  var promptPhrase: String
}
