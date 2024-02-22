package zowe.sdk.zos.files.methods.download.doc

import js.errors.JsError
import js.objects.Record

/**
 * This interface defines results of the download dir-from-uss command.
 */
external interface IDownloadUssDirResult {
  /**
   * List of file names that have downloaded successfully.
   */
  var downloaded: Array<String>

  /**
   * List of file names that were not downloaded because they already existed on the system.
   */
  var skippedExisting: Array<String>

  /**
   * Object containing key-value pairs of files and errors for uss files that failed to download.
   */
  var failedWithErrors: Record<String, JsError>
}
