@file:JsModule("@zowe/cli")

package zowe.cli.provisioning.list.catalogTemplates

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handler to list template catalog
 */
external class CatalogTemplatesHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
