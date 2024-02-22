package zowe.cli.zosfiles.edit

import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * A class to hold pertinent information about the local file during the editing process
 */
external interface ILocalFile {
  var tempPath: String?
  var fileName: String
  var fileType: EditFileType
  var guiAvail: Boolean
  var zosResp: IZosFilesResponse<Any?>?
  var conflict: Boolean
  var encoding: String?
  var binary: Boolean?
}
