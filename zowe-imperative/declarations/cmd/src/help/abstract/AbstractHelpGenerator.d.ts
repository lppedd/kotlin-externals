import { Logger } from "../../../../logger/src/Logger";
import { IHelpGeneratorParms } from "../doc/IHelpGeneratorParms";
import { IHelpGeneratorFactoryParms } from "../doc/IHelpGeneratorFactoryParms";
import { IHelpGenerator } from "../doc/IHelpGenerator";
import { ICommandDefinition } from "../../doc/ICommandDefinition";
import { CommandOptionType, ICommandOptionDefinition } from "../../doc/option/ICommandOptionDefinition";
export declare abstract class AbstractHelpGenerator implements IHelpGenerator {
    static SHORT_DASH: string;
    static LONG_DASH: string;
    /**
     * Get a heading for the CLI / help
     * @param {string} header - The text you want to display in the header
     * @param indent - prefix the the heading and dashes with this string (defaults to one space)
     * @param color - the color to highlight the header in
     * @returns {string} the formatted/colored header
     */
    static formatHelpHeader(header: string, indent: string, color: string): string;
    /**
     * The command name being invoked by the user.
     * For example, when using "banana --help", banana is the command name.
     */
    protected mRootCommandName: string;
    /**
     * The command definition for which we are building help
     */
    protected mCommandDefinition: ICommandDefinition;
    /**
     * The full command definition - which includes the parents of the command.
     */
    protected mDefinitionTree: ICommandDefinition;
    /**
     * Produce markdown - not help text.
     */
    protected mProduceMarkdown: boolean;
    /**
     * Logger
     */
    protected mLog: Logger;
    protected mPrimaryHighlightColor: string;
    /**
     * The configured experimental command description.
     * Has a default, generic description which can be overridden through parameters
     * to the constructor
     * @type {string}
     */
    protected mExperimentalCommandDescription: string;
    /**
     * A map of group names to option names and aliases - useful in help text/doc generation
     * e.g. this.grouptoOption["job options"] -> [ "--async | -a ", "--activate | -A"]
     */
    protected groupToOption: {
        [key: string]: string[];
    };
    /**
     * A map of option names and aliases to their descriptions - useful in help text/doc generation
     * e.g. this.optionToDescription["--async | a"] -> "Don't wait for this job to complete before returning"
     */
    protected optionToDescription: {
        [key: string]: string;
    };
    /**
     * Get log instance
     */
    protected get log(): Logger;
    constructor(defaultParms: IHelpGeneratorFactoryParms, commandParms: IHelpGeneratorParms);
    abstract buildHelp(): string;
    getOptionAndAliasesString(option: ICommandOptionDefinition, caseSensitive?: boolean): string;
    abstract buildFullCommandHelpText(includeGlobalOptions: boolean): string;
    protected buildOptionMaps(): void;
    protected getCaseSensitiveFlagByOptionName(optionName: string): boolean;
    protected renderHelp(help: string): string;
    protected explainType(type: CommandOptionType): string;
    /**
     * Highlight text in dim grey (disabled if producing markdown)
     * @param {string} text - the text you would like to highlight
     * @returns {string} the highlighted text
     */
    protected dimGrey(text: string): any;
    /**
     * Highlight text in grey (disabled if producing markdown)
     * @param {string} text - the text you would like to highlight
     * @returns {string} the highlighted text
     */
    protected grey(text: string): any;
}
