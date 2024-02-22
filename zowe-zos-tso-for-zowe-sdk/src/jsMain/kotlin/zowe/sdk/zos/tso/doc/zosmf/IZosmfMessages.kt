package zowe.sdk.zos.tso.doc.zosmf

/**
 * The z/OSMF Ping API error message parameters. See the z/OSMF REST API documentation for full details.
 */
external interface IZosmfMessages {
  /**
   * Error message text.
   */
  var messageText: String

  /**
   * Error message text ID.
   */
  var messageId: String

  /**
   * Error message stack trace.
   */
  var stackTrace: String
}
