package zowe.sdk.zos.files.methods.delete.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the delete data set function.
 */
@JsPlainObject
external interface IDeleteDatasetOptions : IZosFilesOptions {
  /**
   * The volume where the data set resides.
   */
  var volume: String?
}
