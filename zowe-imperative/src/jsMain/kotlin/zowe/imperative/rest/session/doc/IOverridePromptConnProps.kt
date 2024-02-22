package zowe.imperative.rest.session.doc

import kotlin.js.plain.JsPlainObject

/**
 * Interface for overriding the prompting behavior of ConnectionPropsForSessCfg.addPropsOrPrompt()
 */
@JsPlainObject
external interface IOverridePromptConnProps {
  /**
   * Indicates the session property that should be considered in the prompting logic.
   */
  var propertyName: String

  /**
   * Indicates the CLI argument that should be used to populate the property on the session.
   * If not supplied, uses a CLI argument that matches the session property name.
   */
  var argumentName: String?

  /**
   * Indicates the prompting fields the property should override. For example, if the property should be the preferred method of authentication,
   * then it should override user and password. Then, if the property is on the session, it will not prompt for user and password.
   * Prompting logic is only in place for host, port, user, and password, but cert, certKey, tokenType, and tokenValue may also need
   * to be overridden.
   */
  // TODO(Edoardo): have proper String contants for ISession keys
  var propertiesOverridden: Array<(String /* keyof ISession */)>
}
