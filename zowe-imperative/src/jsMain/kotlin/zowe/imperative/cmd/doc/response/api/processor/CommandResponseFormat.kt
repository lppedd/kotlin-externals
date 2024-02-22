@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.doc.response.api.processor

/**
 * The command response format type definition - currently only JSON or default (stdout/stderr) are
 * supported.
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommandResponseFormat {
  companion object {
    @seskar.js.JsValue("json")
    val json: CommandResponseFormat

    @seskar.js.JsValue("default")
    val default: CommandResponseFormat
  }
}
