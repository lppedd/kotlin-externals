package zowe.sdk.console.doc

import zowe.imperative.error.ImperativeError
import zowe.sdk.console.doc.zosmf.IZosmfIssueResponse

/**
 * The Console API response.
 */
external interface IConsoleResponse {
  /**
   * True if the command was issued and the responses were collected.
   */
  var success: Boolean

  /**
   * The list of zOSMF console API responses. May issue multiple requests (because of user request) or
   * to ensure that all messages are collected. Each individual response is placed here.
   */
  var zosmfResponse: Array<IZosmfIssueResponse>

  /**
   * If an error occurs, returns the ImperativeError, which contains casue error.
   */
  var failureResponse: ImperativeError?

  /**
   * The command response text.
   */
  var commandResponse: String

  /**
   * The final command response key - used to "follow-up" and check for additional response messages for the command.
   */
  var lastResponseKey: String?

  /**
   * If the solicited keyword is specified, indicates that the keyword was detected.
   */
  var keywordDetected: Boolean?

  /**
   * The "follow-up" command response URL - you can paste this in the browser to do a "GET" using the command
   * response key provided in the URI route.
   */
  var cmdResponseUrl: String?
}
