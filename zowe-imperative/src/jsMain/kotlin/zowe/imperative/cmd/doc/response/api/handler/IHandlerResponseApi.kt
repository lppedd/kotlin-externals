package zowe.imperative.cmd.doc.response.api.handler

import kotlin.js.plain.JsPlainObject

/**
 * The interface to the object passed to command handlers to formulate responses, print messages,
 * etc. in their command processing. Handlers should never write directly to stdout/stderr.
 */
@JsPlainObject
external interface IHandlerResponseApi {
  /**
   * Returns the console API object. Used for writing to stdout and stderr. Also buffers the
   * stdout/stderr messages for population of the ultimate JSON response object.
   */
  var console: IHandlerResponseConsoleApi

  /**
   * The response object is constructed for the purposes of responding to a command with JSON
   * output. The response object houses additional fields and response areas for programmatic API
   * usage of commands.
   */
  var data: IHandlerResponseDataApi

  /**
   * Apis to create and destroy progress bars during the command.
   */
  var progress: IHandlerProgressApi

  /**
   * Format and output data according to the defaults specified (and optional overrides specified by
   * the user). Use when printing/prettifying JSON objects/arrays (it can be used with string data,
   * but string data does not benefit from the auto-formatting options). In conjunction with with ""
   */
  var format: IHandlerFormatOutputApi
}
