@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.cmd.uninstall

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

/**
 * The uninstall command handler for cli plugin install.
 *
 * @see uninstallDefinition
 */
external class UninstallHandler : ICommandHandler {
  /**
   * Process the command and input.
   *
   * @param commandParameters Parameters supplied by yargs
   * @param commandParameters.arguments.plugin This is the plugin to uninstall.
   * @return The command response
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
