package zowe.sdk.zos.files.methods.hDelete.doc

import zowe.sdk.zos.files.methods.hMigrate.doc.IMigrateOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the delete data set function.
 */
@JsPlainObject
external interface IDeleteOptions : IMigrateOptions {
  /**
   * If true then the function uses the PURGE=YES on ARCHDEL request.
   *
   * If false (default) the function uses the PURGE=NO on ARCHDEL request.
   */
  var purge: Boolean?
}
