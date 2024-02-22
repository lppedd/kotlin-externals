package zowe.explorer.api.tree

import js.objects.Record
import js.promise.Promise

/**
 * Extended interface for Zowe Dataset tree nodes.
 */
external interface IZoweDatasetTreeNode : IZoweTreeNode {
  /**
   * Search criteria for a Dataset search
   */
  var pattern: String?

  /**
   * Search criteria for a Dataset member search
   */
  var memberPattern: String?

  /**
   * Additional statistics about this data set
   */
  var stats: PartialDatasetStats?

  /**
   * Filter method for this data set's children
   */
  var filter: DatasetFilter?

  /**
   * List of child nodes and user-selected encodings
   */
  var encodingMap: Record<String, ZosEncoding>?

  /**
   * Binary indicator. Default false (text)
   */
  var binary: Boolean?

  /**
   * Remote encoding of the data set
   *
   * * `null` = user selected z/OS default codepage
   * * `undefined` = user did not specify
   */
  var encoding: String?

  /**
   * Retrieves child nodes of this IZoweDatasetTreeNode
   *
   * @return Promise<IZoweDatasetTreeNode[]>
   */
  @JsType("Promise<Array<IZoweDatasetTreeNode>>")
  override fun getChildren(): Promise<Array<IZoweTreeNode /* IZoweDatasetTreeNode */>>

  /**
   * Retrieves the etag value for the file
   */
  fun getEtag(): String

  /**
   * Sets the etag value for the file
   */
  fun setEtag(etag: String): Any?

  /**
   * Downloads and displays a file in a text editor view
   *
   * @param download Download the file default false
   * @param previewFile the file, true or false
   * @param datasetFileProvider the tree provider
   */
  fun openDs(
    download: Boolean,
    previewFile: Boolean,
    datasetFileProvider: IZoweTree<IZoweDatasetTreeNode>,
  ): Promise<Unit>

  /**
   * Sets the codepage value for the file
   */
  fun setEncoding(encoding: ZosEncoding): Any?
}
