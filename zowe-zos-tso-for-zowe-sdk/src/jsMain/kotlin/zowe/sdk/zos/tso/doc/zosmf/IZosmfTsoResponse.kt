package zowe.sdk.zos.tso.doc.zosmf

/**
 * z/OSMF synchronous most tso command response messages. See the z/OSMF REST API publication for complete details.
 */
external interface IZosmfTsoResponse {
  /**
   * unique identifier for the servlet entry
   */
  var servletKey: String

  /**
   * message queue ID
   */
  var queueID: String?

  /**
   * structure version
   */
  var ver: String

  /**
   * reconnected indicator
   */
  var reused: Boolean

  /**
   * timeout indicator
   */
  var timeout: Boolean

  /**
   * z/OSMF messages
   */
  var msgData: Array<IZosmfMessages>?

  /**
   * id of the session
   */
  var sessionID: String?

  /**
   * TSO/E messages that were received during the request
   */
  var tsoData: Array<ITsoMessages>?

  /**
   * application messages
   */
  var appData: String?
}
