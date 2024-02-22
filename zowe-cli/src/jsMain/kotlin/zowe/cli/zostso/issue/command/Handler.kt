@file:JsModule("@zowe/cli")

package zowe.cli.zostso.issue.command

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zos.tso.ZosTsoBaseHandler

/**
 * Handler to issue command to TSO address space
 */
external class Handler : ZosTsoBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
