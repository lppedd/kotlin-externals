@file:JsModule("@zowe/cli")

package zowe.cli.zosconsole.collect.response

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handle to collect a MVS console command response
 */
external class Handler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
