@file:JsModule("@zowe/cli")

package zowe.cli.zosconsole.issue.command

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zosmf.ZosmfBaseHandler

/**
 * Handle to issue a MVS console command
 */
external class Handler : ZosmfBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
