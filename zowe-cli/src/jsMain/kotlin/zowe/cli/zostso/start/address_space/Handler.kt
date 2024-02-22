@file:JsModule("@zowe/cli")

package zowe.cli.zostso.start.address_space

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zos.tso.ZosTsoBaseHandler

/**
 * Handler to start an address space
 */
external class Handler : ZosTsoBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
