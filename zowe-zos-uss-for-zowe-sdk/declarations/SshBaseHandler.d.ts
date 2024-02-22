import { ICommandArguments, ICommandHandler, IHandlerParameters, IProfile, IHandlerResponseConsoleApi, IHandlerFormatOutputApi, IHandlerResponseDataApi, IHandlerProgressApi, IImperativeError } from "@zowe/imperative";
import { SshSession } from "./SshSession";
/**
 * This class is used by the various handlers in the project as the base class for their implementation.
 */
export declare abstract class SshBaseHandler implements ICommandHandler {
    /**
     * The session creating from the command line arguments / profile
     */
    protected mSession: SshSession;
    /**
     * Loaded z/OS SSH profile if needed
     */
    protected mSshProfile: IProfile;
    /**
     * Command line arguments passed
     */
    protected mArguments: ICommandArguments;
    /**
     * Full set of command handler parameters from imperative
     */
    protected mHandlerParams: IHandlerParameters;
    /**
     * This will grab the arguments and create a session before calling the subclass
     * {@link SshBaseHandler#processWithSession} method.
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent by imperative.
     *
     * @returns {Promise<void>}
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
    /**
     * Fail the command with an imperative error
     * @param {IImperativeError} err - the imperative error parameters
     */
    fail(err: IImperativeError): void;
    /**
     * Returns the console interface for the command handler
     * @returns {IHandlerResponseConsoleApi}
     */
    get console(): IHandlerResponseConsoleApi;
    /**
     * Returns the format interface for the command handler
     * @returns {IHandlerFormatOutputApi}
     */
    get format(): IHandlerFormatOutputApi;
    /**
     * Returns the format interface for the command handler
     * @returns {IHandlerResponseDataApi}
     */
    get data(): IHandlerResponseDataApi;
    /**
     * Returns the format interface for the command handler
     * @returns {IHandlerProgressApi}
     */
    get progress(): IHandlerProgressApi;
    /**
     * This is called by the {@link SshBaseHandler#process} after it creates a session.
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent to the handler.
     *
     */
    abstract processCmd(commandParameters: IHandlerParameters): Promise<void>;
}
