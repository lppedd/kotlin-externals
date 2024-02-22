@file:JsModule("@zowe/cli")

package zowe.cli.zoslogs.list.logs

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handle to get logs from z/OSMF restful api
 */
external class LogsHandler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
