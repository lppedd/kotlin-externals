package zowe.imperative.imperative.auth.doc

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.rest.session.AbstractSession
import zowe.imperative.rest.session.doc.IOptionsForAddConnProps
import zowe.imperative.rest.session.doc.ISession

/**
 * Auth handler API that provides convenient functions to create a session from args,
 * and use it to login or logout of an auth service.
 */
external interface IAuthHandlerApi {
  /**
   * Prompting options for adding connection properties. The properties `defaultTokenType` and
   * `serviceDescription` should be defined.
   */
  var promptParams: IOptionsForAddConnProps

  /**
   * Method to create a session config object from CLI arguments.
   * This is equivalent to the handler method `createSessCfgFromArgs`.
   */
  var createSessCfg: (args: ICommandArguments) -> ISession

  /**
   * Method to login to authentication service with a session.
   * This is equivalent to the handler method `doLogin`.
   */
  var sessionLogin: (session: AbstractSession) -> Promise<String>

  /**
   * Method to logout of authentication service with a session.
   * This is equivalent to the handler method `doLogout`.
   */
  var sessionLogout: (session: AbstractSession) -> Promise<Unit>
}
