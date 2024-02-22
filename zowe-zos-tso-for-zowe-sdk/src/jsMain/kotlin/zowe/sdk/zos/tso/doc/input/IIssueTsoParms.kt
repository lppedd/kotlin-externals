package zowe.sdk.zos.tso.doc.input

/**
 * Interface for TSO issue command z/OSMF parameters
 */
external interface IIssueTsoParms {
  /**
   * Command text to issue to the TSO address space.
   */
  var command: String

  /**
   * Accounting info for Jobs
   */
  var accountNumber: String

  /**
   * Interface for TSO start command z/OSMF parameters
   */
  var startParams: IStartTsoParms
}
