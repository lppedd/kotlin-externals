@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.auth.handlers

import js.array.JsTuple2
import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.imperative.auth.doc.IAuthHandlerApi
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.doc.IOptionsForAddConnProps

/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
abstract external class BaseAuthHandler : AbstractAuthHandler {
  /**
   * The session being created from the command line arguments / profile
   */
  open var mSession: AbstractSession

  /**
   * This is called by the "auth login" command after it creates a session, to obtain a token that
   * can be stored in a profile.
   *
   * @param session The session object to use to connect to the auth service
   * @return The response from the auth service containing a token
   */
  open fun doLogin(session: AbstractSession): Promise<String>

  /**
   * This is called by the "auth logout" command after it creates a session, to revoke a token
   * before removing it from a profile.
   *
   * @param session The session object to use to connect to the auth service
   */
  open fun doLogout(session: AbstractSession): Promise<Unit>

  /**
   * This is called by the "config secure" handler when it needs to prompt for connection info to
   * obtain an auth token.
   *
   * @return A tuple containing:
   *   - Options for adding connection properties
   *   - The login handler
   */
  @Deprecated("Use getAuthHandlerApi instead")
  override fun getPromptParams(): JsTuple2<IOptionsForAddConnProps, (AbstractSession) -> Promise<String>>

  /**
   * Returns auth handler API that provides convenient functions to create a session from args, and
   * use it to login or logout of an auth service.
   */
  override fun getAuthHandlerApi(): IAuthHandlerApi

  /**
   * Performs the login operation. Builds a session to connect to the auth service, sends a login
   * request to it to obtain a token, and stores the resulting token in the profile of type
   * `mProfileType`.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun processLogin(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * Performs the logout operation. Deletes the token and token type from the profile, and rebuilds
   * the session.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun processLogout(commandParameters: IHandlerParameters): Promise<Unit>
}
