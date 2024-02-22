@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.list.registry

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to list registry instances
 */
external class RegistryInstancesHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
