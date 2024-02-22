@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.cmd.validate

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

/**
 * The validate command handler for the cli plugin validate command.
 *
 * @see validateDefinition
 */
external class ValidateHandler : ICommandHandler {
  /**
   * Process the command and input.
   *
   * @param commandParameters Parameters supplied by yargs
   * @param commandParameters.arguments.plugin The name of a plugin to validate.
   *   If omitted all installed plugins will be validated.
   * @return The command response
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
