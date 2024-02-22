package zowe.imperative.rest.client.doc

import node.stream.Readable
import node.stream.Writable
import zowe.imperative.operations.doc.ITaskWithStatus
import zowe.imperative.rest.client.types.HttpVerb

/**
 * Interface to define input for AbstractRestClient.request method
 */
external interface IRestOptions {
  /**
   * URI for this request
   */
  var resource: String

  /**
   * REST request type GET|PUT|POST|DELETE
   */
  var request: HttpVerb

  /**
   * Headers to include with request
   */
  var reqHeaders: Array<Any?>?

  /**
   * Data to write on this REST request
   */
  var writeData: Any?

  /**
   * Stream for incoming response data from the server. If specified, response data will not be
   * buffered
   */
  var responseStream: Writable?

  /**
   * Stream for outgoing request data to the server
   */
  var requestStream: Readable?

  /**
   * true if you want newlines to be \r\n on windows when receiving data from the server to
   * responseStream. Don't set this for binary responses
   */
  var normalizeResponseNewLines: Boolean?

  /**
   * true if you want \r\n to be replaced with \n when sending data to the server from
   * requestStream. Don't set this for binary requests
   */
  var normalizeRequestNewLines: Boolean?

  /**
   * Task that will automatically be updated to report progress of upload or download to user
   */
  var task: ITaskWithStatus?
}
