package zowe.sdk.zos.files.methods.create.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * Interface for the options to the create data-set-vsam API.
 */
@JsPlainObject
external interface ICreateVsamOptions : IZosFilesOptions {
  /**
   * The data set organization
   */
  var dsorg: String?

  /**
   * The unit of space allocation
   */
  var alcunit: String?

  /**
   * The primary space allocation
   */
  var primary: Int?

  /**
   * The secondary space allocation
   */
  var secondary: Int?

  /**
   * The volumes on which to allocate space
   */
  var volumes: String?

  /**
   * The storage class
   */
  var storclass: String?

  /**
   * The management class
   */
  var mgntclass: String?

  /**
   * The data class
   */
  var dataclass: String?

  /**
   * The number of days for which the VSAM cluster will be retained
   */
  var retainFor: Int?

  /**
   * The date until which the VSAM cluster will be retained
   */
  var retainTo: String?

  /**
   * The indicator that we need to show the attributes
   *
   * DO NOT SEND THIS TO ZOSMF
   */
  var showAttributes: Boolean?
}
