@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.delete.old_jobs

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * "zos-jobs delete old-jobs" command handler. Delete (purge) multiple jobs in OUTPUT status.
 */
external class OldJobsHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-jobs delete job"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
