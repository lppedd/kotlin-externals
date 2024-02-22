import { Arguments } from "yargs";
import { IOptionFormat } from "./doc/IOptionFormat";
import { CommandProfiles, ICommandOptionDefinition, ICommandPositionalDefinition, ICommandProfile, IHandlerParameters } from "../../cmd";
import { ICommandArguments } from "../../cmd/src/doc/args/ICommandArguments";
import { IPromptOptions } from "../../cmd/src/doc/response/api/handler/IPromptOptions";
/**
 * Cli Utils contains a set of static methods/helpers that are CLI related (forming options, censoring args, etc.)
 * @export
 * @class CliUtils
 */
export declare class CliUtils {
    /**
     * Used as the place holder when censoring arguments in messages/command output
     * @static
     * @memberof CliUtils
     */
    static readonly CENSOR_RESPONSE = "****";
    /**
     * A list of cli options/keywords that should normally be censored
     * @static
     * @memberof CliUtils
     */
    static CENSORED_OPTIONS: string[];
    /**
     * Get the 'dash form' of an option as it would appear in a user's command,
     * appending the proper number of dashes depending on the length of the option name
     * @param {string} optionName - e.g. my-option
     * @returns {string} - e.g. --my-option
     */
    static getDashFormOfOption(optionName: string): string;
    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     * @param {string[]} args - The args list to censor
     * @returns {string[]}
     */
    static censorCLIArgs(args: string[]): string[];
    /**
     * Copy and censor a yargs argument object before logging
     * @param {yargs.Arguments} args the args to censor
     * @returns {yargs.Arguments}  a censored copy of the arguments
     */
    static censorYargsArguments(args: Arguments): Arguments;
    /**
     * Accepts the full set of loaded profiles and attempts to match the option names supplied with profile keys.
     *
     * @param {Map<string, IProfile[]>} profileMap - the map of type to loaded profiles. The key is the profile type
     * and the value is an array of profiles loaded for that type.
     *
     * @param {definitions} definitions - the profile definition on the command.
     *
     * @param {(Array<ICommandOptionDefinition | ICommandPositionalDefinition>)} options - the full set of command options
     * for the command being processed
     *
     * @returns {*}
     *
     * @memberof CliUtils
     */
    static getOptValueFromProfiles(profiles: CommandProfiles, definitions: ICommandProfile, options: Array<ICommandOptionDefinition | ICommandPositionalDefinition>): any;
    /**
     * Using Object.assign(), merges objects in the order they appear in call. Object.assign() copies and overwrites
     * existing properties in the target object, meaning property precedence is least to most (left to right).
     *
     * See details on Object.assign() for nuance.
     *
     * @param {...any[]} args - variadic set of objects to be merged
     *
     * @returns {*} - the merged object
     *
     */
    static mergeArguments(...args: any[]): any;
    /**
     * Accepts the full set of command options and extracts their values from environment variables that are set.
     *
     * @param {(Array<ICommandOptionDefinition | ICommandPositionalDefinition>)} options - the full set of options
     * specified on the command definition. Includes both the option definitions and the positional definitions.
     *
     * @returns {ICommandArguments["args"]} - the argument style object with both camel and kebab case keys for each
     * option specified in environment variables.
     *
     */
    static extractEnvForOptions(envPrefix: string, options: Array<ICommandOptionDefinition | ICommandPositionalDefinition>): ICommandArguments["args"];
    /**
     * Convert an array of strings provided as an environment variable
     *
     * @param envValue String form of the array
     * @returns String[] based on environment variable
     */
    static extractArrayFromEnvValue(envValue: string): string[];
    /**
     * Get the value of an environment variable associated with the specified option name.
     * The environment variable name will be formed by concatenating an environment name prefix,
     * and the cmdOption using underscore as the delimiter.
     *
     * The cmdOption name can be specified in camelCase or in kabab-style.
     * Regardless of the style, it will be converted to upper case.
     * We replace dashes in Kabab-style values with underscores. We replace each uppercase
     * character in a camelCase value with underscore and that character.
     *
     * The envPrefix will be used exactly as specified.
     *
     * Example: The values myEnv-Prefix and someOptionName would retrieve
     * the value of an environment variable named
     *      myEnv-Prefix_SOME_OPTION_NAME
     *
     * @param {string} envPrefix - The prefix for environment variables for this CLI.
     *      Our caller can use the value obtained by ImperativeConfig.instance.envVariablePrefix,
     *      which will use the envVariablePrefix from the Imperative config object,
     *      and will use the rootCommandName as a fallback value.
     *
     * @param {string} cmdOption - The name of the option in either camelCase or kabab-style.
     *
     * @returns {string | null} - The value of the environment variable which corresponds
     *      to the supplied option for the supplied command. If no such environment variable
     *      exists we return null.
     *
     * @memberof CliUtils
     */
    static getEnvValForOption(envPrefix: string, cmdOption: string): string | null;
    /**
     * Constructs the yargs style positional argument string.
     * @static
     * @param {boolean} positionalRequired - Indicates that this positional is required
     * @param {string} positionalName - The name of the positional
     * @returns {string} - The yargs style positional argument string (e.g. <name>);
     * @memberof CliUtils
     */
    static getPositionalSyntaxString(positionalRequired: boolean, positionalName: string): string;
    /**
     * Format the help header - normally used in help generation etc.
     * @static
     * @param {string} header
     * @param {string} [indent=" "]
     * @param {string} color
     * @returns {string}
     * @memberof CliUtils
     */
    static formatHelpHeader(header: string, indent: string, color: string): string;
    /**
     * Display a message when the command is deprecated.
     * @static
     * @param {string} handlerParms - the IHandlerParameters supplied to
     *                                a command handler's process() function.
     * @memberof CliUtils
     */
    static showMsgWhenDeprecated(handlerParms: IHandlerParameters): void;
    /**
     * Accepts an option name, and array of option aliases, and their value
     * and returns the arguments style object.
     *
     * @param {string} optName - The command option name, usually in kebab case (or a single word)
     *
     * @param {string[]} optAliases - An array of alias names for this option
     *
     * @param {*} value - The value to assign to the argument
     *
     * @returns {ICommandArguments["args"]} - The argument style object
     *
     * @example <caption>Create Argument Object</caption>
     *
     * CliUtils.setOptionValue("my-option", ["mo", "o"], "value");
     *
     * // returns
     * {
     *    "myOption": "value",
     *    "my-option": "value",
     *    "mo": "value",
     *    "o": "value"
     * }
     *
     */
    static setOptionValue(optName: string, optAliases: string[], value: any): ICommandArguments["args"];
    /**
     * Display a prompt that hides user input and reads from stdin
     * DOES NOT WORK WITH COMMANDS THAT ALSO READ STDIN
     * Useful for prompting the user for sensitive info such as passwords
     * Synchronous
     * @deprecated Use the asynchronous method `readPrompt` instead
     * @param message - The message to display to the user e.g. "Please enter password:"
     * @returns value - the value entered by the user
     */
    static promptForInput(message: string): string;
    /**
     * Sleep for the specified number of miliseconds.
     * @param timeInMs Number of miliseconds to sleep
     *
     * @example
     *      // create a synchronous delay as follows:
     *      await CliUtils.sleep(3000);
     */
    static sleep(timeInMs: number): Promise<unknown>;
    /**
     * Prompt the user with a question and wait for an answer,
     * but only up to the specified timeout.
     *
     * @deprecated Use `readPrompt` instead which supports more options
     * @param questionText The text with which we will prompt the user.
     *
     * @param hideText Should we hide the text. True = display stars.
     *                 False = display text. Default = false.
     *
     * @param secToWait The number of seconds that we will wait for an answer.
     *                  If not supplied, the default is 600 seconds.
     *
     * @return A string containing the user's answer, or null if we timeout.
     *
     * @example
     *      const answer = await CliUtils.promptWithTimeout("Type your answer here: ");
     *      if (answer === null) {
     *          // abort the operation that you wanted to perform
     *      } else {
     *          // use answer in some operation
     *      }
     */
    static promptWithTimeout(questionText: string, hideText?: boolean, secToWait?: number): Promise<string>;
    /**
     * Prompt the user with a question and wait for an answer,
     * but only up to the specified timeout.
     *
     * @param message The text with which we will prompt the user.
     *
     * @param opts.hideText Should we hide the text. True = display stars.
     *        False = display text. Default = false.
     *
     * @param opts.secToWait The number of seconds that we will wait for an answer.
     *        If not supplied, the default is 10 minutes.
     *        If 0 is specified, we will never timeout.
     *        Numbers larger than 3600 (1 hour) are not allowed.
     *
     * @param opts.maskChar The character that should be used to mask hidden text.
     *        If null is specified, then no characters will be echoed back.
     *
     * @return A string containing the user's answer, or null if we timeout.
     *
     * @example
     *      const answer = await CliUtils.readPrompt("Type your answer here: ");
     *      if (answer === null) {
     *          // abort the operation that you wanted to perform
     *      } else {
     *          // use answer in some operation
     *      }
     */
    static readPrompt(message: string, opts?: IPromptOptions): Promise<string | null>;
    /**
     * Accepts the yargs argument object and constructs the base imperative
     * argument object. The objects are identical to maintain compatibility with
     * existing CLIs and plugins, but the intent is to eventually phase out
     * having CLIs import anything from Yargs (types, etc).
     *
     * @param {Arguments} args - Yargs argument object
     *
     * @returns {ICommandArguments} - Imperative argument object
     *
     */
    static buildBaseArgs(args: Arguments): ICommandArguments;
    /**
     * Takes a key and converts it to both camelCase and kebab-case.
     *
     * @param key The key to transform
     *
     * @returns An object that contains the new format.
     *
     * @example <caption>Conversion of keys</caption>
     *
     * CliUtils.getOptionFormat("helloWorld");
     *
     * // returns
     * const return1 = {
     *     key: "helloWorld",
     *     camelCase: "helloWorld",
     *     kebabCase: "hello-world"
     * }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello-world");
     *
     * // returns
     * const return2 = {
     *     key: "hello-world",
     *     camelCase: "helloWorld",
     *     kebabCase: "hello-world"
     * }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello--------world");
     *
     * // returns
     * const return3 = {
     *     key: "hello--------world",
     *     camelCase: "helloWorld",
     *     kebabCase: "hello-world"
     * }
     *
     * /////////////////////////////////////////////////////
     *
     * CliUtils.getOptionFormat("hello-World-");
     *
     * // returns
     * const return4 = {
     *     key: "hello-World-",
     *     camelCase: "helloWorld",
     *     kebabCase: "hello-world"
     * }
     */
    static getOptionFormat(key: string): IOptionFormat;
}
