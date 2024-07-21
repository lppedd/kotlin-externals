package zowe.explorer.api.tree

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DatasetSortOpts {
  companion object {
    @JsIntValue(0)
    val Name: DatasetSortOpts

    @JsIntValue(1)
    val DateCreated: DatasetSortOpts

    @JsIntValue(2)
    val LastModified: DatasetSortOpts

    @JsIntValue(3)
    val UserId: DatasetSortOpts
  }
}
