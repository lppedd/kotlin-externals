package zowe.sdk.zos.tso.doc

import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * The TsoSend API response.
 */
external interface ISendResponse {
  /**
   * True if the command was issued and the responses were collected.
   */
  var success: Boolean

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
