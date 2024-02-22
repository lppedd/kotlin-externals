package zowe.explorer.api.tree

import kotlin.js.Date

external interface DatasetStats {
  var user: String
  var modifiedDate: Date
}
