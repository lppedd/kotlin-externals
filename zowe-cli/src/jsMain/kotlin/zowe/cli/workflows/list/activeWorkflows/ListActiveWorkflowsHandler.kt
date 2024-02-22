@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.activeWorkflows

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Common Handler for listing active workflow(s) instance(s) in z/OSMF.
 */
external class ListActiveWorkflowsHandler : ZosmfBaseHandler {
  /**
   * Handler process - invoked by the command processor to handle the "zos-workflows list"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
