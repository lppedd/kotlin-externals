package zowe.imperative.rest.client.doc

import zowe.imperative.error.doc.IImperativeError
import kotlin.js.plain.JsPlainObject

/**
 * REST client error interface. Extends IImperativeError to provide additional details specified to
 * REST/HTTP errors.
 */
@JsPlainObject
external interface IRestClientError : IImperativeError {
  /**
   * The HTTP status code from the request. Might not be populated if a "client" error occurred
   * (e.g. ECONNREFUSED).
   */
  var httpStatus: Int?

  /**
   * The "errno" provided from the Node.js http interface. when client.on("error") is invoked.
   */
  var errno: String?

  /**
   * The hostname supplied on the session object.
   */
  var host: String?

  /**
   * The syscall provided from the Node.js http interface when client.on("error") is invoked.
   * Usually accompanied by an "errno".
   */
  var syscall: String?

  /**
   * The protocol used to connect to the remote host. Specified on the session object.
   */
  var protocol: String?

  /**
   * The port number of the remote host. Specified on the session object.
   */
  var port: Int?

  /**
   * The "base path" for the URI. Specified on the session object.
   */
  var basePath: String?

  /**
   * The URI or resource of the request being made.
   */
  var resource: String?

  /**
   * Any HTTP headers added to the request.
   */
  var headers: Array<Any?>?

  /**
   * The request payload.
   */
  var payload: Any?

  /**
   * The HTTP method/verb (e.g. PUT)
   */
  var request: String?

  /**
   * The error "source". Indicates where the error occurred in the REST client. "client" indicates
   * that the error occurred before the request to the remote system could be fulfilled (normally
   * due to network, bad host/port, etc.). "http" indicates that a non-OK HTTP status code was
   * presented.
   */
  var source: RestErrorSource
}
