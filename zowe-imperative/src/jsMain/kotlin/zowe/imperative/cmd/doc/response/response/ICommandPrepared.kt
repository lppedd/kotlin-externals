package zowe.imperative.cmd.doc.response.response

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.profiles.CommandProfiles
import kotlin.js.plain.JsPlainObject

/**
 * Command Processor prepare response.
 */
@JsPlainObject
external interface ICommandPrepared {
  /**
   * The profile map object for all profiles loaded for commands.
   */
  var profiles: CommandProfiles

  /**
   * Imperative arguments object. Starts with arguments passed parsed by Yargs as a base and fills
   * in the rest from ENV/profile/defaults. Eventually passed to handlers.
   */
  var args: ICommandArguments
}
