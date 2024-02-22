package zowe.sdk.zos.files.methods.download.doc

import zowe.sdk.zos.files.methods.get.doc.IGetOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines options for downloading a single data set or USS file
 */
@JsPlainObject
external interface IDownloadSingleOptionsBase : IGetOptions {
  /**
   * The local file to download the data set to
   *
   * Example: "./path/to/file.txt"
   */
  var file: String?

  /**
   * The extension you want to use for the file
   *
   * Example: .txt, .c
   */
  var extension: String?

  /**
   * The local directory to download all members from a pds
   *
   * Example: "./path/to/dir"
   */
  var directory: String?

  /**
   * The indicator to force return of ETag.
   *
   * If set to 'true' it forces the response to include an "ETag" header, regardless of the size of the response data.
   *
   * If it is not present, the the default is to only send an Etag for data sets smaller than a system determined length,
   * which is at least 8MB.
   */
  var returnEtag: Boolean?

  /**
   * Indicates if the created directories and files use the original letter case, which is for data sets always uppercase.
   *
   * The default value is false for backward compability.
   *
   * If the option "directory" or "file" is provided, this option doesn't have any effect.
   *
   * This option has only effect on automatically generated directories and files.
   */
  var preserveOriginalLetterCase: Boolean?

  /**
   * Specifies whether local files should be overwritten when downloaded.
   */
  var overwrite: Boolean?
}
