@file:JsModule("@zowe/cli")

package zowe.cli.zosuss.issue.ssh

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.uss.SshBaseHandler

/**
 * Handle to issue an USS ssh command
 */
external class Handler : SshBaseHandler {
  override fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>

  fun handleStdout(data: String)
}
