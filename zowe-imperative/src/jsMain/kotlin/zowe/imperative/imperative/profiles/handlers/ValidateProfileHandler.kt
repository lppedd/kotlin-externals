@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Generic handler for validating a profile and printing a report in response
 */
external class ValidateProfileHandler : ICommandHandler {
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
