package zowe.sdk.zos.files.doc

/**
 * This interface defines the information that is stored in the download data set API return object
 */
external interface IUSSFileListResponse {
  /**
   * The name of the dataset
   */
  var name: String

  /**
   * The block size of the dataset
   */
  var mode: String?

  /**
   * The catalog in which the dataset entry is stored
   */
  var size: String?

  /**
   * The dataset creation date
   */
  var uid: String?

  /**
   * The type of the device the dataset is stored on
   */
  var user: String?

  /**
   * The type of the dataset
   */
  var gid: String?
}
