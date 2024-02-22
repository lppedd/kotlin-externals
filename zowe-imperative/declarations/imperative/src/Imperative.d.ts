/**
 * Main class of the Imperative framework, returned when you
 * require("@zowe/imperative") e.g. const imperative =  require("@zowe/imperative");
 */
import { Logger } from "../../logger/src/Logger";
import { IImperativeConfig } from "./doc/IImperativeConfig";
import { ImperativeApi } from "./api/ImperativeApi";
import { ICommandDefinition } from "../../cmd/src/doc/ICommandDefinition";
import { ICommandProfileTypeConfiguration } from "../../cmd/src/doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IHelpGenerator } from "../../cmd/src/help/doc/IHelpGenerator";
import { IHelpGeneratorParms } from "../../cmd/src/help/doc/IHelpGeneratorParms";
import { IDaemonContext } from "./doc/IDaemonContext";
export declare class Imperative {
    static readonly DEFAULT_DEBUG_FILE: string;
    /**
     *  Retrieve the root command name.
     *  @example
     *  For example, in "banana a b --c", "banana" is the root command name.
     *  @returns {string} - root command name
     */
    static get rootCommandName(): string;
    /**
     *  Retrieve the command line.
     *  @example
     *  For example, in "banana a b --c", "a b --c" is the command line.
     *  @returns {string} - command line
     */
    static get commandLine(): string;
    /**
     * Set the command line (needed for daemon where command changes and is not static)
     * @static
     * @memberof Imperative
     */
    static set commandLine(args: string);
    /**
     * Get the complete full command tree
     * @returns {ICommandDefinition}
     */
    static get fullCommandTree(): ICommandDefinition;
    /**
     * Initialize the configuration for your CLI.
     * Wipes out any existing config that has already been set.
     *
     * @param {IImperativeConfig} [config] Configuration for Imperative provided by your application.
     *                                     If this parameter is not set, we will look in the closest
     *                                     package.json up the directory tree from the main entry
     *                                     point of your cli.
     *
     *                                     package.imperative.configurationModule should point to the
     *                                     compiled module that exports the configuration.
     *
     * @returns {Promise<void>} A promise indicating that we are done here.
     */
    static init(config?: IImperativeConfig): Promise<void>;
    /**
     * Returns the default console object to be used for messaging for
     * imperative fails to initialize or to be used before logging
     * is initialized.
     * @return {Logger}: an instance of the default console object
     */
    static get console(): Logger;
    /**
     * Parse command line arguments and issue the user's specified command
     * @returns {Imperative} this, for chaining syntax
     */
    static parse(args?: string | string[], context?: IDaemonContext): Imperative;
    /**
     *
     * @param {string} type the profile type to search for configuration for
     * @returns {IImperativeProfileConfig | undefined}  The profile configuration if found, otherwise, undefined.
     */
    static getProfileConfiguration(type: string): ICommandProfileTypeConfiguration | undefined;
    /**
     * Get the configured help generator for your CLI. If you have not specified a custom generator,
     * the DefaultHelpGenerator will be used.
     * You probably won't need to call this from your CLI, but it is used internally.
     * @returns {IHelpGenerator} - The help generator for the command
     * @param {IHelpGeneratorParms} parms - parameters to the help generator including command definition
     */
    static getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator;
    /**
     * Returns the imperative API object containing various framework API methods for usage in your CLI implemenation.
     * @return {ImperativeApi}: The api object.
     */
    static get api(): ImperativeApi;
    /**
     * Highlight text with your configured (or default) primary color
     * @param {string} text - the text to highlight
     * @returns {string} - the highlighted text
     */
    static highlightWithPrimaryColor(text: string): string;
    /**
     * Get the configured environmental variable prefix for the user's CLI
     * @returns {string} - the configured or default prefix for environmental variables for use in the environmental variable service
     * @deprecated Please use ImperativeConfig.instance.envVariablePrefix
     */
    static get envVariablePrefix(): string;
    /**
     * Highlight text with your configured (or default) secondary color
     * @param {string} text - the text to highlight
     * @returns {string} - the highlighted text
     */
    static highlightWithSecondaryColor(text: string): string;
    private static mApi;
    private static mConsoleLog;
    private static mFullCommandTree;
    private static mRootCommandName;
    private static mCommandLine;
    private static mHelpGeneratorFactory;
    /**
     * Get log instance
     */
    private static get log();
    /**
     * Load the correct {@link AppSettings} instance from values located in the
     * cli home folder.
     */
    private static initAppSettings;
    /**
     * Init log object such that subsequent calls to the Logger.getImperativeLogger() (or
     * other similar calls), will contain all necessary categories for logging.
     *
     * TODO(Kelosky): handle level setting via global config (trace enabling and such)
     */
    private static initLogging;
    /**
     * Initialize the profiles directory with types and meta files. This can be called every startup of the CLI
     * without issue, but if the meta files or configuration changes, we'll have to re-initialize.
     * TODO: Determine the re-initialize strategy.
     * @private
     * @static
     * @param {IImperativeConfig} config - The configuration document passed to init.
     * @memberof Imperative
     */
    private static initProfiles;
    /**
     * Define to yargs for main CLI and plugins
     *
     * @param {ICommandDefinition} preparedHostCliCmdTree - The Root of the imperative host CLI
     *        which has already prepared by ImperativeConfig.getPreparedCmdTree.
     */
    private static defineCommands;
    /**
     * Construct the API object for return to caller of init()
     * @return {ImperativeApi}: The API object
     */
    private static constructApiObject;
    /**
     * Build the Logger API object for the app using the framework
     * @return {Logger}: returns the app Logger API object
     */
    private static constructAppLoggerApi;
    /**
     * Build the imperative API object for the app using the framework
     * @return {Logger}: returns the imperative Logger API object
     */
    private static constructImperativeLoggerApi;
    /**
     * Build the default console API object for the framework
     * @return {Logger}: returns the default console Logger API object
     */
    private static constructConsoleApi;
    private static constructDynamicLoggersApi;
    /**
     * Get imperative's host CLI command tree with all module globs resolved.
     *
     * @return {ICommandDefinition} The resolved command tree
     */
    private static getResolvedCmdTree;
    /**
     * Get imperative's host CLI command tree after final preparation.
     *
     * @param resolvedCmdTree - The imperative command tree
     *        returned by Imperative.getResolvedCmdTree()
     * @param {ICommandProfileTypeConfiguration} baseProfile - An optional base profile to add to command definitions
     */
    private static getPreparedCmdTree;
    /**
     * Append any auto generated commands to the root command document depending on configuration.
     * @param {ICommandDefinition} rootCommand - the root command as built so far
     * @returns {ICommandDefinition} - the root command with any auto generated commands appended
     */
    private static addAutoGeneratedCommands;
}
