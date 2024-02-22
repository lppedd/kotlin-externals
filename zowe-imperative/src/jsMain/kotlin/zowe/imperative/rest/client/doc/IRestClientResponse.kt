package zowe.imperative.rest.client.doc

import node.buffer.Buffer
import zowe.imperative.logger.Logger
import zowe.imperative.rest.session.Session
import kotlin.js.plain.JsPlainObject

/**
 * Interface to map client's REST call response
 */
@JsPlainObject
external interface IRestClientResponse {
  /**
   * Status whether a REST request was successful by HTTP status code
   */
  var requestSuccess: Boolean?

  /**
   * Status whether a REST request was successful by HTTP status code Reverse of
   * requestSuccess
   */
  var requestFailure: Boolean?

  /**
   * Http(s) response body as a buffer
   */
  var data: Buffer?

  /**
   * Http(s) response body as a string
   */
  var dataString: String?

  /**
   * Http(s) response object
   */
  var response: Any?

  /**
   * Session object
   */
  var session: Session?

  /**
   * Logger object
   */
  var log: Logger?
}
