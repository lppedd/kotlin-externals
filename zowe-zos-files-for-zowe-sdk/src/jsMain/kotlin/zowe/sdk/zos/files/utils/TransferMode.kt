package zowe.sdk.zos.files.utils

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TransferMode {
  companion object {
    @JsIntValue(0)
    val BINARY: TransferMode

    @JsIntValue(1)
    val TEXT: TransferMode
  }
}
