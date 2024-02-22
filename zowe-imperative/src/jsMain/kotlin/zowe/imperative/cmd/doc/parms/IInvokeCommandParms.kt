package zowe.imperative.cmd.doc.parms

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.response.api.processor.CommandResponseFormat
import kotlin.js.plain.JsPlainObject

/**
 * Parameters to the command processor invoke method.
 */
@JsPlainObject
external interface IInvokeCommandParms {
  /**
   * The Yargs style arguments for the command processor.
   */
  var arguments: ICommandArguments

  /**
   * Indicates that the command should be totally silent (no output to the console).
   */
  var silent: Boolean?

  /**
   * Indicates that the response format to the command should be written in JSON. If silent mode is
   * enabled, then nothing is written (regardless of this setting)
   */
  var responseFormat: CommandResponseFormat?
}
