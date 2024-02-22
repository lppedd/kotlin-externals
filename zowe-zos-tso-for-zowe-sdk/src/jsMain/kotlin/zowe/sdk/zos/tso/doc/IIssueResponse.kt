package zowe.sdk.zos.tso.doc

import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * The TsoSend API response.
 */
external interface IIssueResponse {
  /**
   * True if the command was issued and the responses were collected.
   */
  var success: Boolean

  /**
   * zOSMF start TSO API response.
   */
  var startResponse: IStartStopResponses

  /**
   * Indicates if started TSO containes "READY " message
   */
  var startReady: Boolean

  /**
   * zOSMF stop TSO API response.
   */
  var stopResponse: IStartStopResponse

  /**
   * The list of zOSMF send API responses. May issue multiple requests or
   * to ensure that all messages are collected. Each individual response is placed here.
   */
  var zosmfResponse: Array<IZosmfTsoResponse>

  /**
   * The command response text.
   */
  var commandResponse: String
}
