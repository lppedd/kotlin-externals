@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler for the auto-generated update profile commands Allows the user to simply update an
 * existing configuration profile
 */
external class UpdateProfilesHandler : ICommandHandler {
  /**
   * The process command handler for the "update profile" command.
   *
   * @return The promise to fulfill when complete.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
