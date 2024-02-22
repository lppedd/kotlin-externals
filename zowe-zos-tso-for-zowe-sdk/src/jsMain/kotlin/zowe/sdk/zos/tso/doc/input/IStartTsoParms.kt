package zowe.sdk.zos.tso.doc.input

/**
 * Interface for TSO start command z/OSMF parameters
 */
external interface IStartTsoParms {
  /**
   * name of the logonProcedure for address space
   */
  var logonProcedure: String?

  /**
   * character set for address space
   */
  var characterSet: String?

  /**
   * code page for tso address space
   */
  var codePage: String?

  /**
   * number of rows
   */
  var rows: String?

  /**
   * number of columns
   */
  var columns: String?

  /**
   * user account number
   */
  var account: String?

  /**
   * region size for address space
   */
  var regionSize: String?
}
