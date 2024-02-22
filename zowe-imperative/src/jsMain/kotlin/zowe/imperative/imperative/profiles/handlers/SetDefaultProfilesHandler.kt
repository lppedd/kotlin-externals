@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler for the auto generated commands to set the default profile for a type The default profile
 * is loaded when no specific profile name is specified
 */
external class SetDefaultProfilesHandler : ICommandHandler {
  /**
   * process the set default profile command arguments
   *
   * @return The promise to fulfill when complete.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
