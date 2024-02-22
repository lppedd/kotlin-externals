@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * The default command handler for the top level/root command Allows the user to check the version
 * of the package. If they haven't specified --version, the help prints
 */
external class DefaultRootCommandHandler : ICommandHandler {
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
