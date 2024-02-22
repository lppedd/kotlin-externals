import { Arguments, Argv } from "yargs";
import { Logger } from "../../../logger";
import { ICommandDefinition } from "../doc/ICommandDefinition";
import { IYargsParms } from "./doc/IYargsParms";
import { ICommandResponseParms } from "../../../cmd/src/doc/response/parms/ICommandResponseParms";
import { ImperativeYargsCommandAction, IYargsResponse } from "./doc/IYargsResponse";
import { GroupCommandYargs } from "./GroupCommandYargs";
import { IProfileManagerFactory } from "../../../profiles";
import { IHelpGeneratorFactory } from "../help/doc/IHelpGeneratorFactory";
import { ICommandResponse } from "../../src/doc/response/response/ICommandResponse";
/**
 * Callback that is invoked when a command defined to yargs completes execution.
 */
export declare type YargsCommandCompleted = (args: Arguments, response: IYargsResponse) => void;
/**
 * Abstract Yargs Bright Command - Contains base methods for defining commands and groups
 */
export declare abstract class AbstractCommandYargs {
    protected yargsParms: IYargsParms;
    /**
     * TODO: REMOVE THIS, workaround for yargs.fail() problem
     * @type {boolean}
     */
    static STOP_YARGS: boolean;
    protected log: Logger;
    /**
     * The command definition document
     */
    private mDefinition;
    /**
     * The Yargs parent object - used to obtain parent handlers.
     */
    private mParent;
    /**
     * The Yargs instance to define the command.
     */
    private mYargsInstance;
    /**
     * Command response parameters - controls command response processing when help and command handlers are invoked
     */
    private mCommandResponseParms;
    /**
     * The help generator factory for creating help generators for the commands
     */
    private mHelpGeneratorFactory;
    /**
     * Profile manager factory (for creating managers of certain types)
     * @private
     * @type {IProfileManagerFactory<any>}
     * @memberof AbstractCommandYargs
     */
    private mProfileManagerFactory;
    /**
     * The root command name for the CLI.
     * @private
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    private mRootCommandName;
    /**
     * The command line.
     * @private
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    private mCommandLine;
    /**
     * Environmental variable name prefix used to construct configuration environmental variables.
     * @private
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    private mEnvVariablePrefix;
    /**
     * Prompt phrase which indicates the user would like to be prompted for an argument's value with a hidden text prompt
     * @private
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    private mPromptPhrase;
    /**
     * Construct the yargs command instance for imperative. Provides the ability to define Imperative commands to Yargs.
     * @param {IYargsParms} yargsParms - Parameter object contains parms for Imperative/Yargs and command response objects
     */
    constructor(yargsParms: IYargsParms);
    /**
     * Accessor for the root command name for the CLI
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    protected get rootCommandName(): string;
    /**
     * Accessor for the command line
     * @readonly
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    protected get commandLine(): string;
    /**
     * Accessor for the Environmental variable prefix
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    protected get envVariablePrefix(): string;
    /**
     * Accessor for the CLI prompt phrase
     * @readonly
     * @type {string}
     * @memberof AbstractCommandYargs
     */
    protected get promptPhrase(): string;
    /**
     * Accessor for the command response parms (for subclasses)
     * @return {ICommandResponseParms} - Command response object
     */
    protected get responseParms(): ICommandResponseParms;
    /**
     * Accessor for the help generator factory.
     * @readonly
     * @protected
     * @type {HelpGeneratorFactory}
     * @memberof AbstractCommandYargs
     */
    protected get helpGeneratorFactory(): IHelpGeneratorFactory;
    /**
     * Accessor for the profile manager factory
     * @readonly
     * @type {IProfileManagerFactory<any>}
     * @memberof AbstractCommandYargs
     */
    protected get profileManagerFactory(): IProfileManagerFactory<any>;
    /**
     * Returns a copy of the definition.
     * @return {ICommandDefinition}: A copy of the definition.
     */
    get definition(): ICommandDefinition;
    /**
     * Returns the Yargs instance.
     * @return {yargs.Argv}: The Yargs instance.
     */
    get yargs(): Argv;
    /**
     * Get the array of parents.
     * @return {GroupCommandYargs[]}: The array of parents.
     */
    get parents(): GroupCommandYargs[];
    /**
     * Construct the Bright command definition "tree" - the full definition document including all parents.
     * @return {ICommandDefinition}: The command definition "tree".
     */
    constructDefinitionTree(): ICommandDefinition;
    /**
     * Define the command to Yargs - Accepts the callback to be invoked when this command has executed.
     * @param {YargsCommandCompleted} commandExecuted: Invoked after the command is executed.
     */
    abstract defineCommandToYargs(commandExecuted: YargsCommandCompleted): void;
    /**
     * @deprecated Use `getZoweYargsResponse` instead
     */
    protected getBrightYargsResponse(successful: boolean, responseMessage: string, action: ImperativeYargsCommandAction, responses?: ICommandResponse[]): IYargsResponse;
    /**
     * Build The Bright Yargs response for the callback. Includes the Bright command response and status info.
     * @param {boolean} successful: True if the command succeeded
     * @param {string} responseMessage: Response message for display purposes.
     * @param {ImperativeYargsCommandAction} action
     * @param {ICommandResponse[]} responses
     * @return {IYargsResponse}
     */
    protected getZoweYargsResponse(successful: boolean, responseMessage: string, action: ImperativeYargsCommandAction, responses?: ICommandResponse[]): IYargsResponse;
    /**
     * Execute the help Command for the definition.
     * @param {Arguments} args: The arguments passed by the user - used for -y.
     * @param {YargsCommandCompleted} commandExecuted: The callback when help is complete.
     */
    protected executeHelp(args: Arguments, commandExecuted: YargsCommandCompleted): void;
    /**
     * Get examples for all commands of a group
     * @returns {ICommandDefinition}
     */
    protected getDepthExamples(): ICommandDefinition;
    /**
     * Execute the web help Command for the definition.
     * @param {Arguments} args: The arguments passed by the user - used for -y.
     * @param {YargsCommandCompleted} commandExecuted: The callback when help is complete.
     */
    protected executeWebHelp(args: Arguments, commandExecuted: YargsCommandCompleted): void;
}
