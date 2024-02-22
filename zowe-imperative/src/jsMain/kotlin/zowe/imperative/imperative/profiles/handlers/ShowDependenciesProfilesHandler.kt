@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler for the auto-generated show dependencies command
 */
external class ShowDependenciesProfilesHandler : ICommandHandler {
  /**
   * The process command handler for the "show dependencies" command.
   *
   * @return The promise to fulfill when complete.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
