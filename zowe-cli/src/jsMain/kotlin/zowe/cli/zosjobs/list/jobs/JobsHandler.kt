@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.list.jobs

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler for the "zos-jobs list jobs" command.
 */
external class JobsHandler : ZosmfBaseHandler {
  /**
   * Handler for the "zos-jobs list jobs" command. Produces a tabular list of jobs on spool based on
   * the input parameters.
   * @param commandParameters see interface for details
   * @return promise to fulfill or reject when the command is complete
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
