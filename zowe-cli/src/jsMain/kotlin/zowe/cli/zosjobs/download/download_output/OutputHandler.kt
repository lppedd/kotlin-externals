@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.download.download_output

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * "zos-jobs download output" command handler. Download each spool DD to a separate file.
 */
external class OutputHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-jobs download output"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
