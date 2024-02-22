import { Argv } from "yargs";
import { ICommandDefinition } from "../../../cmd/src/doc/ICommandDefinition";
import { YargsCommandCompleted } from "./AbstractCommandYargs";
import { ICommandResponseParms } from "../../../cmd/src/doc/response/parms/ICommandResponseParms";
import { IProfileManagerFactory } from "../../../profiles";
import { ICommandProfileTypeConfiguration } from "../doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IHelpGeneratorFactory } from "../help/doc/IHelpGeneratorFactory";
/**
 * Imperative Command Definer - Defines the Imperative command objects to Yargs for processing.
 */
export declare class YargsDefiner {
    /**
     * The Yargs instance object used to define the commands.
     */
    private mYargsInstance;
    private mPrimaryHighlightColor;
    private mRootCommandName;
    private mCommandLine;
    private mEnvVariablePrefix;
    private mHelpFactory;
    private mProfileManagerFactory;
    private mExperimentalCommandDescription;
    private mPromptPhrase;
    /**
     * Logger instance
     */
    private log;
    /**
     * Build the definer - maintains the Yargs instance for all future definitions.
     * @param {yargs.Argv} yargsInstance: The Yargs instance used to define the commands.
     * @param primaryHighlightColor -  main color to highlight help text headings and other text with
     * @param rootCommandName - the display name of the root command (e.g. "bright" or "sample-cli")
     * @param envVariablePrefix - the environment variable prefix
     * @param profileManagerFactory - profile manager factory that can be used to instantiate new profile managers
     * @param helpGeneratorFactory - help generator factory that can be used to instantiate new help generators
     * @param experimentalCommandDescription - optionally overridden experimental command description to
     *                                         propagate to yargs services
     */
    constructor(yargsInstance: Argv, primaryHighlightColor: string, rootCommandName: string, commandLine: string, envVariablePrefix: string, profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>, helpGeneratorFactory: IHelpGeneratorFactory, experimentalCommandDescription: string, promptPhrase: string);
    /**
     * Accepts an Imperative command definition document and defines to Yargs.
     * @param {ICommandDefinition} definition: The Imperative JSON command definition document.
     * @param {YargsCommandCompleted} commandExecuted: An "event-style" callback that is invoked upon
     * completion of a command execution for this definition.
     * @param {ICommandResponseParms} responseParms - The response object parameters used when invoking commands and help
     */
    define(definition: ICommandDefinition, commandExecuted: YargsCommandCompleted, responseParms: ICommandResponseParms): void;
}
