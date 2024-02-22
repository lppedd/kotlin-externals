package zowe.imperative.profiles.doc.parms

import zowe.imperative.cmd.doc.args.ICommandArguments
import kotlin.js.plain.JsPlainObject

/**
 * Parameters for creating a profile from command line arguments - normally invoked from a command
 * handler that is pre-built by imperative.
 */
@JsPlainObject
external interface ISaveProfileFromCliArgs : ISaveProfile {
  /**
   * The Yargs style arguments - supplied from the command invocation.
   */
  var args: ICommandArguments?
}
