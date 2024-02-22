package zowe.sdk.zos.files.methods.list.doc

import zowe.sdk.zos.files.doc.IZosFilesOptions

/**
 * This interface defines the information that is stored in the download data set API return object
 */
external interface IZosmfListResponse : IZosFilesOptions {
  /**
   * The name of the dataset
   */
  var dsname: String

  /**
   * The block size of the dataset
   */
  var blksz: String?

  /**
   * The catalog in which the dataset entry is stored
   */
  var catnm: String?

  /**
   * The dataset creation date
   */
  var cdate: String?

  /**
   * The type of the device the dataset is stored on
   */
  var dev: String?

  /**
   * The type of the dataset
   */
  var dsntp: String?

  /**
   * The organization of the data set as physical sequential (PS), partitioned (PO), or direct (DA)
   */
  var dsorg: String?

  /**
   * The dataset expiration date
   */
  var edate: String?

  /**
   * The number of extensions the dataset has
   */
  var extx: String?

  /**
   * The length, in bytes, of each record in the data set
   */
  var lrecl: String?

  /**
   * Indicates if automatic migration to a lower level of storage is active for this dataset
   */
  var migr: String?

  /**
   * Indicates if the dataset is multivolume
   */
  var mvol: String?

  /**
   * Open virtualization format
   */
  var ovf: String?

  /**
   * The date of the last time the dataset was referred to
   */
  var rdate: String?

  /**
   * The record format of the dataset
   */
  var recfm: String?

  /**
   * The size of the first extent in tracks
   */
  var sizex: String?

  /**
   * The type of space units measurement
   */
  var spacu: String?

  /**
   * The percentage of used space in the dataset
   */
  var used: String?

  /**
   * The volume name on which the dataset is stored
   */
  var vol: String
}
