@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.response

import zowe.imperative.cmd.doc.response.api.handler.*
import kotlin.ts.Readonly

/**
 * Handler command response APIs. Passed to command handlers for console messages, data responses,
 * and progress bars. Handlers can implement their own logging scheme (or use the Imperative.api to
 * obtain an instance of the logger), but handlers should NEVER write directly to the console and
 * should always use the APIs here to construct responses. The HandlerResponse object will
 * automatically handle response formats, etc.
 */
external class HandlerResponse : IHandlerResponseApi {
  /**
   * Creates an instance of HandlerResponse.
   *
   * @param apis The command response object (See class for details) - contains
   *   all the public APIs that the handler should use to formulate responses.
   */
  constructor(apis: CommandResponse)

  /**
   * Returns the instance of the console APIs for the handler. Provides APIs to console messaging
   * (log, error, etc.).
   */
  @Readonly
  override var console: IHandlerResponseConsoleApi

  /**
   * Returns the instance of the data APIs for the handler. Provides APIs for the handlers to
   * formulate their JSON response objects to the command.
   */
  @Readonly
  override var data: IHandlerResponseDataApi

  /**
   * Returns the instance of the progress bar APIs for the handler. Provides methods to start and
   * end progress bars.
   */
  @Readonly
  override var progress: IHandlerProgressApi

  /**
   * Returns the instance of the format APIs for the handler. APIs allow the handler to provide
   * output objects/strings and they will be automatically formatted and printed to the console.
   */
  @Readonly
  override var format: IHandlerFormatOutputApi
}
