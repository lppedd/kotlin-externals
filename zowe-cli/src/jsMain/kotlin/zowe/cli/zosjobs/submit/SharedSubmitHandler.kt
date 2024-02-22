@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs.submit

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * "zos-jobs submit data-set" command handler. Submits a job (JCL) contained within a z/OS data set (PS or PDS member).
 */
external class SharedSubmitHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-jobs submit data-set"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
