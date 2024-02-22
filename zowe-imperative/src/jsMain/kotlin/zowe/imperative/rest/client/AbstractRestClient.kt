@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import js.errors.JsError
import js.promise.Promise
import node.buffer.Buffer
import node.stream.Readable
import node.stream.Writable
import zowe.imperative.error.doc.IImperativeError
import zowe.imperative.interfaces.types.ImperativeReject
import zowe.imperative.logger.Logger
import zowe.imperative.operations.doc.ITaskWithStatus
import zowe.imperative.rest.client.doc.IRestOptions
import zowe.imperative.rest.client.types.HttpVerb
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.Session

/**
 * Class to handle http(s) requests, build headers, collect data, report status codes, and header
 * responses and passes control to session object for maintaining connection information (tokens,
 * checking for timeout, etc...)
 */
abstract external class AbstractRestClient {
  /**
   * Creates an instance of AbstractRestClient.
   *
   * @param mSession representing connection to this api
   */
  constructor(mSession: AbstractSession)

  /**
   * Contains REST chucks
   */
  var mChunks: Array<Buffer>

  /**
   * Contains buffered data after all REST chucks are received
   */
  var mData: Buffer

  /**
   * Instance of logger
   */
  var mLogger: Logger

  /**
   * Resolved when all data has been obtained
   */
  var mResolve: RestClientResolve

  /**
   * Reject for errors when obtaining data
   */
  var mReject: ImperativeReject

  /**
   * Contain response from http(s) request
   */
  var mResponse: Any?

  /**
   * If we get a response containing a Content-Length header, it is saved here
   */
  var mContentLength: Int

  /**
   * If we get a response containing a Content-Encoding header, and it matches an encoding type that
   * we recognize, it is saved here
   */
  var mContentEncoding: ContentEncoding

  /**
   * Indicates if payload data is JSON to be stringified before writing
   */
  var mIsJson: Boolean

  /**
   * Indicates if request data should have its newlines normalized to /n before sending each chunk
   * to the server
   */
  var mNormalizeRequestNewlines: Boolean

  /**
   * Indicates if response data should have its newlines normalized for the current platform (\r\n
   * for windows, otherwise \n)
   */
  var mNormalizeResponseNewlines: Boolean

  /**
   * Save resource
   */
  var mResource: String

  /**
   * Save request
   */
  var mRequest: HttpVerb

  /**
   * Save req headers
   */
  var mReqHeaders: Array<Any?>

  /**
   * Save write data
   */
  var mWriteData: Any?

  /**
   * Stream for incoming response data from the server.
   * If specified, response data will not be buffered
   */
  var mResponseStream: Writable

  /**
   * Stream for outgoing request data to the server
   */
  var mRequestStream: Readable

  /**
   * Task used to display progress bars or other user feedback mechanisms Automatically updated if
   * task is specified and streams are provided for upload/download
   */
  var mTask: ITaskWithStatus

  /**
   * Bytes received from the server response so far
   */
  var mBytesReceived: Int

  /**
   * Whether or not to try and decode any encoded response
   */
  var mDecode: Boolean

  /**
   * Last byte received when response is being streamed
   */
  var lastByteReceived: Byte

  /**
   * Perform the actual http REST call with appropriate user input
   *
   * @param options
   * @throws JsError if the request gets a status code outside the 200 range or other connection problems
   *   occur (e.g. connection refused)
   */
  fun request(options: IRestOptions): Promise<String>

  /**
   * Append specific headers for all requests by overriding this implementation
   *
   * @param headers list of headers
   * @return completed list of headers
   */
  open fun appendHeaders(headers: Array<Any?>?): Array<Any?>

  /**
   * Process and customize errors encountered in your client. This is called any time an error is
   * thrown from a failed Rest request using this client. error before receiving any response body
   * from the API. You can use this, for example, to set the error tag for you client or add
   * additional details to the error message. If you return null or undefined, Imperative will use
   * the default error generated for your failed request.
   *
   * @param error the error encountered by the client
   * @return the error with the fields set the way you want them
   */
  open fun processError(error: IImperativeError): IImperativeError

  /**
   * Return whether a REST request was successful by HTTP status code
   */
  val requestSuccess: Boolean

  /**
   * Return whether a REST request was successful by HTTP status code
   */
  val requestFailure: Boolean

  /**
   * Return http(s) response body as a buffer
   */
  val data: Buffer

  /**
   * Return http(s) response body as a string
   */
  val dataString: String

  /**
   * Return http(s) response object
   */
  val response: Any?

  /**
   * Return this session object
   */
  val session: Session

  /**
   * Return the logger object for ease of reference
   */
  open val log: Logger
}
