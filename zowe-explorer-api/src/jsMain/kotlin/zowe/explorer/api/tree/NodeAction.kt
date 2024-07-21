package zowe.explorer.api.tree

import seskar.js.JsValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface NodeAction {
  companion object {
    @JsValue("download")
    val Download: NodeAction
  }
}
