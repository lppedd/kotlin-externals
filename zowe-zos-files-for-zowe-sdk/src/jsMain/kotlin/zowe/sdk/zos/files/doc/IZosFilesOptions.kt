package zowe.sdk.zos.files.doc

import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the global options that apply to all zosfiles APIs
 */
@JsPlainObject
external interface IZosFilesOptions {
  /**
   * The maximum amount of time for the TSO servlet to wait for a response before returning an error
   */
  var responseTimeout: Int?
}
