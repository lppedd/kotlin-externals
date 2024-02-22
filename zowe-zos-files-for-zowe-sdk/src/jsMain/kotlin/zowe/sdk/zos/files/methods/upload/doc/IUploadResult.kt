package zowe.sdk.zos.files.methods.upload.doc

external interface IUploadResult {
  /**
   * Upload status
   */
  var success: Boolean

  /**
   * Name of input file
   */
  var from: String

  /**
   * Name of data set
   */
  var to: String

  /**
   * Optional, any error encounter while uploading the data
   */
  var error: Any?

  /**
   * Optional, etag set when writing the file
   */
  var etag: String?
}
