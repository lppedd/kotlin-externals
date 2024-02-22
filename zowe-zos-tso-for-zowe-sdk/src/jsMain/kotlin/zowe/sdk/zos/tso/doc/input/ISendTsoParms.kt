package zowe.sdk.zos.tso.doc.input

/**
 * Interface for TSO issue command z/OSMF parameters
 */
external interface ISendTsoParms {
  /**
   * Servlet key of an active address space
   */
  var servletKey: String

  /**
   * Data to be sent to the active address space
   */
  var data: String
}
