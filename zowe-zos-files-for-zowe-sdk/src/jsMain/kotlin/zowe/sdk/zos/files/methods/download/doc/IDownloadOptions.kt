package zowe.sdk.zos.files.methods.download.doc

import js.objects.Record
import zowe.sdk.zos.files.utils.ZosFilesAttributes
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines options for downloading multiple data sets or USS files
 */
@JsPlainObject
external interface IDownloadOptions : IDownloadSingleOptionsBase {
  /**
   * Exclude data sets that match these DSLEVEL patterns. Any data sets that match
   * this pattern will not be downloaded
   *
   * Example: "ibmuser.**.jcl, ibmuser.rexa.*"
   */
  @Deprecated("Use the List.dataSetsMatchingPattern API to match data sets and exclude patterns")
  var excludePatterns: Array<String>?

  /**
   * Map data set names that match your pattern to the desired extension
   *
   * Example: cpgm=c,asmpgm=asm
   */
  var extensionMap: Record<String, String>?

  /**
   * The maximum REST requests to perform at once
   *
   * Increasing this value results in faster downloads but increases resource consumption
   * on z/OS and risks encountering an error caused
   * by making too many requests at once.
   *
   * Default: 1
   */
  var maxConcurrentRequests: Int?

  /**
   * Indicates if a download operation for multiple files/data sets should fail as soon as the first failure happens.
   *
   * If set to true, the first failure will throw an error and abort the download operation.
   *
   * If set to false, individual download failures will be reported after all other downloads have completed.
   *
   * The default value is true for backward compatibility.
   */
  var failFast: Boolean?

  /**
   * The path to a .zosattributes file used to control file conversion and tagging.
   */
  var attributes: ZosFilesAttributes?

  /**
   * Specifies whether hidden files whose names begin with a dot should be downloaded.
   */
  var includeHidden: Boolean?
}
