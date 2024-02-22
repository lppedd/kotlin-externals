@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.auto.init.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi
import zowe.imperative.config.doc.IConfig
import zowe.imperative.imperative.auth.handlers.BaseAuthHandler
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.doc.ISession

/**
 * This class is used by the auto init command handler as the base class for its implementation.
 */
abstract external class BaseAutoInitHandler : ICommandHandler {
  /**
   * The profile type where connection information should be stored
   */
  open var mProfileType: String

  /**
   * The description of your service to be used in CLI prompt messages
   */
  open var mServiceDescription: String

  /**
   * The session being created from the command line arguments / profile
   */
  open var mSession: AbstractSession

  /**
   * This is called by the [BaseAuthHandler.process] when it needs a session. Should be used
   * to create a session to connect to the auto-init service.
   *
   * @param args The command line arguments to use for building the session
   * @return The session object built from the command line arguments.
   */
  open fun createSessCfgFromArgs(args: ICommandArguments): ISession

  /**
   * This handler is used for the "auto-init" command, and calls processAutoInit
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * This is called by the "auto-init" command after it creates a session, to obtain information
   * that can be used to automatically create a config
   *
   * @param session The session object to use to connect to the auth service
   * @return The response from the auth service containing a token
   */
  open fun doAutoInit(
    session: AbstractSession,
    params: IHandlerParameters,
  ): Promise<IConfig>

  /**
   * This is called by processAutoInit() to display the report of configuration updates.
   */
  open fun displayAutoInitChanges(response: IHandlerResponseApi)
}
