package zowe.sdk.zos.files.methods.hMigrate.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the migrate data set function.
 */
@JsPlainObject
external interface IMigrateOptions : IZosFilesOptions {
  /**
   * If true then the function waits for completion of the request.
   *
   * If false (default) the request is queued.
   */
  var wait: Boolean?
}
