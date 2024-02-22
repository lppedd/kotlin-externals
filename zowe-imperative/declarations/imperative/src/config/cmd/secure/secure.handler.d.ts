import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
export default class SecureHandler implements ICommandHandler {
    /**
     * The parameters object passed to the command handler.
     */
    private params;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Checks if authentication service is associated with an auth token
     * property. If an auth service is found, we log in to it obtain the token
     * instead of prompting for the value.
     * @param config Team config class from which the property was loaded
     * @param propPath JSON property path of the auth token
     * @returns Token value, or undefined if none was obtained
     */
    private handlePromptForAuthToken;
}
