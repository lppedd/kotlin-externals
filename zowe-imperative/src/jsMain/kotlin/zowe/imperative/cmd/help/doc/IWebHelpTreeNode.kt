package zowe.imperative.cmd.help.doc

import kotlin.js.plain.JsPlainObject

/**
 * Recursive object containing data for a node of web help command tree
 */
@JsPlainObject
external interface IWebHelpTreeNode {
  /**
   * Name of HTML file corresponding to the node
   */
  var id: String

  /**
   * Display name for the node which includes full name and aliases
   */
  var text: String

  /**
   * List of child nodes
   */
  var children: Array<IWebHelpTreeNode>?
}
