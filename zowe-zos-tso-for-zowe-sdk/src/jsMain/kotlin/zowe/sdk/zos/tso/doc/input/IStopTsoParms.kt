package zowe.sdk.zos.tso.doc.input

/**
 * Interface for TSO stop command z/OSMF parameters
 */
external interface IStopTsoParms {
  /**
   * servlet key of an active address space
   */
  var servletKey: String
}
