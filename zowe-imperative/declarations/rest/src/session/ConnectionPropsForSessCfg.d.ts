import { ICommandArguments } from "../../../cmd";
import { IOptionsForAddConnProps } from "./doc/IOptionsForAddConnProps";
import { ISession } from "./doc/ISession";
/**
 * This class adds connection information to an existing session configuration
 * object for making REST API calls with the Imperative RestClient.
 */
export declare class ConnectionPropsForSessCfg {
    /**
     * Create a REST session configuration object starting with the supplied
     * initialSessCfg and retrieving connection properties from the command
     * line arguments (or environment, or profile). If required connection
     * properties are missing we interactively prompt the user for the values.
     * for any of the following properties:
     *      host
     *      port
     *      user name
     *      password
     *
     * Any prompt will timeout after 30 seconds so that this function can
     * be run from an automated script, and will not indefinitely hang that
     * script.
     *
     * In addition to properties that we prompt for, we will also add the following
     * properties to the session configuration if they are available.
     *      type
     *      tokenType
     *      tokenValue
     *
     * @param initialSessCfg
     *        An initial session configuration (like ISession, or other
     *        specially defined configuration) that contains your desired
     *        session configuration properties.
     *
     * @param cmdArgs
     *        The arguments specified by the user on the command line
     *        (or in environment, or in profile). The contents of the
     *        supplied cmdArgs will be modified.
     *
     * @param connOpts
     *        Options that alter our connection actions. See IOptionsForAddConnProps.
     *        The connOpts parameter need not be supplied.
     *
     * @example
     *      // Within the process() function of a command handler,
     *      // do steps similar to the following:
     *      const sessCfg: ISession =  {
     *          rejectUnauthorized: commandParameters.arguments.rejectUnauthorized,
     *          basePath: commandParameters.arguments.basePath
     *      };
     *      const connectableSessCfg = await ConnectionPropsForSessCfg.addPropsOrPrompt<ISession>(
     *           sessCfg, commandParameters.arguments
     *      );
     *      mySession = new Session(connectableSessCfg);
     *
     * @returns A session configuration object with connection information
     *          added to the initialSessCfg. Its intended use is for our
     *          caller to create a session for a REST Client.
     */
    static addPropsOrPrompt<SessCfgType extends ISession>(initialSessCfg: SessCfgType, cmdArgs: ICommandArguments, connOpts?: IOptionsForAddConnProps): Promise<SessCfgType>;
    /**
     * Resolve the overlapping or mutually exclusive properties that can
     * occur. Ensure that the resulting session configuration object contains
     * only the applicable properties. The contents of the supplied sessCfg,
     * cmdArgs, and connOpts will be modified.
     *
     * @param sessCfg
     *      An initial session configuration that contains your desired
     *      session configuration properties.
     *
     * @param cmdArgs
     *      The arguments specified by the user on the command line
     *      (or in environment, or in profile)
     *
     * @param connOpts
     *      Options that alter our actions. See IOptionsForAddConnProps.
     *      The connOpts parameter need not be supplied.
     *      The only option values used by this function are:
     *          connOpts.requestToken
     *          connOpts.defaultTokenType
     *
     * @example
     *      let sessCfg = YouCollectAllProfilePropertiesRelatedToSession();
     *      let cmdArgs = YouSetPropertiesRequiredInCmdArgs();
     *      ConnectionPropsForSessCfg.resolveSessCfgProps(sessCfg, cmdArgs);
     *      sessionToUse = new Session(sessCfg);
     */
    static resolveSessCfgProps<SessCfgType extends ISession>(sessCfg: SessCfgType, cmdArgs?: ICommandArguments, connOpts?: IOptionsForAddConnProps): void;
    /**
     * Confirm whether the given session has a credentials.
     *
     * @param sessToTest
     *       the session to be confirmed.
     *
     * @returns true is the session has credentials. false otherwise.
     */
    static sessHasCreds(sessToTest: ISession): string | boolean;
    /**
     * List of properties on `sessCfg` object that should be kept secret and
     * may not appear in Imperative log files.
     *
     * NOTE(Kelosky): redundant from LoggerUtils.SECURE_PROMPT_OPTIONS - leaving
     * for future date to consolidate
     */
    private static secureSessCfgProps;
    /**
     * List of prompt messages that is used when the CLI prompts for session
     * config values.
     */
    private static readonly promptTextForValues;
    /**
     * Prompts the user to input session config values in a CLI environment.
     * This is the default implementation of the `getValuesBack` callback when
     * `connOpts.doPrompting` is true.
     * @param connOpts Options for adding connection properties
     * @returns Name-value pairs of connection properties
     */
    private static getValuesBack;
    /**
     * Handle prompting for clients.  If in a CLI environment, use the IHandlerParameters.response
     * object prompt method.
     * @private
     * @static
     * @param {string} promptText
     * @param {IHandlePromptOptions} opts
     * @returns {Promise<string>}
     * @memberof ConnectionPropsForSessCfg
     */
    private static clientPrompt;
    /**
     * Determine if we want to request a token.
     * Set the session's type and tokenType accordingly.
     *
     * @param sessCfg
     *       The session configuration to be updated.
     *
     * @param options
     *       Options that alter our actions. See IOptionsForAddConnProps.
     *
     * @param tokenType
     *       The type of token that we expect to receive.
     */
    private static setTypeForTokenRequest;
    /**
     * Log the session configuration that resulted from the addition of
     * credentials. Hide the password.
     *
     * @param sessCfg
     *       The session configuration to be logged.
     */
    private static logSessCfg;
    /**
     * Confirm whether the specified property has a value.
     *
     * @param propToTest
     *       the property key to be confirmed.
     *
     * @returns true is the property exists and has a value. false otherwise.
     */
    private static propHasValue;
    /**
     * Load base profile property schema for connection properties.
     * @param params CLI handler parameters object
     * @param promptForValues List of ISessCfg properties to prompt for
     * @returns Key-value pairs of ISessCfg property name and profile property schema
     */
    private static loadSchemaForSessCfgProps;
    /**
     * Load list of secure property names defined in team config.
     * @param params CLI handler parameters object
     * @param promptForValues List of ISessCfg properties to prompt for
     */
    private static loadSecureSessCfgProps;
}
