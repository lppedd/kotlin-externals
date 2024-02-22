package zowe.imperative.cmd.doc.response.response

import node.buffer.Buffer
import zowe.imperative.error.doc.IImperativeError
import kotlin.js.plain.JsPlainObject

/**
 * Command response object built by the command processor (and command handler). The response object
 * is always built internally, but displayed to the command issuer if response-format-json is
 * specified.
 *
 * For handlers, see the HandlerResponse (IHandlerResponseApi) for the public APIs used to by
 * handlers to create this response.
 */
@JsPlainObject
external interface ICommandResponse {
  /**
   * Overall command success flag. True indicates that the command handler/processor/help was
   * successful.
   */
  var success: Boolean

  /**
   * Requested exit code for the process when your command is complete. If this is not specified,
   * the default is 0 for successful commands and 1 for failed commands according to the value of
   * the above "success" field.
   */
  var exitCode: Int

  /**
   * Message appended by the handlers. The message is not displayed on the console, only displayed
   * if response format JSON is indicated.
   */
  var message: String

  /**
   * The stdout from the command. Buffered regardless of response format specification.
   */
  var stdout: Buffer?

  /**
   * The stderr from the command. Buffered regardless of response format specification.
   */
  var stderr: Buffer?

  /**
   * Handlers (and help, etc.) can choose to append a data object to the response. Not displayed to
   * the console unless response format JSON is specified.
   */
  var data: Any?

  /**
   * Error object automatically appended by the command processor when a handler rejects the
   * promise. Contains the stack and other messages to help diagnosis. Not displayed to the console
   * unless response format JSON is specified.
   */
  var error: IImperativeError?
}
