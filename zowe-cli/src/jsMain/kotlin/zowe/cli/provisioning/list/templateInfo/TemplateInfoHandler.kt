@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.list.templateInfo

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to list template info
 */
external class TemplateInfoHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
