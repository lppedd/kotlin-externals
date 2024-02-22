package zowe.sdk.zos.files.methods.upload.doc

import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the map option that can be sent into the upload uss directory function
 */
@JsPlainObject
external interface IUploadFile {
  /**
   * The indicator to upload the data set in binary mode
   */
  var binary: Boolean

  /**
   * File name to be uploaded in binary or ascii
   */
  var fileName: String
}
