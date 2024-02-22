import { IImperativeConfig } from "../../imperative/src/doc/IImperativeConfig";
import { IDaemonContext } from "../../imperative/src/doc/IDaemonContext";
import { ICommandProfileSchema } from "../../cmd";
import { Config } from "../../config";
/**
 * This class is used to contain all configuration being set by Imperative.
 * It is a singleton and should be accessed via ImperativeConfig.instance.
 */
export declare class ImperativeConfig {
    /**
     * This is the variable that stores the specific instance of Imperative Config.
     * Defined as static so that it can be accessed from anywhere.
     */
    private static mInstance;
    /**
     * This is the daemon context needed to pass to `yargs.fail()` in the event that we cannot extract
     * context through a `yargs.parse()` call.
     * @private
     * @type {IDaemonContext}
     * @memberof ImperativeConfig
     */
    private mDaemonContext;
    /**
     * This parameter is used as the container of all loaded configuration for
     * Imperative.
     */
    private mLoadedConfig;
    /**
     * Current command needed for processing
     */
    private mCommandLine;
    /**
     * This parameter is used to contain the caller location of imperative configuration file.
     */
    private mCallerLocation;
    /**
     * This is the package name of the host application. It will only be set once accessed to
     * lessen loads to the host package.json.
     */
    private mHostPackageName;
    /**
     * This is the name of our imperative package. It will only be set once accessed to
     * lessen loads to the imperative package.json.
     *
     * It isn't hardcoded so that the name of our package can change without affecting
     * modules dependent on it.
     */
    private mImperativePackageName;
    /**
     * This is our calling CLI's command name (taken from package.json: bin).
     */
    private mRootCommandName;
    /**
     * The config object
     */
    private mConfig;
    /**
     * Gets a single instance of the PluginIssues. On the first call of
     * ImperativeConfig.instance, a new Plugin Issues object is initialized and returned.
     * Every subsequent call will use the one that was first created.
     *
     * @returns {ImperativeConfig} The newly initialized PMF object.
     */
    static get instance(): ImperativeConfig;
    /**
     * Get the configured environmental variable prefix for the user's CLI
     * @returns {string} - the configured or default prefix for environmental variables for use in the environmental variable service
     */
    get envVariablePrefix(): string;
    /**
     * Set the caller location.
     * @param {string} location new location to be updated with
     */
    set callerLocation(location: string);
    /**
     * Return file location of imperative configuration file.
     * @returns {streturnsring} - location of configuration file
     */
    get callerLocation(): string;
    /**
     * Set the loaded config data.
     * @param {IImperativeConfig} config to be set.
     */
    set loadedConfig(config: IImperativeConfig);
    /**
     * Retrieve the loaded config (if init has
     * @returns {IImperativeConfig} - the config that has been loaded, if any
     */
    get loadedConfig(): IImperativeConfig;
    /**
     * Set our root command name.
     * @param rootCommandName - The name of our calling CLI's command.
     */
    set rootCommandName(rootCommandName: string);
    /**
     * Get our root command name.
     * @returns The name of our calling CLI's command.
     */
    get rootCommandName(): string;
    /**
     * Retrieve the host package name from which imperative was called.
     */
    get hostPackageName(): string;
    /**
     * Retrieve the package name of the imperative application.
     */
    get imperativePackageName(): string;
    /**
     * Parses the package.json file and searches for the symlink name used under "bin".
     * @returns {string} - return bin symlink name if present, otherwise null
     */
    findPackageBinName(): string;
    /**
     * Return the cli Home path.
     * @return {string} path to cli Home.
     */
    get cliHome(): string;
    /**
     * Return profile Directory.
     * @return {string} profile directory.
     */
    get profileDir(): string;
    /**
     * Return package.json of the imperative user
     * @returns {any} - package.json file of caller
     */
    get callerPackageJson(): any;
    /**
     *  Retrieve the command line.
     *  @example
     *  For example, in "banana a b --c", "a b --c" is the command line.
     *  @returns {string} - command line
     */
    get commandLine(): string;
    /**
     * Set the command line (needed for daemon where command changes and is not static)
     * @memberof Imperative
     */
    set commandLine(args: string);
    /**
     * Set context for daemon to retrieve if no handler is called.
     * @type {IDaemonContext}
     * @memberof ImperativeConfig
     */
    get daemonContext(): IDaemonContext;
    /**
     * Context for daemon when no handler is invoked.
     * @memberof ImperativeConfig
     */
    set daemonContext(context: IDaemonContext);
    /**
     * Set the config
     */
    set config(c: Config);
    /**
     * Get the config properties
     */
    get config(): Config;
    /**
     * Require a file from a project using imperative accounting for imperative being contained
     * separately from the current implementers directory.
     * @param {string} file - the file to require from project using imperative
     */
    getCallerFile(file: string): any;
    /**
     * @returns a key/value object where the key is the profile type and the
     *          value is the profile type schema
     */
    get profileSchemas(): {
        [key: string]: ICommandProfileSchema;
    };
}
