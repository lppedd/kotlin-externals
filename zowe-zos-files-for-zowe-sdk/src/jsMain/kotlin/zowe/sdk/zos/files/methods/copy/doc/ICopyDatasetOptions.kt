package zowe.sdk.zos.files.methods.copy.doc

import zowe.sdk.zos.files.doc.IDataSet
import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the copy data set function.
 */
@JsPlainObject
external interface ICopyDatasetOptions : IZosFilesOptions {
  /**
   * The dataset to copy from.
   */
  var `from-dataset`: IDataSet

  /**
   * Enq option
   * Allow values are: SHR, SHRW, EXCLU.
   */
  var enq: String?

  /**
   * Replace option
   */
  var replace: Boolean?
}
