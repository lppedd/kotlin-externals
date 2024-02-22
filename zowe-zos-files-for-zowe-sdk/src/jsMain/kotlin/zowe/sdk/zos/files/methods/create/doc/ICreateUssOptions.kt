package zowe.sdk.zos.files.methods.create.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * Interface for the options to the create uss file or directory API.
 */
@JsPlainObject
external interface ICreateUssOptions : IZosFilesOptions {
  /**
   * The request type
   */
  var type: String

  /**
   * Specifies the file or directory permission bits to be used in creating the file or directory.
   */
  var mode: String?
}
