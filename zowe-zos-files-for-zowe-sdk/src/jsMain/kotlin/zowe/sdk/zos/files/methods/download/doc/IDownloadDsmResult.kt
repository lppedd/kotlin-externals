package zowe.sdk.zos.files.methods.download.doc

import js.errors.JsError
import js.objects.Record

/**
 * This interface defines results of the download data sets matching command.
 */
external interface IDownloadDsmResult {
  /**
   * List of data set names that have downloaded successfully.
   */
  var downloaded: Array<String>

  /**
   * List of data set names that failed to download because they are archived.
   */
  var failedArchived: Array<String>

  /**
   * List of data set names that failed to download because they are an
   * unsupported type.
   */
  var failedUnsupported: Array<String>

  /**
   * Object containing key-value pairs of data set names and errors for data
   * sets that failed to download.
   */
  var failedWithErrors: Record<String, JsError>
}
