package zowe.sdk.console.doc.zosmf

/**
 * z/OSMF synchronous console command response messages. See the z/OSMF REST API publication for complete details.
 */
external interface IZosmfIssueResponse {
  /**
   * Follow-up response URL.
   */
  /* "cmd-response-url"?: string; */
  // TODO(Edoardo): how to do this?

  /**
   * Command response text.
   */
  /* "cmd-response": string; */

  /**
   * The follow-up response URI.
   */
  /* "cmd-response-uri"?: string; */

  /**
   * The command response key used for follow-up requests.
   */
  /* "cmd-response-key"?: string; */

  /**
   * True if the solicited keyword requested is present.
   */
  /* "sol-key-detected"?: boolean; */
}
