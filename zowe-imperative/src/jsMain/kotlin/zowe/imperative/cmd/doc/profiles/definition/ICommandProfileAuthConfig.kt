package zowe.imperative.cmd.doc.profiles.definition

import zowe.imperative.cmd.doc.IPartialCommandDefinition
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ICommandProfileAuthConfig {
  /**
   * Name of the authentication service
   */
  var serviceName: String

  /**
   * Path to the handler for the authentication service.
   * The handler should inherit from Imperative BaseAuthHandler.
   */
  var handler: String

  /**
   * Command properties for `auth login <serviceName>`
   */
  var login: IPartialCommandDefinition?

  /**
   * Command properties for `auth logout <serviceName>`
   */
  var logout: IPartialCommandDefinition?
}
