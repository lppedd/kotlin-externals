import { ICommandHandler, IHandlerParameters, ICommandArguments } from "../../../../cmd";
import { AbstractSession, IOptionsForAddConnProps, ISession, SessConstants } from "../../../../rest";
import { IAuthHandlerApi } from "../doc/IAuthHandlerApi";
/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
export declare abstract class AbstractAuthHandler implements ICommandHandler {
    /**
     * The profile type where token type and value should be stored
     */
    protected abstract mProfileType: string;
    /**
     * The default token type to use if not specified as a command line option
     */
    protected abstract mDefaultTokenType: SessConstants.TOKEN_TYPE_CHOICES;
    /**
     * The description of your service to be used in CLI prompt messages
     */
    protected mServiceDescription?: string;
    /**
     * This handler is used for both "auth login" and "auth logout" commands.
     * It determines the correct action to take and calls either `processLogin`
     * or `processLogout` accordingly.
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent by imperative.
     *
     * @returns {Promise<void>}
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
    /**
     * This is called by the "config secure" handler when it needs to prompt
     * for connection info to obtain an auth token.
     * @deprecated Use `getAuthHandlerApi` instead
     * @returns A tuple containing:
     *  - Options for adding connection properties
     *  - The login handler
     */
    abstract getPromptParams(): [IOptionsForAddConnProps, (session: AbstractSession) => Promise<string>];
    /**
     * Returns auth handler API that provides convenient functions to create a
     * session from args, and use it to login or logout of an auth service.
     */
    abstract getAuthHandlerApi(): IAuthHandlerApi;
    /**
     * This is called by the {@link AbstractAuthHandler#process} when it needs a
     * session. Should be used to create a session to connect to the auth
     * service.
     * @abstract
     * @param {ICommandArguments} args The command line arguments to use for building the session
     * @returns {ISession} The session object built from the command line arguments.
     */
    protected abstract createSessCfgFromArgs(args: ICommandArguments): ISession;
    /**
     * Performs the login operation and stores the new token in the profile.
     * @abstract
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     */
    protected abstract processLogin(commandParameters: IHandlerParameters): Promise<void>;
    /**
     * Performs the logout operation and deletes the old token from the profile.
     * @abstract
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     */
    protected abstract processLogout(commandParameters: IHandlerParameters): Promise<void>;
}
