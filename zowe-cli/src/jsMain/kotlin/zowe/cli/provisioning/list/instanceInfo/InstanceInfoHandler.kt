@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.list.instanceInfo

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to list instance info
 */
external class InstanceInfoHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
