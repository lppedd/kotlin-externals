package zowe.sdk.zos.tso.doc.zosmf

/**
 * Interface for TSO/E messages
 */
external interface ITsoMessages {
  /**
   * tso message type of TSO/E messages
   */
  var `TSO MESSAGE`: ITsoMessage?

  /**
   * tso prompt message type of TSO/E messages
   */
  var `TSO PROMPT`: ITsoPromptMessage?

  /**
   * tso response message type of TSO/E messages
   */
  var `TSO RESPONSE`: ITsoResponseMessage?
}
