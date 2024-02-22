@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import zowe.imperative.rest.session.doc.ISession
import kotlin.js.RegExp

/**
 * The API session object, serves as the base for sessions and contains the fields that are required
 * by most API calls (hostname, port, credentials, etc).
 */
abstract external class AbstractSession {
  /**
   * Creates an instance of AbstractSession.
   *
   * @param mISession Session parameter object
   */
  constructor(mISession: ISession)

  /**
   * Method to parse the requested token type
   *
   * @param cookie cookie object from http(s) response
   */
  fun storeCookie(cookie: Any?)

  /**
   * Obtain session info and defaults
   */
  val ISession: ISession

  companion object {
    /**
     * Basic auth prefix
     */
    val BASIC_PREFIX: String

    /**
     * Bearer auth prefix
     */
    val BEARER_PREFIX: String

    /**
     * Default protocol
     */
    @JsString("https")
    val DEFAULT_PROTOCOL: String

    /**
     * Default session type
     */
    @JsString("none")
    val DEFAULT_TYPE: String

    /**
     * Default http port 80
     */
    @JsInt(80)
    val DEFAULT_HTTP_PORT: Int

    /**
     * Default https port 443
     */
    @JsInt(443)
    val DEFAULT_HTTPS_PORT: Int

    /**
     * Default https port
     */
    @JsInt(443)
    val DEFAULT_PORT: Int

    /**
     * Default base path. Our empty string means that we do **not** use an API mediation layer base
     * path at the beginning of every resource URL.
     */
    @JsString("")
    val DEFAULT_BASE_PATH: String

    /**
     * Default reject unauthorized
     */
    @JsBoolean(true)
    val DEFAULT_REJECT_UNAUTHORIZED_SETTING: Boolean

    /**
     * Default strict ssl setting
     */
    @JsBoolean(true)
    val DEFAULT_STRICT_SSL: Boolean

    /**
     * Default SSL method
     */
    @JsString("SSLv23_method")
    val DEFAULT_SECURE_PROTOCOL: String

    /**
     * Regex to extract basic from base64 encoded auth
     */
    val BASIC: RegExp

    /**
     * Obtain user name from a base 64 credential
     *
     * @param auth base 64 encoded credentials
     * @return user name
     */
    fun getUsernameFromAuth(auth: String): String

    /**
     * Obtain password from a base 64 credential
     *
     * @param auth base 64 encoded credentials
     * @return password
     */
    fun getPasswordFromAuth(auth: String): String

    /**
     * Create base 64 encoded representation of user and password
     *
     * @param user plain text user
     * @param password plain text password
     * @return base 64 encoded auth
     */
    fun getBase64Auth(
      user: String,
      password: String,
    ): String
  }
}
