@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.tree

import seskar.js.JsIntValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DatasetSortOpts {
  companion object {
    @JsIntValue(0)
    val Name: DatasetSortOpts

    @JsIntValue(1)
    val LastModified: DatasetSortOpts

    @JsIntValue(2)
    val UserId: DatasetSortOpts
  }
}
