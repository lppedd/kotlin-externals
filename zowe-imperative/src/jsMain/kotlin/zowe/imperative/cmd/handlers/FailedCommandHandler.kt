@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler used to respond to unexpected errors
 */
external class FailedCommandHandler : ICommandHandler {
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
