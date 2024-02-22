@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.tree

import vscode.Command
import vscode.Union
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.Session

/**
 * Common implementation of functions and methods associated with the IZoweTreeNode
 */
external class ZoweTreeNode : vscode.TreeItem {
  /**
   * Creates an instance of ZoweDatasetNode
   *
   * @param label Displayed in the TreeView
   * @param collapsibleState file/folder
   * @param mParent
   * @param session
   * @param etag
   */
  constructor (
    label: String,
    collapsibleState: vscode.TreeItemCollapsibleState,
    mParent: IZoweTreeNode,
    session: Session,
    profile: IProfileLoaded,
  )

  constructor (
    label: vscode.TreeItemLabel,
    collapsibleState: vscode.TreeItemCollapsibleState,
    mParent: IZoweTreeNode,
    session: Session,
    profile: IProfileLoaded,
  )

  var session: Session
  var profile: IProfileLoaded
  override var command: Command?
  var fullPath: String
  var dirty: Boolean
  var children: Array<IZoweTreeNode>

  @Deprecated("Define on subclass instead")
  var binaryFiles: Any

  @Deprecated("Define on subclass instead")
  var binary: Boolean

  @Deprecated("Define on subclass instead")
  var shortLabel: String

  /**
   * Retrieves parent node of this IZoweTreeNode
   */
  fun getParent(): IZoweTreeNode

  /**
   * Returns the [Session] for this node
   */
  fun getSession(): Session

  /**
   * Returns the imperative.IProfileLoaded profile for this node
   */
  fun getProfile(): IProfileLoaded

  /**
   * Implements access to profile name
   */
  fun getProfileName(): String

  /**
   * This is the default was that the label should be accessed as it
   * automatically trims the value
   */
  fun getLabel(): Union<String, vscode.TreeItemLabel>

  /**
   * Sets the imperative.IProfileLoaded profile for this node to the one chosen in parameters.
   *
   * @param aProfile The profile you will set the node to use
   */
  fun setProfileToChoice(aProfile: IProfileLoaded)

  /**
   * Sets the session for this node to the one chosen in parameters.
   *
   * @param aSession The session you will set the node to use
   */
  fun setSessionToChoice(aSession: Session)
}
