package zowe.imperative.rest.session.doc

import zowe.imperative.rest.session.AuthTypeChoices
import zowe.imperative.rest.session.HttpProtocolChoices

/**
 * Session interface for maintaining cookie and protocol information
 */
external interface ISession {
  /**
   * Host to get data from, not including http(s) from a URL, e.g. jsonplaceholder.typicode.com
   */
  var hostname: String?

  /**
   * Port to obtain data from 80 is the default for http 443 is the default 443 for https
   */
  var port: Int?

  /**
   * User name for logging in
   */
  var user: String?

  /**
   * Password
   */
  var password: String?

  /**
   * Currently only HTTPS is supported
   */
  var protocol: HttpProtocolChoices?

  /**
   * The base path (or first part) of the resources that we will access. It is used to specify the
   * first part of the resource in a URL that points to any API mediation layer, gateway, or router
   * used at a site to dispatch web requests to services that are managed by that gateway. It is
   * pre-pended to the resource path of the underlying service. When not supplied, or is an empty
   * string we use the resource path of the underlying service directly.
   */
  var basePath: String?

  /**
   * Type of authentication, none is default "none" - no authorization header is used "basic" - use
   * basic auth for every request "bearer" - use bearer auth for every request. Indicates use token
   * value provided. "token" - use cookie auth for every request. Indicates use token value provided
   * and check for timeout / expiration if not token is provided, basic auth is used and the
   * tokenType is obtained from the cookie header and stored as a token value to be used on
   * subsequent requests
   */
  var type: AuthTypeChoices?

  /**
   * Base 64 encoded authentication materials created by base 64 encoding:
   * Basic <user_name>:<password>
   */
  var base64EncodedAuth: String?

  /**
   * Type of token in `tokenValue`, e.g. LTPA2
   */
  var tokenType: String?

  /**
   * Token value of type `tokenType`
   */
  var tokenValue: String?

  /**
   * The following options map to TLS options available within the node.js TLS APIs, please see the
   * official Node.js documentation for these fields
   */
  var rejectUnauthorized: Boolean?

  /**
   * The file path to the client certificate to use for authentication
   */
  var cert: String?

  /**
   * The file path to the client certificate's key to use for authentication
   */
  var certKey: String?

  /**
   * The passphrase used to access the client certificate, if in PFX format
   */
  var passphrase: String?

  /**
   * todo
   */
  var serverCertificate: String?

  /**
   * see node.js api
   */
  var strictSSL: Boolean?

  /**
   * todo
   */
  var checkServerIdentity: ((host: String, cert: Any) -> Error?)?

  /**
   * Default is SSLv23_method
   */
  var secureProtocol: String?

  /**
   * Decide whether to store a returned cookie. Only applies to certificates for now.
   */
  var storeCookie: Boolean?
}
