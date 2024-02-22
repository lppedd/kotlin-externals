@file:JsModule("@zowe/cli")

package zowe.cli.auth

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.imperative.auth.handlers.BaseAuthHandler
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.TokenTypeChoices
import zowe.imperative.rest.session.doc.ISession

/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
external class ApimlAuthHandler : BaseAuthHandler {
  /**
   * The profile type where token type and value should be stored
   */
  override var mProfileType: String

  /**
   * The default token type to use if not specified as a command line option
   */
  override var mDefaultTokenType: TokenTypeChoices

  /**
   * The description of your service to be used in CLI prompt messages
   */
  override var mServiceDescription: String?

  /**
   * This is called by the [BaseAuthHandler.process] when it needs a
   * session. Should be used to create a session to connect to the auth
   * service.
   * @param args The command line arguments to use for building the session
   * @return The session object built from the command line arguments.
   */
  var createSessCfgFromArgs: (args: ICommandArguments) -> ISession

  /**
   * This is called by the "auth login" command after it creates a session, to
   * obtain a token that can be stored in a profile.
   * @param session The session object to use to connect to the auth service
   * @return The response from the auth service containing a token
   */
  override fun doLogin(session: AbstractSession): Promise<String>

  /**
   * This is called by the "auth logout" command after it creates a session, to
   * revoke a token before removing it from a profile.
   * @param session The session object to use to connect to the auth service
   */
  override fun doLogout(session: AbstractSession): Promise<Unit>
}
