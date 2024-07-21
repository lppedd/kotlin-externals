package zowe.explorer.api.tree

import js.date.Date

external interface PartialDatasetStats {
  var user: String?
  var modifiedDate: Date?
}
