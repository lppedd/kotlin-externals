package zowe.explorer.api.tree

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SortDirection {
  companion object {
    @JsIntValue(0)
    val Ascending: SortDirection

    @JsIntValue(1)
    val Descending: SortDirection
  }
}
