package zowe.sdk.zos.files.methods.create.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions
import kotlin.js.plain.JsPlainObject

/**
 * Interface for create dataset API
 *  zOSMF REST API information:
 *    https://www.ibm.com/support/knowledgecenter/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_CreateDataSet.htm#CreateDataSet
 */
@JsPlainObject
external interface ICreateDataSetOptions : IZosFilesOptions {
  /**
   * The volume serial
   */
  var volser: String?

  /**
   * The device type
   */
  var unit: String?

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
  var primary: Int

  /**
   * The secondary space allocation
   */
  var secondary: Int?

  /**
   * The number of directory blocks
   */
  var dirblk: Int?

  /**
   * The average block
   */
  var avgblk: Int?

  /**
   * The record format
   */
  var recfm: String?

  /**
   * The block size
   */
  var blksize: Int?

  /**
   * The record length
   */
  var lrecl: Int

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
   * The data set type
   */
  var dsntype: String?

  /**
   * The indicator that we need to show the attributes
   *
   * DO NOT SEND THIS TO ZOSMF
   */
  var showAttributes: Boolean?

  /**
   * The abstraction of Allocation unit and Primary Space
   *
   * DO NOT SEND THIS TO ZOSMF
   */
  var size: String?
}
