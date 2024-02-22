@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.archivedWorkflows

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Common Handler for listing archived workflows for a system.
 */
external class ListArchivedWorkflowsHandler : ZosmfBaseHandler {
  /**
   * Handler process - invoked by the command processor to handle the "zos-workflows archived list"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
