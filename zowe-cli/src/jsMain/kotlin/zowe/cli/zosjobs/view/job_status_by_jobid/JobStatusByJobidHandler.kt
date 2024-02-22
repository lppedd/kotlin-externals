@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.view.job_status_by_jobid

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * "zos-jobs view job-status-by-jobid" command handler. Outputs details regarding a z/OS job.
 */
external class JobStatusByJobidHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-jobs view job-status-by-jobid"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
