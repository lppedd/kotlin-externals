package zowe.sdk.zos.tso.doc.zosmf

/**
 * TSO Message interface for one of TSO/E messages
 */
external interface ITsoMessage {
  /**
   * JSON version for message format
   */
  var VERSION: String

  /**
   * description of the data type
   */
  var DATA: String
}
