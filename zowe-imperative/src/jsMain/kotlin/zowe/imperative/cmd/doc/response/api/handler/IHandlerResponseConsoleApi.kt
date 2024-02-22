package zowe.imperative.cmd.doc.response.api.handler

import js.promise.Promise
import node.buffer.Buffer

/**
 * Handler response API for console messages.
 */
external interface IHandlerResponseConsoleApi {
  /**
   * Write a message to stdout (or buffers in silent/JSON mode).
   * Automatically appends a newline to the message.
   *
   * @param message The message (or format string) to write to stdout.
   * @param values The format string values for substitution/formatting.
   * @return The verbatim message written.
   */
  fun log(
    message: String,
    vararg values: Any?,
  ): String

  fun log(
    message: Buffer,
    vararg values: Any?,
  ): String

  /**
   * Write a message to stderr (or buffers in silent/JSON mode).
   * Automatically appends a newline to the message.
   *
   * @param message The message (or format string) to write to stderr
   * @param values The format string values for substitution/formatting.
   * @return The verbatim message written.
   */
  fun error(
    message: String,
    vararg values: Any?,
  ): String

  fun error(
    message: Buffer,
    vararg values: Any?,
  ): String

  /**
   * Writes an error header to stderr. The header is colorized (to red), appends a colon (e.g.
   * "Syntax Error:"), and a new line. The intention of the error header is to begin an error block
   * of text with a "tag" (the header).
   *
   * @param message The message as the header.
   * @param delimiter The delimiter to print after the message (defaults to ":").
   */
  fun errorHeader(
    message: String,
    delimiter: String = definedExternally,
  ): String

  /**
   * Handles prompting for CLI handlers
   *
   * @param questionText
   * @param opts
   */
  fun prompt(
    questionText: String,
    opts: IPromptOptions = definedExternally,
  ): Promise<String>
}
