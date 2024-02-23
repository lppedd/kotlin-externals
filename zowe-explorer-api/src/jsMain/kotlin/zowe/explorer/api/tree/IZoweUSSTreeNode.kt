package zowe.explorer.api.tree

import js.objects.Record
import js.promise.Promise
import zowe.explorer.api.utils.FileAttributes

/**
 * Extended interface for Zowe USS tree nodes.
 */
external interface IZoweUSSTreeNode : IZoweTreeNode {
  /**
   * Retrieves an abridged for of the label
   */
  var shortLabel: String?

  /**
   * List of child nodes downloaded in binary format
   */
  @Deprecated("Use encodingMap instead", ReplaceWith("encodingMap"))
  var binaryFiles: Record<String, Any>?

  /**
   * List of child nodes and user-selected encodings
   */
  var encodingMap: Record<String, ZosEncoding>?

  /**
   * Binary indicator. Default false (text)
   */
  var binary: Boolean?

  /**
   * Specific profile name in use with this node
   */
  @Deprecated("Use getProfileName instead", ReplaceWith("getProfileName"))
  var mProfileName: String?

  /**
   * File attributes
   */
  var attributes: FileAttributes?

  /**
   * Event that fires whenever an existing node is updated.
   */
  var onUpdateEmitter: vscode.EventEmitter<IZoweUSSTreeNode>?

  /**
   * Remote encoding of the data set
   *
   * - `null` = user selected z/OS default codepage
   * - `undefined` = user did not specify
   */
  var encoding: String?

  /**
   * Event that fires whenever an existing node is updated.
   */
  var onUpdate: vscode.Event<IZoweUSSTreeNode>?

  /**
   * Retrieves child nodes of this IZoweUSSTreeNode
   */
  @Suppress("RETURN_TYPE_MISMATCH_ON_OVERRIDE")
  override fun getChildren(): Promise<Array<IZoweUSSTreeNode>>

  /**
   * Retrieves the etag value for the file
   */
  fun getEtag(): String

  /**
   * Sets the etag value for the file
   */
  fun setEtag(etag: String): Any?

  /**
   * Renaming a USS Node. This could be a Favorite Node
   */
  fun rename(newNamePath: String): Any?

  /**
   * Sets the file encoding to binary
   * @param binary true is a binary file otherwise false
   */
  @Deprecated("Use setEncoding instead")
  fun setBinary(binary: Boolean): Any?

  /**
   * Sets the codepage value for the file
   */
  fun setEncoding(encoding: ZosEncoding): Any?

  /**
   * Downloads and displays a file in a text editor view
   *
   * @param download Download the file default false
   * @param previewFile the file, true or false
   * @param ussFileProvider the tree provider
   */
  fun openUSS(
    download: Boolean,
    previewFile: Boolean,
    ussFileProvider: IZoweTree<IZoweUSSTreeNode>,
  ): Promise<Unit>

  /**
   * Returns the local file path for the ZoweUSSNode
   */
  fun getUSSDocumentFilePath(): String

  /**
   * Refreshes the node with current mainframe data
   */
  fun refreshUSS(): Any?

  /**
   *
   * @param ussFileProvider Deletes the USS tree node
   * @param filePath
   * @param cancelled optional
   */
  fun deleteUSSNode(
    ussFileProvider: IZoweTree<IZoweUSSTreeNode>,
    filePath: String,
    cancelled: Boolean = definedExternally,
  ): Any?

  /**
   * Process for renaming a USS Node. This could be a Favorite Node
   *
   * @param ussFileProvider
   * @param filePath
   */
  fun renameUSSNode(
    ussFileProvider: IZoweTree<IZoweUSSTreeNode>,
    filePath: String,
  ): Any?

  /**
   * Refreshes node and reopens it.
   * @param hasClosedInstance
   */
  @Deprecated("Use reopen instead. Will be removed by version 2.0")
  fun refreshAndReopen(hasClosedInstance: Boolean = definedExternally): Any?

  /**
   * Reopens a file if it was closed (e.g. while it was being renamed).
   * @param hasClosedInstance
   */
  fun reopen(hasClosedInstance: Boolean = definedExternally): Any?

  /**
   * Adds a search node to the USS favorites list
   *
   * @param ussFileProvider
   */
  fun saveSearch(ussFileProvider: IZoweTree<IZoweUSSTreeNode>): Any?

  /**
   * uploads selected uss node(s) to from clipboard to mainframe
   */
  @Deprecated("in favor of pasteUssTree")
  fun copyUssFile(): Any?

  /**
   * Uploads a tree of USS file(s)/folder(s) to mainframe
   */
  fun pasteUssTree(): Any?
}
