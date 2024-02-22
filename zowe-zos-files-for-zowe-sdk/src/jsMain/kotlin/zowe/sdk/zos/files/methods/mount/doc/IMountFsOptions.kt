package zowe.sdk.zos.files.methods.mount.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * Interface for the options to the mount file-system API.
 */
@JsPlainObject
external interface IMountFsOptions : IZosFilesOptions {
  /**
   * The file system type to mount
   */
  // "fs-type"?: string;
  /**
   * The mode for mounting the file system
   */
  var mode: IMountFsMode?
}
