package zowe.explorer.api.tree

import js.objects.Record
import js.promise.Promise
import vscode.MarkdownString
import vscode.TreeItemLabel
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.Session
import kotlin.ts.Union

/**
 * The base interface for Zowe tree nodes that are implemented by vscode.TreeItem.
 */
external interface IZoweTreeNode {
  /**
   * The icon path or [ThemeIcon](#ThemeIcon) for the tree item.
   */
  // TODO(Edoardo): fix type
  var iconPath:
    (Any /* string | vscode.Uri | { light: string | vscode.Uri; dark: string | vscode.Uri; } | vscode.ThemeIcon */)?

  /**
   * Indicator that the child data may have become stale and requires refreshing.
   */
  var dirty: Boolean

  /**
   *  A human-readable string describing this item.
   */
  var label: Union<String, TreeItemLabel> // string | vscode.TreeItemLabel

  /**
   * A description for this tree item.
   */
  var description: Union<String, Boolean> // string | boolean

  /**
   * A unique identifier for this tree item.
   * Used to prevent VScode from losing track of TreeItems in a TreeProvider.
   */
  var id: String?

  /**
   * The tooltip text when you hover over this item.
   */
  var tooltip: Union<String, MarkdownString>? // string | vscode.MarkdownString | undefined

  /**
   * Describes the full path of a file
   */
  var fullPath: String?

  /**
   * Children nodes of this node
   */
  // TODO(Edoardo): fix overrides
  var children: Array<IZoweTreeNode>?

  /**
   * [vscode.TreeItemCollapsibleState] of the tree item.
   */
  var collapsibleState: vscode.TreeItemCollapsibleState?

  /**
   * Context value of the tree item. This can be used to contribute item specific actions in the tree.
   *
   * This will show action `extension.deleteFolder` only for items with `contextValue` is `folder`.
   */
  var contextValue: String?

  /**
   * Any ongoing actions that must be awaited before continuing
   */
  var ongoingActions: Record<Union<NodeAction, String>, Promise<Any?>>?

  /**
   * whether the node was double-clicked
   */
  var wasDoubleClicked: Boolean?

  /**
   * Sorting method for this node's children
   */
  var sort: NodeSort?

  /**
   * Retrieves the node label
   */
  fun getLabel(): Union<String, TreeItemLabel>

  /**
   * Retrieves the nodes parent node
   */
  fun getParent(): IZoweTreeNode

  /**
   * Retrieves the nodes children nodes
   */
  // TODO(Edoardo): fix overrides
  fun getChildren(): Promise<Array<IZoweTreeNode>>

  /**
   * Retrieves the profile name in use with this node
   */
  fun getProfileName(): String

  /**
   * Retrieves the session node in use with this node
   */
  fun getSessionNode(): IZoweTreeNode

  /**
   * Retrieves the session object in use with this node
   */
  fun getSession(): Session

  /**
   * Retrieves the profile object in use with this node
   */
  fun getProfile(): IProfileLoaded

  /**
   * Set the profile to use for this node to be the one chosen in the parameters
   *
   * @param profileObj The profile you will set the node to use
   */
  fun setProfileToChoice(profileObj: IProfileLoaded)

  /**
   * Set the session to use for this node to be the one chosen in the parameters
   *
   * @param sessionObj The session you will set the node to use
   */
  fun setSessionToChoice(sessionObj: Session)
}
