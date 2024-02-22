package zowe.imperative.rest.session.doc

import js.objects.Record
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.rest.session.TokenTypeChoices

/**
 * Interface for options supplied to ConnectionPropsForSessCfg.addPropsOrPrompt()
 */
external interface IOptionsForAddConnProps {
  /**
   * Indicates that we want to generate a token. When true, we use the user and password for the
   * operation to obtain a token. This applies during a login command. Otherwise, you typically want
   * this to be false. The default value is false.
   */
  var requestToken: Boolean?

  /**
   * Indicates that want to prompt for user name and password when no form of credentials are
   * supplied. CLI programs typically want this to be true. A GUI app calling the API may do its own
   * prompting in the GUI and would set this value to false. The default value is true.
   */
  var doPrompting: Boolean?

  /**
   * Specifies the default token type if not provided on the command line. Some commands such as
   * "auth login" do not have a "tokenType" command line option, but still need to specify a default
   * token type. The default value is TOKEN_TYPE_JWT.
   */
  var defaultTokenType: TokenTypeChoices?

  /**
   * Specifies a list of authentication properties, and what they should override. If one of these
   * properties is available on the session, do not prompt for the other property.
   */
  var propertyOverrides: Array<IOverridePromptConnProps>?

  /**
   * Specifies the functionality that external applications will use for prompting. Activate this
   * function to get all the needed properties
   *
   * Example:
   * ```
   * const connectableSessCfg = await ConnectionPropsForSessCfg.addPropsOrPrompt<ISession>(
   *   sessCfg,
   *   commandParameters.arguments,
   *   {getValuesBack: YourOwnFunction}
   * );
   * ```
   */
  fun getValuesBack(properties: Array<String>): Record<String, Any>

  /**
   * Specifies full command parameter object if running in a CLI environment (versus) as a Node.js SDK
   */
  var parms: IHandlerParameters?

  /**
   * Specifies the description of your service to be used in CLI prompt messages.
   * If undefined, the default value is "your service".
   */
  var serviceDescription: String?

  /**
   * Specifies if properties that the user was prompted for should be automatically stored in
   * profiles. Defaults to true when team config exists.
   */
  var autoStore: Boolean?
}
