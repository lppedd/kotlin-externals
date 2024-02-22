@file:JsModule("@zowe/cli")

package zowe.cli.workflows.delete

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Common handler to delete a workflow instance in z/OSMF.
 * This is not something that is intended to be used outside of this npm package.
 */
external class DeleteArchivedCommonHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-workflows delete"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
