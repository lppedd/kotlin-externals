@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.tree

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NodeAction {
  companion object {
    @JsValue("download")
    val Download: NodeAction
  }
}
