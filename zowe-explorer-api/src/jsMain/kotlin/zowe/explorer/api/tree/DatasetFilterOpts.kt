@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.tree

import seskar.js.JsIntValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DatasetFilterOpts {
  companion object {
    @JsIntValue(0)
    val LastModified: DatasetFilterOpts

    @JsIntValue(1)
    val UserId: DatasetFilterOpts
  }
}
