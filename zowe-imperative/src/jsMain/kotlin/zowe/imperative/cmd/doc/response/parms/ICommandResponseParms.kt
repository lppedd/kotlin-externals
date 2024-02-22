package zowe.imperative.cmd.doc.response.parms

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.response.api.processor.CommandResponseFormat
import kotlin.js.plain.JsPlainObject

/**
 * Command response control parameters. Indicates how the command response should behave and allows
 * influence over colorings, etc.
 */
@JsPlainObject
external interface ICommandResponseParms {
  /**
   * Stream
   */
  var stream: Any?

  /**
   * The arguments specified on the command line
   */
  var args: ICommandArguments?

  /**
   * The command definition for this response
   */
  var definition: ICommandDefinition?

  /**
   * The primary text color used by Chalk package for highlighting messages.
   */
  var primaryTextColor: String?

  /**
   * Silent indicates that the command should produce absolutely no output to stdout/stderr (the
   * console/terminal)
   */
  var silent: Boolean?

  /**
   * The response format for the command. Controls how output is generated for the command (ignored
   * if silent is specified). See the type for more details.
   */
  var responseFormat: CommandResponseFormat?

  /**
   * The Progress bar spinner characters.
   */
  var progressBarSpinner: String?
}
