package zowe.explorer.api.logger

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface MessageSeverity {
  companion object {
    @JsIntValue(0)
    val TRACE: MessageSeverity

    @JsIntValue(1)
    val DEBUG: MessageSeverity

    @JsIntValue(2)
    val INFO: MessageSeverity

    @JsIntValue(3)
    val WARN: MessageSeverity

    @JsIntValue(4)
    val ERROR: MessageSeverity

    @JsIntValue(5)
    val FATAL: MessageSeverity
  }
}
