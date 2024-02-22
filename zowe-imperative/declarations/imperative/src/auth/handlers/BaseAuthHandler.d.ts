import { IHandlerParameters } from "../../../../cmd";
import { AbstractSession, IOptionsForAddConnProps } from "../../../../rest";
import { AbstractAuthHandler } from "./AbstractAuthHandler";
import { IAuthHandlerApi } from "../doc/IAuthHandlerApi";
/**
 * This class is used by the auth command handlers as the base class for their implementation.
 */
export declare abstract class BaseAuthHandler extends AbstractAuthHandler {
    /**
     * The session being created from the command line arguments / profile
     */
    protected mSession: AbstractSession;
    /**
     * This is called by the "auth login" command after it creates a session, to
     * obtain a token that can be stored in a profile.
     * @abstract
     * @param {AbstractSession} session The session object to use to connect to the auth service
     * @returns {Promise<string>} The response from the auth service containing a token
     */
    protected abstract doLogin(session: AbstractSession): Promise<string>;
    /**
     * This is called by the "auth logout" command after it creates a session, to
     * revoke a token before removing it from a profile.
     * @abstract
     * @param {AbstractSession} session The session object to use to connect to the auth service
     */
    protected abstract doLogout(session: AbstractSession): Promise<void>;
    /**
     * This is called by the "config secure" handler when it needs to prompt
     * for connection info to obtain an auth token.
     * @deprecated Use `getAuthHandlerApi` instead
     * @returns A tuple containing:
     *  - Options for adding connection properties
     *  - The login handler
     */
    getPromptParams(): [IOptionsForAddConnProps, (session: AbstractSession) => Promise<string>];
    /**
     * Returns auth handler API that provides convenient functions to create a
     * session from args, and use it to login or logout of an auth service.
     */
    getAuthHandlerApi(): IAuthHandlerApi;
    /**
     * Performs the login operation. Builds a session to connect to the auth
     * service, sends a login request to it to obtain a token, and stores the
     * resulting token in the profile of type `mProfileType`.
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     */
    protected processLogin(params: IHandlerParameters): Promise<void>;
    private getBaseProfileName;
    private promptForBaseProfile;
    private showToken;
    /**
     * Performs the logout operation. Deletes the token and token type from the profile,
     * and rebuilds the session.
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     */
    protected processLogout(params: IHandlerParameters): Promise<void>;
    private processLoginOld;
    private processLogoutOld;
}
