package zowe.explorer.api.profiles

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ValidProfileEnum {
  companion object {
    @JsIntValue(1)
    val UNVERIFIED: ValidProfileEnum

    @JsIntValue(0)
    val VALID: ValidProfileEnum

    @JsIntValue(-1)
    val INVALID: ValidProfileEnum
  }
}
