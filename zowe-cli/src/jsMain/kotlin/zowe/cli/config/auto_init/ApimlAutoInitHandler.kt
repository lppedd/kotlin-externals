@file:JsModule("@zowe/cli")

package zowe.cli.config.auto_init

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi
import zowe.imperative.config.doc.IConfig
import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.auth.handlers.BaseAuthHandler
import zowe.imperative.imperative.config.cmd.auto.init.handlers.BaseAutoInitHandler
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.doc.ISession

/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
external class ApimlAutoInitHandler : BaseAutoInitHandler {
  /**
   * The profile type where token type and value should be stored
   */
  override var mProfileType: String

  /**
   * The description of your service to be used in CLI prompt messages
   */
  override var mServiceDescription: String

  /**
   * This is called by the [BaseAuthHandler.process] when it needs a
   * session. Should be used to create a session to connect to the auto-init
   * service.
   * @param args The command line arguments to use for building the session
   * @return The session object built from the command line arguments.
   */
  var createSessCfgFromArgs: (args: ICommandArguments) -> ISession

  /**
   * This is called by the "auto-init" command after it creates a session, to generate a configuration
   * @param session The session object to use to connect to the configuration service
   * @return The response from the auth service containing a token
   * @throws ImperativeError
   */
  override fun doAutoInit(
    session: AbstractSession,
    params: IHandlerParameters,
  ): Promise<IConfig>

  /**
   * This is called by our processAutoInit() base class function to display the set of actions
   * taken by the auto-init command.
   */
  override fun displayAutoInitChanges(response: IHandlerResponseApi)
}
