@file:JsModule("@zowe/cli")

package zowe.cli.daemon.restart

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler to disable daemon mode.
 */
external class RestartDaemonHandler : ICommandHandler {
  /**
   * Process the disable daemon command and populates the response
   * object as needed.
   *
   * @param commandParameters Parameters supplied by yargs
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
