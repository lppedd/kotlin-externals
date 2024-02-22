@file:JsModule("@zowe/cli")

package zowe.cli.zostso.send.address_space

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zos.tso.ZosTsoBaseHandler

/**
 * Handler to Send data to TSO address space
 */
external class Handler : ZosTsoBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
