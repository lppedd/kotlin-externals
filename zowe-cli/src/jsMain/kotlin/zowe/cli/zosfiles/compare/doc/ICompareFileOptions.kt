@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions

/**
 * These are the options to be used in file comaparison to handle the
 * binary, encoding, record and volumeSerial operations in the comparison process
 */
external interface ICompareFileOptions : IZosFilesOptions {
  var binary: Boolean?
  var encoding: String?
  var record: Boolean?
  var volumeSerial: String?
}
