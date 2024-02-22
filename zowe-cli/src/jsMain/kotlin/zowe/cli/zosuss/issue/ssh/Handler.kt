@file:JsModule("@zowe/cli")

package zowe.cli.zosuss.issue.ssh

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handle to issue an USS ssh command
 */
// TODO(Edoardo): externals for @zowe/zos-uss-for-zowe-sdk
external class Handler /* : SshBaseHandler */ {
  fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>

  fun handleStdout(data: String)
}
