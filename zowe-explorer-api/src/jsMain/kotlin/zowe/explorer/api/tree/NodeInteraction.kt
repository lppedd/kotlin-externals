@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.tree

import js.date.Date

/**
 * Contains a node that was recently interacted with,
 * as well as a timestamp for when that interaction occurred.
 */
external class NodeInteraction {
  var node: IZoweTreeNode?
  var date: Date?
}
