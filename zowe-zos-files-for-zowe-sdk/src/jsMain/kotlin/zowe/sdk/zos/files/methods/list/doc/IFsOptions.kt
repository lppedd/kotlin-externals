package zowe.sdk.zos.files.methods.list.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the zfs function
 */
@JsPlainObject
external interface IFsOptions : IZosFilesOptions {
  /**
   * Specifies the path where the file system is mounted
   */
  var path: String?

  /**
   * Specifies the name of the mounted file system
   */
  var fsname: String?

  /**
   * Specifies the maximum number of items to return
   */
  var maxLength: Int?
}
