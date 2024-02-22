package zowe.sdk.zos.files.doc

import zowe.imperative.operations.doc.ITaskWithStatus
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent to get a data set or USS file function
 */
@JsPlainObject
external interface IOptions : IZosFilesOptions {
  /**
   * The indicator to view the data set or USS file in binary mode
   *
   * Has priority over record for datasets
   *
   * If binary and record are both specified, binary is used
   */
  var binary: Boolean?

  /**
   * The indicator to view the data set in record mode
   *
   * Should not be specified for USS files
   *
   * If binary and record are both specified, binary is used
   */
  var record: Boolean?

  /**
   * Code page encoding
   */
  var encoding: String?

  /**
   * The local file encoding to pass as a "Content-Type" header
   */
  var localEncoding: String?

  /**
   * The volume on which the data set is stored
   */
  var volume: String?

  /**
   * Task status object used by CLI handlers to create progress bars
   *
   * Optional
   */
  var task: ITaskWithStatus?
}
