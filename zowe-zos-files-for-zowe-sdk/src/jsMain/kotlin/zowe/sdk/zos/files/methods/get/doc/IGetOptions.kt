package zowe.sdk.zos.files.methods.get.doc

import zowe.sdk.zos.files.doc.IOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent to get a data set or USS file function
 */
@JsPlainObject
external interface IGetOptions : IOptions {
  /**
   * Range of records to return
   */
  var range: String?
}
