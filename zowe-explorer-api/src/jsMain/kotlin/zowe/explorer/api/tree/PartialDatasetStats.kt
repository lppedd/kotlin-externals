package zowe.explorer.api.tree

import kotlin.js.Date

external interface PartialDatasetStats {
  var user: String?
  var modifiedDate: Date?
}
