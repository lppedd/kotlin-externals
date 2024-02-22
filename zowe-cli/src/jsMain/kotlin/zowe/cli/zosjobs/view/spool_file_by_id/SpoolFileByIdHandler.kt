@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.view.spool_file_by_id

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * "zos-jobs view spool-by-id" command handler. Outputs a single spool DD contents.
 */
external class SpoolFileByIdHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-jobs view job"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
