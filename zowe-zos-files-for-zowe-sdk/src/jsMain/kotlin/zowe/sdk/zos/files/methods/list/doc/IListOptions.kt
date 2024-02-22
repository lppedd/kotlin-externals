package zowe.sdk.zos.files.methods.list.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.types.ZosmfMigratedRecallOptions
import kotlin.js.plain.JsPlainObject

/**
 * This interface defines the options that can be sent into the dwanload data set function
 */
@JsPlainObject
external interface IListOptions : IZosFilesOptions {
  /**
   * The volume where the data set resides
   */
  var volume: String?

  /**
   * The indicator that we want to show more attributes
   */
  var attributes: Boolean?

  /**
   * The indicator that we want to show less data sets or members
   */
  var maxLength: Int?

  /**
   * An optional search parameter that specifies the first data set name to return in the response document
   */
  var start: String?

  /**
   * An optional parameter that specifies how to handle migrated data sets
   */
  var recall: ZosmfMigratedRecallOptions?

  /**
   * An optional pattern for restricting the response list
   */
  var pattern: String?
}
