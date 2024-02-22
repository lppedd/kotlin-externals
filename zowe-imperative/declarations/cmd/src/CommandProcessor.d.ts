import { ICommandDefinition } from "./doc/ICommandDefinition";
import { ICommandValidatorResponse } from "./doc/response/response/ICommandValidatorResponse";
import { IProfileManagerFactory } from "../../profiles";
import { ICommandProfileTypeConfiguration } from "./doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IHelpGenerator } from "./help/doc/IHelpGenerator";
import { CommandResponse } from "./response/CommandResponse";
import { ICommandResponse } from "./doc/response/response/ICommandResponse";
import { IInvokeCommandParms } from "./doc/parms/IInvokeCommandParms";
import { ICommandProcessorParms } from "./doc/processor/ICommandProcessorParms";
import { ICommandArguments } from "./doc/args/ICommandArguments";
import { Config } from "../../config/src/Config";
/**
 * The command processor for imperative - accepts the command definition for the command being issued (and a pre-built)
 * response object and validates syntax, loads profiles, instantiates handlers, & invokes the handlers.
 * @export
 * @class CommandProcessor
 */
export declare class CommandProcessor {
    /**
     * Show secure fields in the output of the command ENV var suffix
     * @private
     * @static
     * @memberof CommandProcessor
     */
    private static readonly ENV_SHOW_SECURE_SUFFIX;
    /**
     * The error tag for imperative errors.
     * @private
     * @static
     * @type {string}
     * @memberof CommandProcessor
     */
    private static readonly ERROR_TAG;
    /**
     * The root command name of the CLI (specified in the Imperative Configuration document)
     * @private
     * @type {string}
     * @memberof CommandProcessor
     */
    private mCommandRootName;
    /**
     * The command line.
     * @private
     * @type {string}
     * @memberof CommandProcessor
     */
    private mCommandLine;
    /**
     * Environmental variable name prefix used to construct configuration environmental variables.
     * @private
     * @type {string}
     * @memberof CommandProcessor
     */
    private mEnvVariablePrefix;
    /**
     * The phrase used to indicate the user wants to enter the value of an argument in a hidden text prompt
     * @private
     * @type {string}
     * @memberof CommandProcessor
     */
    private mPromptPhrase;
    /**
     * The command definition node for the command being executed.
     * @private
     * @type {ICommandDefinition}
     * @memberof CommandProcessor
     */
    private mDefinition;
    /**
     * The full command definition contains all parents/ancestors of the command being executed.
     * @private
     * @type {ICommandDefinition}
     * @memberof CommandProcessor
     */
    private mFullDefinition;
    /**
     * The help generator to use - normally passed the default generator.
     * @private
     * @type {IHelpGenerator}
     * @memberof CommandProcessor
     */
    private mHelpGenerator;
    /**
     * The profile manager to use when loading profiles for commands
     * @private
     * @type {IProfileManagerFactory<ICommandProfileTypeConfiguration>}
     * @memberof CommandProcessor
     */
    private mProfileManagerFactory;
    /**
     * Imperative Logger instance for logging from the command processor.
     * @private
     * @type {Logger}
     * @memberof CommandProcessor
     */
    private mLogger;
    /**
     * Config object used to load profiles from active config layers.
     * @private
     * @type {Config}
     * @memberof CommandProcessor
     */
    private mConfig;
    /**
     * The context object defined when in daemon mode.
     * @private
     * @type {IDaemonContext}
     * @memberof CommandProcessor
     */
    private mDaemonContext?;
    /**
     * Creates an instance of CommandProcessor.
     * @param {ICommandProcessorParms} params - See the interface for details.
     * @memberof CommandProcessor
     */
    constructor(params: ICommandProcessorParms);
    /**
     * Accessor for the root command name
     * @readonly
     * @type {string}
     * @memberof CommandProcessor
     */
    get rootCommand(): string;
    /**
     * Accessor for the command line
     * @readonly
     * @type {string}
     * @memberof CommandProcessor
     */
    get commandLine(): string;
    /**
     * Accessor for the environment variable prefix
     * @readonly
     * @type {string}
     * @memberof CommandProcessor
     */
    get envVariablePrefix(): string;
    /**
     * Accessor for the prompt phrase
     * @readonly
     * @type {string}
     * @memberof CommandProcessor
     */
    get promptPhrase(): string;
    /**
     * Accessor for the help generator passed to this instance of the command processor
     * @readonly
     * @type {IHelpGenerator}
     * @memberof CommandProcessor
     */
    get helpGenerator(): IHelpGenerator;
    /**
     * Accessor for the app config
     * @readonly
     * @type {Config}
     * @memberof CommandProcessor
     */
    get config(): Config;
    /**
     * Accessor for the profile manager factory in use for this command processor.
     * @readonly
     * @type {IProfileManagerFactory<ICommandProfileTypeConfiguration>}
     * @memberof CommandProcessor
     */
    get profileFactory(): IProfileManagerFactory<ICommandProfileTypeConfiguration>;
    /**
     * Obtain a copy of the command definition
     * @return {ICommandDefinition}: The Bright Commands definition document.
     */
    get definition(): ICommandDefinition;
    /**
     * Obtain a copy of the command definition
     * @return {ICommandDefinition}: The Bright Commands definition document.
     */
    get fullDefinition(): ICommandDefinition;
    /**
     * Generates the help for the command definition passed.
     * @param {CommandResponse} response - The command response object
     * @memberof CommandProcessor
     */
    help(response: CommandResponse): ICommandResponse;
    /**
     * Generates the help for the command definition passed.
     * @param {string} inContext - Name of page for group/command to jump to
     * @param {CommandResponse} response - The command response object
     * @memberof CommandProcessor
     */
    webHelp(inContext: string, response: CommandResponse): ICommandResponse;
    /**
     * Validates the input arguments/options for the command (Performs additional validation outside of what Yargs
     * already provides - ideally, we would like to maintain control over all errors and messages for consistency).
     * @param {ICommandArguments} commandArguments: The input command arguments from the command line.
     * @param {CommandResponse} responseObject: Response object to print.
     * @return {Promise<ICommandValidatorResponse>}: Promise to be fulfilled when validation is complete.
     */
    validate(commandArguments: ICommandArguments, responseObject: CommandResponse): Promise<ICommandValidatorResponse>;
    /**
     * Invoke the command handler. Locates and requires the module specified by the command definition document,
     * creates a new object, creates a response object, and invokes the handler. The handler is responsible for
     * fulfilling the promise when complete.
     * @param {IInvokeCommandParms} params - The parameters passed to the invoke function
     * @return {Promise<ICommandResponse>} - The promise that is fulfilled. A rejection if the promise indicates a
     * truly exceptional condition (should not occur).
     */
    invoke(params: IInvokeCommandParms): Promise<ICommandResponse>;
    /**
     * Print parameters in place for --dry-run in effect
     * @private
     * @param {IHandlerParameters} commandParameters
     * @returns
     * @memberof CommandProcessor
     */
    private showInputsOnly;
    /**
     * This function outputs the final help text when a syntax validation occurs
     * in {@link CommandProcessor#invoke}
     *
     * @param params   The parameters passed to {@link CommandProcessor#invoke}
     * @param response The response object to output information to.
     */
    private invalidSyntaxNotification;
    /**
     * Prepare for command execution. Actions such as reading stdin, auto-loading profiles, etc. will occur here before
     * the command handler is invoked.
     * @param {CommandResponse} response: The response object for command messaging.
     * @param {yargs.Arguments} commandArguments: The arguments specified on the command line.
     * @return {Promise<CommandResponse>}: Promise to fulfill when complete.
     */
    private prepare;
    /**
     * Internal accessor for the logger instance.
     * @readonly
     * @private
     * @type {Logger}
     * @memberof CommandProcessor
     */
    private get log();
    /**
     * Build the response object for the command based on the invoke parameters. The command response object is
     * passed to the handlers to allow them to perform console messages, response JSON construction, progress bars, etc.
     * @private
     * @param {IInvokeCommandParms} params
     * @returns {CommandResponse}
     * @memberof CommandProcessor
     */
    private constructResponseObject;
    /**
     * Get stdin stream for the command handler to use. In daemon mode this is
     * a stream of data received from the daemon client. Otherwise it defaults
     * to `process.stdin`.
     * @returns Readable stream containing stdin data
     */
    private getStdinStream;
    /**
     * Attempt to load a handler
     * @param {CommandResponse} response - command response to use to log errors in case of failure
     * @param {string} handlerPath - the specified path to the handler, we will attempt to load this
     * @returns {ICommandHandler}
     */
    private attemptHandlerLoad;
    /**
     * Finish the response by building the response object and optionally outputting the JSON response depending on the
     * modes selected.
     * @private
     * @param {CommandResponse} response
     * @returns {ICommandResponse}
     * @memberof CommandProcessor
     */
    private finishResponse;
    /**
     * Respond to an error encountered when invoking a command handler
     * @param {Error | string} handlerErr - the error that was encountered
     * @param {CommandResponse} response - a response object to print error messages to
     * @param {string}  handlerPath - path to the handler with which an error was encountered
     */
    private handleHandlerError;
}
