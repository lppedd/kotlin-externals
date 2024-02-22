package zowe.sdk.zos.files.methods.upload.doc

import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the map option that can be sent into the upload uss directory function
 */
@JsPlainObject
external interface IUploadDir {
  /**
   * directory name
   */
  var dirName: String

  /**
   * full path specification (on local host)
   */
  var fullPath: String
}
