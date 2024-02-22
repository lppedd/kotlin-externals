@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import web.url.URL
import zowe.imperative.rest.session.doc.ISession

/**
 * Non-abstract session class
 */
external class Session : AbstractSession {
  /**
   * Creates an instance of Session.
   *
   * @param newSession contains input for new session
   * @memberof Session
   */
  constructor(newSession: ISession)

  companion object {
    /**
     * Creates an instance of Session from a URL object.
     *
     * @param url URL object from the Node.js `url` library
     * @param includePath Specifies whether session base path should be populated.
     *   Default value is true.
     */
    fun createFromUrl(
      url: URL,
      includePath: Boolean = definedExternally,
    ): Session
  }
}
