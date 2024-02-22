import { BaseAuthHandler, AbstractSession, ICommandArguments, ISession, SessConstants } from "@zowe/imperative";
/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
export default class ApimlAuthHandler extends BaseAuthHandler {
    /**
     * The profile type where token type and value should be stored
     */
    protected mProfileType: string;
    /**
     * The default token type to use if not specified as a command line option
     */
    protected mDefaultTokenType: SessConstants.TOKEN_TYPE_CHOICES;
    /**
     * The description of your service to be used in CLI prompt messages
     */
    protected mServiceDescription: string;
    /**
     * This is called by the {@link BaseAuthHandler#process} when it needs a
     * session. Should be used to create a session to connect to the auth
     * service.
     * @param {ICommandArguments} args The command line arguments to use for building the session
     * @returns {ISession} The session object built from the command line arguments.
     */
    protected createSessCfgFromArgs: (args: ICommandArguments) => ISession;
    /**
     * This is called by the "auth login" command after it creates a session, to
     * obtain a token that can be stored in a profile.
     * @param {AbstractSession} session The session object to use to connect to the auth service
     * @returns {Promise<string>} The response from the auth service containing a token
     */
    protected doLogin(session: AbstractSession): Promise<string>;
    /**
     * This is called by the "auth logout" command after it creates a session, to
     * revoke a token before removing it from a profile.
     * @param {AbstractSession} session The session object to use to connect to the auth service
     */
    protected doLogout(session: AbstractSession): Promise<void>;
}
