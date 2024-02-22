@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.perform.action

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to perform action against instance
 */
external class ActionHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
