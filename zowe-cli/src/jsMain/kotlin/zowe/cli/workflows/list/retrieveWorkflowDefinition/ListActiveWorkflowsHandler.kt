@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.retrieveWorkflowDefinition

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Common Handler for retrieving the contents of a z/OSMF workflow definition from a z/OS system.
 */
external class ListActiveWorkflowsHandler : ZosmfBaseHandler {
  /**
   * Handler process - invoked by the command processor to handle the "zos-workflows list"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
