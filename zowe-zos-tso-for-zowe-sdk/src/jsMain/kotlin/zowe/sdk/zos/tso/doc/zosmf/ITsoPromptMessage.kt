package zowe.sdk.zos.tso.doc.zosmf

/**
 * TSO Prompt interface for one of TSO/E messages
 */
external interface ITsoPromptMessage {
  /**
   * JSON version for message format
   */
  var VERSION: String

  /**
   * description of the data type
   */
  var HIDDEN: String
}
