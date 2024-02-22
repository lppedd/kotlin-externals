package zowe.sdk.zos.tso.doc.zosmf

/**
 * The z/OSMF Ping API parameters. See the z/OSMF REST API documentation for full details.
 */
external interface IZosmfPingResponse {
  /**
   * Ping servlet key used text.
   */
  var servletKey: String

  /**
   * Ping version text.
   */
  var ver: String

  /**
   * Ping error message response.
   */
  var msgData: Array<IZosmfMessages>?

  /**
   * Ping reused boolean.
   */
  var reused: Boolean

  /**
   * Ping timeout boolean.
   */
  var timeout: Boolean
}
