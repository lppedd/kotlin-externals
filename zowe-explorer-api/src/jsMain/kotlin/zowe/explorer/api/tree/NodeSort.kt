package zowe.explorer.api.tree

import vscode.Union

external interface NodeSort {
  var method: Union<DatasetSortOpts, JobSortOpts>
  var direction: SortDirection
}
