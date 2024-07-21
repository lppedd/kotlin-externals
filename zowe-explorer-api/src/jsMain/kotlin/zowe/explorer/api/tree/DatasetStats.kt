package zowe.explorer.api.tree

import js.date.Date

external interface DatasetStats {
  var user: String
  var createdDate: Date
  var modifiedDate: Date
}
