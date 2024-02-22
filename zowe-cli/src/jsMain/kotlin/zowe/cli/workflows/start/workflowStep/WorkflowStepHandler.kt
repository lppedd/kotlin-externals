@file:JsModule("@zowe/cli")

package zowe.cli.workflows.start.workflowStep

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Common handler to start a workflow instance in z/OSMF.
 * This is not something that is intended to be used outside of this npm package.
 */
external class WorkflowStepHandler : ZosmfBaseHandler {
  /**
   * Command handler process - invoked by the command processor to handle the "zos-workflows start workflow-step"
   * @param commandParameters Command handler parameters
   * @return Fulfilled when the command completes successfully OR rejected with imperative error
   */
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
