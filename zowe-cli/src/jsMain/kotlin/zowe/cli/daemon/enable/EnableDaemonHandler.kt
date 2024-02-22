@file:JsModule("@zowe/cli")

package zowe.cli.daemon.enable

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

/**
 * Handler to enable daemon mode.
 */
external class EnableDaemonHandler : ICommandHandler {
  /**
   * Process the enable daemon command and populates the response
   * object as needed.
   *
   * @param commandParameters Parameters supplied by yargs
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
