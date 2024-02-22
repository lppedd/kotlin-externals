package zowe.sdk.zos.files.methods.create

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface PartitionedDataSet {
  var alcunit: String
  var dsorg: String
  var primary: Int
  var dirblk: Int
  var recfm: String
  var blksize: Int
  var lrecl: Int
}
