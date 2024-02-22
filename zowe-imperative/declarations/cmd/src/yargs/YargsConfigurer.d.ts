import { ICommandDefinition } from "../doc/ICommandDefinition";
import { ICommandResponseParms } from "../doc/response/parms/ICommandResponseParms";
import { IProfileManagerFactory } from "../../../profiles";
import { ICommandProfileTypeConfiguration } from "../doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IHelpGeneratorFactory } from "../help/doc/IHelpGeneratorFactory";
/**
 * Before invoking commands, this class configures some settings and callbacks in Yargs,
 * including what happens on syntax failures.
 */
export declare class YargsConfigurer {
    private rootCommand;
    private yargs;
    private commandRespParms;
    private profileManagerFactory;
    private helpGeneratorFactory;
    private experimentalCommandDescription;
    private rootCommandName;
    private commandLine;
    private envVariablePrefix;
    private promptPhrase;
    constructor(rootCommand: ICommandDefinition, yargs: any, commandRespParms: ICommandResponseParms, profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>, helpGeneratorFactory: IHelpGeneratorFactory, experimentalCommandDescription: string, rootCommandName: string, commandLine: string, envVariablePrefix: string, promptPhrase: string);
    configure(): void;
    /**
     * Builds the failure message that is passed to the failedCommand handler
     * @return {string} - Returns the failure message
     */
    private buildFailureMessage;
    /**
     * Define failed command with the current command line arguments.
     * @returns Failed command definition object
     */
    private buildFailedCommandDefinition;
    private getClosestCommand;
    /**
     * Get the command response format based on whether `--rfj` is set.
     * @param argv Yargs arguments object
     */
    private getResponseFormat;
}
