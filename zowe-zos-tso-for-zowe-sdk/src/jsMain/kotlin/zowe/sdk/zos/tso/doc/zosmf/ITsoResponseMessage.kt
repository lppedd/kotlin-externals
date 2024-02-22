package zowe.sdk.zos.tso.doc.zosmf

/**
 * TSO Response interface for one of TSO/E messages
 */
external interface ITsoResponseMessage {
  /**
   * JSON version for message format
   */
  var VERSION: String

  /**
   * description of the data type
   */
  var DATA: String
}
