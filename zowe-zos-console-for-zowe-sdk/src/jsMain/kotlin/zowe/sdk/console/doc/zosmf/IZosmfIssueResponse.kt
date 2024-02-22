package zowe.sdk.console.doc.zosmf

/**
 * z/OSMF synchronous console command response messages. See the z/OSMF REST API publication for complete details.
 */
external interface IZosmfIssueResponse {
  /**
   * Follow-up response URL.
   */
  var `cmd-response-url`: String?

  /**
   * Command response text.
   */
  var `cmd-response`: String

  /**
   * The follow-up response URI.
   */
  var `cmd-response-uri`: String?

  /**
   * The command response key used for follow-up requests.
   */
  var `cmd-response-key`: String?

  /**
   * True if the solicited keyword requested is present.
   */
  var `sol-key-detected`: Boolean?
}
