package zowe.sdk.zos.files.methods.upload.doc

import zowe.sdk.zos.files.doc.IOptions
import zowe.sdk.zos.files.utils.ZosFilesAttributes
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the upload data set function
 */
@JsPlainObject
external interface IUploadOptions : IOptions {
  /**
   * The migrated recall option
   *
   * Example: "wait, nowait, error"
   */
  var recall: String?

  /**
   * The indicator to upload the directories recursively
   */
  var recursive: Boolean?

  /**
   * The list of files to be uploaded in binary mode
   */
  var binary_files: String?

  /**
   * The list of files to be uploaded in ASCII mode
   */
  var ascii_files: String?

  /**
   * The map of files and their upload mode to be used for binary_files and ascii_files
   */
  var filesMap: IUploadMap?

  /**
   * The ZosFilesAttributes instance describe upload attributes for the files and directories
   */
  var attributes: ZosFilesAttributes?

  /**
   * The maximum REST requests to perform at once
   * Increasing this value results in faster uploads but increases resource consumption
   * on z/OS and risks encountering an error caused
   * by making too many requests at once.
   * Default: 1
   */
  var maxConcurrentRequests: Int?

  /**
   * Etag value to pass to z/OSMF API request.
   * It is used to check if the file was modified on target system before it is updated.
   */
  var etag: String?

  /**
   * The indicator to force return of ETag.
   * If set to 'true' it forces the response to include an "ETag" header, regardless of the size of the response data.
   * If it is not present, the the default is to only send an Etag for data sets smaller than a system determined length,
   * which is at least 8MB.
   */
  var returnEtag: Boolean?

  /**
   * Specifies whether hidden files whose names begin with a dot should be uploaded.
   */
  var includeHidden: Boolean?
}
