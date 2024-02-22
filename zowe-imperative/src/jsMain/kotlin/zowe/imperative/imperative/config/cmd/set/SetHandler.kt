@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.set

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.error.ImperativeError

external class SetHandler : ICommandHandler {
  /**
   * Process the command and input.
   *
   * @param commandParameters Parameters supplied by yargs
   * @throws ImperativeError
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
