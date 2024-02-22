package zowe.imperative.cmd.doc.handler

import node.stream.Readable
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi
import zowe.imperative.cmd.profiles.CommandProfiles
import kotlin.js.plain.JsPlainObject

/**
 * The handler parameters are passed to the instantiated command handler and populated by the
 * command processor. The parameters supply everything a command handler needs to operate:
 * arguments, response object, profiles, the command definition document, and more.
 *
 * Handlers should NEVER perform their own console/stdout/stderr invocations. The response object is
 * provided for all messaging and logging capabilities.
 */
@JsPlainObject
external interface IHandlerParameters {
  /**
   * The response object used to issue messages and build responses to the command. No command
   * should be writing to console/stdout/stderr directly. The response object provides the
   * capability of collecting responses for the JSON response format (among other capabilities). A
   * handler can choose to log differently, however a logger is also provided on the command
   * response object.
   */
  var response: IHandlerResponseApi

  /**
   * The arguments specified by the user on the command line (in the Yargs object format).
   */
  var arguments: ICommandArguments

  /**
   * The positional options specified by the user on the command line.
   */
  var positionals: Array<String>

  /**
   * The set of profiles loaded for this command handler - the map is built with the key being the
   * type and it returns the set of profiles loaded of that type. Multiple profiles can be loaded of
   * the same type - depending on the request and the 0th entry is the first loaded.
   */
  @Deprecated("This API only loads v1 profiles. To load v2 profiles, use ImperativeConfig.instance.config.api.profiles")
  var profiles: CommandProfiles

  /**
   * The command definition node that defines the command being issued.
   */
  var definition: ICommandDefinition

  /**
   * The full command definition tree that includes the command being issued.
   */
  var fullDefinition: ICommandDefinition

  /**
   * The input stream that can be used by the command being issued.
   */
  var stdin: Readable

  /**
   * Has your command been invoked from a chained handler? (see ICommandDefinition.chainedHandlers)
   * You can use this to influence the behavior of your command (e.g. not printing certain messages
   * from within a chained command)
   */
  var isChained: Boolean?
}
