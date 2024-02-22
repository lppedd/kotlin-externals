@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.cmd.showfirststeps

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

/**
 * The firststeps command handler for cli plugin firststeps.
 *
 * @see firststepsDefinition
 */
external class FirststepsHandler : ICommandHandler {
  /**
   * Process the command and input.
   *
   * @param commandParameters Parameters supplied by yargs
   * @param commandParameters.arguments.plugin This is the plugin to show the first steps for.
   * @return The command response
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
