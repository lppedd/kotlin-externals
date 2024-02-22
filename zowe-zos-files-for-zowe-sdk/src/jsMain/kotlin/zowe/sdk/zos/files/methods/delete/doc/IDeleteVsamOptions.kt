package zowe.sdk.zos.files.methods.delete.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines a few optional options that can be sent on a VSAM
 * delete operation.
 */
@JsPlainObject
external interface IDeleteVsamOptions : IZosFilesOptions {
  /**
   * Specifies the data component of a cluster is to be
   * overwritten with binary zeros when the cluster is deleted.
   */
  var erase: Boolean?

  /**
   * Specifies the entry is to be deleted even if the retention period,
   * specified in the TO or FOR operand, has not expired.
   */
  var purge: Boolean?
}
