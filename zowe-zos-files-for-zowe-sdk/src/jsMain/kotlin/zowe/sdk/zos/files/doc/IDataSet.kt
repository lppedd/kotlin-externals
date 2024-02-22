package zowe.sdk.zos.files.doc

import kotlin.js.plain.JsPlainObject

/**
 * Interface for data sets
 */
@JsPlainObject
external interface IDataSet {
  /**
   * The name of the data set
   */
  var dsn: String

  /**
   * The name of the member
   */
  var member: String?
}
