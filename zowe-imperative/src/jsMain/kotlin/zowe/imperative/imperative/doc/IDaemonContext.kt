package zowe.imperative.imperative.doc

import node.net.Socket
import node.stream.Readable
import zowe.imperative.utilities.doc.IDaemonResponse

/**
 * Allow for passing our own "context" / user data to the Imperative parser
 */
external interface IDaemonContext {
  /**
   * Stream to write response to
   */
  var stream: Socket?

  /**
   * Stream to read input from
   */
  var stdinStream: Readable?

  /**
   * Daemon response object from socket client
   */
  var response: IDaemonResponse?
}
