@file:JsModule("@zowe/zos-uss-for-zowe-sdk")

package zowe.sdk.uss

import js.promise.Promise

external class Shell {
  companion object {
    @JsString("@@START OF COMMAND@@")
    val startCmdFlag: String

    @JsString("ECONNREFUSED")
    val connRefusedFlag: String

    @JsString("FOTS1668")
    val expiredPasswordFlag: String

    fun executeSsh(
      session: SshSession,
      command: String,
      stdoutHandler: (data: String) -> Unit,
    ): Promise<Any?>

    fun executeSshCwd(
      session: SshSession,
      command: String,
      cwd: String,
      stdoutHandler: (data: String) -> Unit,
    ): Promise<Any?>
  }
}

@JsString("@@START OF COMMAND@@")
@Deprecated("Use Shell.startCmdFlag instead")
external val startCmdFlag: String
