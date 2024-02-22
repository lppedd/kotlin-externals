import { ICommandHandler, IHandlerParameters, ICommandArguments, IHandlerResponseApi } from "../../../../../../cmd";
import { ISession, AbstractSession } from "../../../../../../rest";
import { IConfig } from "../../../../../../config";
/**
 * This class is used by the auto init command handler as the base class for its implementation.
 */
export declare abstract class BaseAutoInitHandler implements ICommandHandler {
    /**
     * The profile type where connection information should be stored
     */
    protected abstract mProfileType: string;
    /**
     * The description of your service to be used in CLI prompt messages
     */
    protected abstract mServiceDescription: string;
    /**
     * The session being created from the command line arguments / profile
     */
    protected mSession: AbstractSession;
    /**
     * This is called by the {@link BaseAuthHandler#process} when it needs a
     * session. Should be used to create a session to connect to the auto-init
     * service.
     * @abstract
     * @param {ICommandArguments} args The command line arguments to use for building the session
     * @returns {ISession} The session object built from the command line arguments.
     */
    protected abstract createSessCfgFromArgs(args: ICommandArguments): ISession;
    /**
     * This handler is used for the "auto-init" command, and calls processAutoInit
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent by imperative.
     *
     * @returns {Promise<void>}
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
    /**
     * This is called by the "auto-init" command after it creates a session, to
     * obtain information that can be used to automatically create a config
     * @abstract
     * @param {AbstractSession} session The session object to use to connect to the auth service
     * @returns {Promise<string>} The response from the auth service containing a token
     */
    protected abstract doAutoInit(session: AbstractSession, params: IHandlerParameters): Promise<IConfig>;
    /**
     * This is called by processAutoInit() to display the report of configuration updates.
     * @abstract
     * @param {IHandlerParameters} params The command line parameters.
     */
    protected abstract displayAutoInitChanges(response: IHandlerResponseApi): void;
    /**
     * Processes the auto init command to the auto init service.
     * Applies the changes to whichever config layer is specified by IHandlerParameters.
     * Can also perform a dry run and display the changes, or open the config for editing.
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     */
    private processAutoInit;
}
