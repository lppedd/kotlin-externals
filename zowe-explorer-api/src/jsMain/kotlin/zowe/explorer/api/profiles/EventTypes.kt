@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import seskar.js.JsIntValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface EventTypes {
  companion object {
    @JsIntValue(0)
    val CREATE: EventTypes

    @JsIntValue(1)
    val UPDATE: EventTypes

    @JsIntValue(2)
    val DELETE: EventTypes
  }
}
