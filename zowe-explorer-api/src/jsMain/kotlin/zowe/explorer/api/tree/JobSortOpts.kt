package zowe.explorer.api.tree

import seskar.js.JsIntValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface JobSortOpts {
  companion object {
    @JsIntValue(0)
    val Id: JobSortOpts

    @JsIntValue(1)
    val DateSubmitted: JobSortOpts

    @JsIntValue(2)
    val Name: JobSortOpts

    @JsIntValue(3)
    val ReturnCode: JobSortOpts
  }
}
