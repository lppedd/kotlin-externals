@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.rest.session.doc.IOptionsForAddConnProps
import zowe.imperative.rest.session.doc.ISession
import kotlin.ts.Union

/**
 * This class adds connection information to an existing session configuration object for making
 * REST API calls with the Imperative RestClient.
 */
external class ConnectionPropsForSessCfg {
  companion object {
    /**
     * Create a REST session configuration object starting with the supplied initialSessCfg and
     * retrieving connection properties from the command line arguments (or environment, or
     * profile). If required connection properties are missing we interactively prompt the user for
     * the values. for any of the following properties: host port user name password
     *
     * Any prompt will timeout after 30 seconds so that this function can be run from an automated
     * script, and will not indefinitely hang that script.
     *
     * In addition to properties that we prompt for, we will also add the following properties to
     * the session configuration if they are available. type tokenType tokenValue
     *
     * @param initialSessCfg An initial session configuration (like ISession, or other specially
     *   defined configuration) that contains your desired session configuration properties.
     * @param cmdArgs The arguments specified by the user on the command line (or in environment, or
     *   in profile). The contents of the supplied cmdArgs will be modified.
     * @param connOpts Options that alter our connection actions. See IOptionsForAddConnProps. The
     *   connOpts parameter need not be supplied.
     * @return A session configuration object with connection information added to the
     *   initialSessCfg. Its intended use is for our caller to create a session for a REST Client.
     *
     * Example:
     * ```
     * // Within the process() function of a command handler,
     * // do steps similar to the following:
     * const sessCfg: ISession = {
     *   rejectUnauthorized: commandParameters.arguments.rejectUnauthorized,
     *   basePath: commandParameters.arguments.basePath
     * };
     * const connectableSessCfg = await ConnectionPropsForSessCfg.addPropsOrPrompt<ISession>(
     *   sessCfg,
     *   commandParameters.arguments
     * );
     * mySession = new Session(connectableSessCfg);
     * ``
     */
    fun <SessCfgType : ISession> addPropsOrPrompt(
      initialSessCfg: SessCfgType,
      cmdArgs: ICommandArguments,
      connOpts: IOptionsForAddConnProps = definedExternally,
    ): Promise<SessCfgType>

    /**
     * Resolve the overlapping or mutually exclusive properties that can occur. Ensure that the
     * resulting session configuration object contains only the applicable properties. The contents
     * of the supplied sessCfg, cmdArgs, and connOpts will be modified.
     *
     * @param sessCfg An initial session configuration that contains your desired session
     *   configuration properties.
     * @param cmdArgs The arguments specified by the user on the command line (or in environment, or
     *   in profile)
     * @param connOpts Options that alter our actions. See IOptionsForAddConnProps. The connOpts
     *   parameter need not be supplied. The only option values used by this function are:
     *   connOpts.requestToken connOpts.defaultTokenType
     *
     * Example:
     * ```
     * let sessCfg = YouCollectAllProfilePropertiesRelatedToSession();
     * let cmdArgs = YouSetPropertiesRequiredInCmdArgs();
     * ConnectionPropsForSessCfg.resolveSessCfgProps(sessCfg, cmdArgs);
     * sessionToUse = new Session(sessCfg);
     * ```
     */
    fun <SessCfgType : ISession> resolveSessCfgProps(
      sessCfg: SessCfgType,
      cmdArgs: ICommandArguments = definedExternally,
      connOpts: IOptionsForAddConnProps = definedExternally,
    )

    /**
     * Confirm whether the given session has a credentials.
     *
     * @param sessToTest the session to be confirmed.
     * @return true is the session has credentials. false otherwise.
     */
    fun sessHasCreds(sessToTest: ISession): Union<String, Boolean>
  }
}
