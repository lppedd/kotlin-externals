@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.response

import node.buffer.Buffer
import zowe.imperative.cmd.doc.response.api.handler.IHandlerFormatOutputApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerProgressApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseConsoleApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseDataApi
import zowe.imperative.cmd.doc.response.api.processor.CommandResponseFormat
import zowe.imperative.cmd.doc.response.api.processor.ICommandResponseApi
import zowe.imperative.cmd.doc.response.parms.ICommandResponseParms
import zowe.imperative.cmd.doc.response.response.ICommandResponse
import zowe.imperative.error.doc.IImperativeError

/**
 * Command response object allocated by the command processor and used to construct the handler
 * response object passed to the command handlers. The response object contains all the methods
 * necessary for a command handler (and the processor) to formulate a command response. Controls
 * buffering of messages and JSON response formats.
 *
 * Instances of this class are only manipulated by the command processor. See "HandlerResponse" for
 * the handler response object.
 */
external class CommandResponse : ICommandResponseApi {
  /**
   * Creates an instance of CommandResponse.
   *
   * @param params See the interface for details.
   */
  constructor(params: ICommandResponseParms = definedExternally)

  val format: IHandlerFormatOutputApi

  /**
   * Accessor for the console API - Handlers will use this API to write console messages.
   */
  val console: IHandlerResponseConsoleApi

  /**
   * Accessor for the data api class - Handlers will use this to construct/influence the response
   * JSON object (data is only displayed to the user if JSON mode is requested).
   */
  val data: IHandlerResponseDataApi

  /**
   * Accessor for the progress bar API - Handlers will use this API to create/destroy command
   * progress bars.
   */
  val progress: IHandlerProgressApi

  /**
   * Accessor for the silent flag - silent indicates that the command produces absolutely no output
   * to the console.
   */
  override var silent: Boolean

  /**
   * Setter for the succeeded flag (sets to false to indicate command failure).
   */
  override fun failed()

  /**
   * Setter for the succeeded flag (sets to true to indicate command success).
   */
  override fun succeeded()

  /**
   * Buffer the message (string or buffer) to the stdout buffer. Used to accumulate messages for
   * different reasons (JSON mode is enabled, etc.).
   *
   * @param data The data/messages to buffer.
   */
  fun bufferStdout(data: Buffer)

  fun bufferStdout(data: String)

  /**
   * Buffer the message (string or buffer) to the stderr buffer. Used to accumulate messages for
   * different reasons (JSON mode is enabled, etc.).
   *
   * @param data The data/messages to buffer.
   */
  fun bufferStderr(data: Buffer)

  fun bufferStderr(data: String)

  /**
   * Setter for the error object in the response - automatically populated by the Command Processor
   * if the handler rejects the handler promise.
   *
   * @param details The error object to place in the response.
   */
  override fun setError(details: IImperativeError)

  /**
   * Returns the JSON response for the command.
   *
   * @return The command JSON response - See the interface for details.
   */
  override fun buildJsonResponse(): ICommandResponse

  /**
   * Writes the JSON response to the console - Done normally by the command processor dependending
   * on the response format specified in the object.
   *
   * @return Returns the constructed response that is written to the console.
   */
  override fun writeJsonResponse(): ICommandResponse

  /**
   * Accessor for the response format - see the type for available options - controls how the
   * response will be presented to the user (JSON format, default, etc.)
   */
  override var responseFormat: CommandResponseFormat

  /**
   * Complete any outstanding progress bars.
   */
  override fun endProgressBar()

  /**
   * Explicitly end a stream
   */
  fun endStream()
}
