@file:JsModule("@zowe/cli")

package zowe.cli.daemon.disable

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

/**
 * Handler to disable daemon mode.
 */
external class DisableDaemonHandler : ICommandHandler {
  /**
   * Process the disable daemon command and populates the response
   * object as needed.
   *
   * @param commandParameters Parameters supplied by yargs
   *
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
