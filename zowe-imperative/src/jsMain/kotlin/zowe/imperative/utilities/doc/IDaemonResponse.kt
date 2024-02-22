package zowe.imperative.utilities.doc

import js.objects.Record

/**
 * Option interface to construct response from daemon client
 */
external interface IDaemonResponse {
  /**
   * List of CLI arguments received from the daemon client.
   */
  var argv: Array<String>?

  /**
   * Current working directory received from the daemon client.
   */
  var cwd: String?

  /**
   * Environment variables with CLI prefix received from the daemon client.
   */
  var env: Record<String, String>?

  /**
   * Length of stdin data received from the daemon client. The client sends binary stdin data as a
   * multipart request, that contains a JSON body with `stdinLength` defined, followed by the raw
   * binary data.
   */
  var stdinLength: Int?

  /**
   * Stdin text received from the daemon client. This is used for plain text stdin data like replies
   * to prompts.
   */
  var stdin: String?

  /**
   * The user that initiated the request from the daemon client.
   */
  var user: String?
}
