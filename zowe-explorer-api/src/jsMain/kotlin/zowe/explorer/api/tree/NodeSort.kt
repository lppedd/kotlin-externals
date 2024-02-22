package zowe.explorer.api.tree

import kotlin.ts.Union

external interface NodeSort {
  var method: Union<DatasetSortOpts, JobSortOpts>
  var direction: SortDirection
}
