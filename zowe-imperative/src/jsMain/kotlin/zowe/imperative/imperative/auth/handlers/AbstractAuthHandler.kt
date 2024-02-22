@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.auth.handlers

import js.array.JsTuple2
import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.imperative.auth.doc.IAuthHandlerApi
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.TokenTypeChoices
import zowe.imperative.rest.session.doc.IOptionsForAddConnProps
import zowe.imperative.rest.session.doc.ISession

/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
abstract external class AbstractAuthHandler : ICommandHandler {
  /**
   * The profile type where token type and value should be stored
   */
  open var mProfileType: String

  /**
   * The default token type to use if not specified as a command line option
   */
  open var mDefaultTokenType: TokenTypeChoices

  /**
   * The description of your service to be used in CLI prompt messages
   */
  open var mServiceDescription: String?

  /**
   * This handler is used for both "auth login" and "auth logout" commands. It determines the
   * correct action to take and calls either `processLogin` or `processLogout` accordingly.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * This is called by the "config secure" handler when it needs to prompt for connection info to
   * obtain an auth token.
   *
   * @return A tuple containing:
   *   - Options for adding connection properties
   *   - The login handler
   */
  @Deprecated("Use getAuthHandlerApi instead")
  open fun getPromptParams(): JsTuple2<IOptionsForAddConnProps, (session: AbstractSession) -> Promise<String>>

  /**
   * Returns auth handler API that provides convenient functions to create a session from args, and
   * use it to login or logout of an auth service.
   */
  open fun getAuthHandlerApi(): IAuthHandlerApi

  /**
   * This is called by the [AbstractAuthHandler.process] when it needs a session. Should be
   * used to create a session to connect to the auth service.
   *
   * @param args The command line arguments to use for building the session
   * @return The session object built from the command line arguments.
   */
  open fun createSessCfgFromArgs(args: ICommandArguments): ISession

  /**
   * Performs the login operation and stores the new token in the profile.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  open fun processLogin(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * Performs the logout operation and deletes the old token from the profile.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  open fun processLogout(commandParameters: IHandlerParameters): Promise<Unit>
}
