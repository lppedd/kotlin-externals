@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.list.instanceVariables

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to list instance variables
 */
external class InstanceVariablesHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
