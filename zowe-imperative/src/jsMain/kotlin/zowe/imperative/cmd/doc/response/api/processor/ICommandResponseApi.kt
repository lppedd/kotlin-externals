package zowe.imperative.cmd.doc.response.api.processor

import zowe.imperative.cmd.doc.response.response.ICommandResponse
import zowe.imperative.error.doc.IImperativeError

/**
 * Interface for the internal command processor response object, hides the fields that are required
 * to fully build the response from the handlers.
 */
external interface ICommandResponseApi {
  /**
   * Returns the response format that the object was constructed with - indicates how the output
   * should be handled if response format is JSON, then data is buffered until the end and output at
   * that time.
   *
   * @return The response format for this command.
   */
  var responseFormat: CommandResponseFormat

  /**
   * If true, indicates that silent mode is enabled (no output whatsoever is produced by the
   * response object)
   */
  var silent: Boolean

  /**
   * Sets the command success property to false, indicating that the command has failed. Command
   * failure is indicated by the handler rejecting its promise.
   */
  fun failed()

  /**
   * Sets the command success property to true, indicating that the command has succeeded. Command
   * success is indicated by the handler fulfilling its promise.
   */
  fun succeeded()

  /**
   * If the command is rejected, this will automatically be populated with all the error details
   * from the Imperative Error object.
   *
   * @param details
   */
  fun setError(details: IImperativeError)

  /**
   * Returns the formed JSON response from the command.
   *
   * @return The fully formed JSON response object from the command.
   */
  fun buildJsonResponse(): ICommandResponse

  /**
   * Writes the command response object to the console. Always written to stdout.
   */
  fun writeJsonResponse(): ICommandResponse

  /**
   * End any outstanding progress bars.
   */
  fun endProgressBar()
}
