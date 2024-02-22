package zowe.imperative.cmd.doc.profiles.definition

import zowe.imperative.cmd.doc.IPartialCommandDefinition
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ICommandProfileAutoInitConfig {
  /**
   * Path to the handler for the authentication service.
   * The handler should inherit from Imperative BaseAuthHandler.
   */
  var handler: String

  /**
   * The provider giving connection information and details for the automatically generated config
   */
  var provider: String

  /**
   * Command properties for `config auto-init`
   */
  var autoInit: IPartialCommandDefinition?

  /**
   * The type of profile associated with the provider, if any
   */
  var profileType: String?
}
