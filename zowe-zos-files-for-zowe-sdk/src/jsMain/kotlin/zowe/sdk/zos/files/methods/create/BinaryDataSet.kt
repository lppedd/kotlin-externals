package zowe.sdk.zos.files.methods.create

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface BinaryDataSet {
  var dsorg: String
  var alcunit: String
  var primary: Int
  var recfm: String
  var blksize: Int
  var lrecl: Int
  var dirblk: Int
}
