@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler that allows creation of a profile from command line arguments. Intended for usage with
 * the automatically generated profile create commands, but can be used otherwise.
 */
external class CreateProfilesHandler : ICommandHandler {
  /**
   * Create a profile from command line arguments.
   *
   * @param commandParameters Standard Imperative command handler parameters - see the interface for full details
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
