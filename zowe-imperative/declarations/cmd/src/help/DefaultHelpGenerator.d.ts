import { AbstractHelpGenerator } from "./abstract/AbstractHelpGenerator";
import { IHelpGeneratorParms } from "./doc/IHelpGeneratorParms";
import { IHelpGeneratorFactoryParms } from "./doc/IHelpGeneratorFactoryParms";
import { ICommandDefinition } from "../../src/doc/ICommandDefinition";
/**
 * Imperative default help generator. Accepts the command definitions and constructs
 * the full help text for the command node.
 *
 * TODO - Consider removing word wrap on a fixed with and apply dynamically based on terminal sizes
 * @export
 * @class DefaultHelpGenerator
 * @extends {AbstractHelpGenerator}
 */
export declare class DefaultHelpGenerator extends AbstractHelpGenerator {
    /**
     * The help indent for spacing/alignment
     * @static
     * @memberof DefaultHelpGenerator
     */
    static readonly HELP_INDENT = "   ";
    /**
     * Standard imperative error message tag for errors thrown by the help generator
     * @private
     * @static
     * @type {string}
     * @memberof DefaultHelpGenerator
     */
    private static readonly ERROR_TAG;
    /**
     * Indicates that the help generator should skip introducing breaks based on terminal width
     * @type {boolean}
     * @memberof IHelpGeneratorParms
     */
    private skipTextWrap;
    /**
     * Creates an instance of DefaultHelpGenerator.
     * @param {IHelpGeneratorFactoryParms} defaultParms - Imperative config parameters for help generation - See interface for details
     * @param {IHelpGeneratorParms} commandParms - The command definitions for generating help - See interface for details
     * @memberof DefaultHelpGenerator
     */
    constructor(defaultParms: IHelpGeneratorFactoryParms, commandParms: IHelpGeneratorParms);
    /**
     * Construct the full help text for display.
     * @returns {string} - The full help text
     * @memberof DefaultHelpGenerator
     */
    buildHelp(): string;
    /**
     * Build the help text for a "group" - a group has a set of children  The help text contains the standard
     * description/usage/etc., but unlike a command only displays the next set of "commands" or "groups" that can
     * be issued after the current node.
     * @returns {string} - the full group help text
     * @memberof DefaultHelpGenerator
     */
    buildFullGroupHelpText(): string;
    /**
     * Returns the help text for the command definition - the help text contains the standard items such as
     * description/usage/etc. and also contains the full option descriptions for the command.
     * @param {boolean} [includeGlobalOptions=true] - Include the global options in the help text
     * @returns {string} - The help text for --help or markdown.
     */
    buildFullCommandHelpText(includeGlobalOptions?: boolean): string;
    /**
     * Build a string containing the command name and aliases separated by the vertical bar:
     * command | c
     * @param {ICommandDefinition} commandDefinition - The definition for the command
     * @returns {string} - Contains the command name followed by the aliases (e.g. command | c)
     * @memberof DefaultHelpGenerator
     */
    buildCommandAndAliases(commandDefinition: ICommandDefinition): string;
    /**
     * Builds a table of commands/groups for display in the help:
     *
     * GROUPS
     * ------
     * group1  hello this is group1
     * group2  hello this is group2
     *
     * @return {string}: Returns the table for display.
     */
    buildChildrenSummaryTables(): string;
    /**
     * Build the usage diagram for the command.
     * TODO - very simple at the moment, should be enhanced with a "better" diagram
     * @returns {string}
     * @memberof DefaultHelpGenerator
     */
    buildUsageDiagram(): string;
    /**
     * Build the usage section of the help text:
     *
     * USAGE
     * -----
     * command blah [options]
     *
     * @returns {string} - The usage help text section
     * @memberof DefaultHelpGenerator
     */
    buildUsageSection(): string;
    /**
     * Build the global options section of the command help text.
     *
     * GLOBAL OPTIONS
     * --------------
     * ...
     *
     * @returns {string} - The global options help text section
     * @memberof DefaultHelpGenerator
     */
    buildGlobalOptionsSection(): string;
    /**
     * Build the command description section of the help text:
     *
     * DESCRIPTION
     * -----------
     * This command is great.
     *
     * @returns {string} - The command description text
     * @memberof DefaultHelpGenerator
     */
    buildDescriptionSection(): string;
    /**
     * Return the help text format for positional parameters - includes the parameter itself, the optional regex,
     * and the full description.
     * @returns {string} - The help text for each positional parameter.
     * @memberof DefaultHelpGenerator
     */
    buildPositionalArgumentsSection(): string;
    /**
     * From the map of options (group to option), formulate the group and options in the form of:
     *
     * OPTION GROUP
     * ------------
     *
     *   option1
     *
     *      Description of option1
     *
     *   option2
     *
     *      Description of option2
     *
     * @return {string}
     */
    buildCommandOptionsSection(): string;
    /**
     * Build the text for option:
     *
     * --option
     *
     *    The description for this option
     *
     * @param {string} optionString - The option string (-- form or positional, etc.)
     * @param {string} description - The description for the option
     * @return {string} - The option text
     */
    buildOptionText(optionString: string, description: string): string;
    /**
     * Produces a header for the current section in help:
     *
     * COMMANDS
     * --------
     *
     * @param {string} header - the header text (e.g. COMMANDS)
     * @returns {string} - The header
     * @memberof DefaultHelpGenerator
     */
    buildHeader(header: string): string;
    /**
     * Build the examples text for the command. Examples include the command example (which normally is able to
     * be copy/pasted verbatim) and the description for the example.
     * TODO - we should remove wordwrap from this
     * @returns {string} - The example text
     * @memberof DefaultHelpGenerator
     */
    buildExamplesSection(): string;
    /**
     * Get a blurb explaining experimental commands if this command is experimental
     * @returns {string} - If this command is experimental, returns the experimental command explanation block
     * @memberof DefaultHelpGenerator
     */
    getExperimentalCommandSection(): string;
    /**
     * Utility function to escape Markdown special characters.
     * Note: This should only be called once to avoid double escaping.
     * @param {string} text - The text to escape
     * @return {string} - The escaped string
     */
    private escapeMarkdown;
}
