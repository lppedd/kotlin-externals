package zowe.sdk.zos.files.methods.download.doc

import node.stream.Writable
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines options for downloading a single data set or USS file
 */
@JsPlainObject
external interface IDownloadSingleOptions : IDownloadSingleOptionsBase {
  /**
   * Optional stream to read the file contents
   */
  var stream: Writable?
}
