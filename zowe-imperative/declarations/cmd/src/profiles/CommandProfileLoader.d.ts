import { Arguments } from "yargs";
import { ICommandDefinition } from "../doc/ICommandDefinition";
import { IProfileManagerFactory } from "../../../profiles";
import { ICommandProfileTypeConfiguration } from "../doc/profiles/definition/ICommandProfileTypeConfiguration";
import { CommandProfiles } from "./CommandProfiles";
import { ICommandProfileLoaderParms } from "../doc/profiles/parms/ICommandProfileLoaderParms";
import { Logger } from "../../../logger";
/**
 * The command processor profile loader loads all profiles that are required (or optional) given a command
 * definitions requirements. It returns the CommandProfiles object (which contains the map and getters for the
 * command handlers usage).
 * @export
 * @class CommandProfileLoader
 */
export declare class CommandProfileLoader {
    /**
     * Create a new instance of the profile loader
     * @static
     * @param {CommandResponse} response - The command response object, used to formulate messages, logs and errors
     * @param {ICommandDefinition} commandDefinition - The command definition for the command being issued (used to determine
     * what profiles to load for this command)
     * @param {IProfileManagerFactory<ICommandProfileTypeConfiguration>} factory - The profile manager factory (used to
     * obtain instances of profile managers for profiles that are to be loaded)
     * @returns
     * @memberof CommandProfileLoader
     */
    static loader(parms: ICommandProfileLoaderParms): CommandProfileLoader;
    /**
     * The input command definition for the command being issued.
     * @private
     * @type {ICommandDefinition}
     * @memberof CommandProfileLoader
     */
    private mCommandDefinition;
    /**
     * The factory for getting profile manager instances.
     * @private
     * @type {IProfileManagerFactory<ICommandProfileTypeConfiguration>}
     * @memberof CommandProfileLoader
     */
    private mFactory;
    /**
     * Logger - supplied on the constructor - but defaults to the Imperative logger.
     * @private
     * @type {Logger}
     * @memberof CommandProfileLoader
     */
    private mLog;
    /**
     * Creates an instance of CommandProfileLoader.
     * @param {ICommandDefinition} commandDefinition - The input command definition for the command being issued.
     * @param {IProfileManagerFactory<ICommandProfileTypeConfiguration>} factory - The profile manager factory
     * @param {any} [logger=Logger.getImperativeLogger()] - A log4js instance
     * @memberof CommandProfileLoader
     */
    constructor(commandDefinition: ICommandDefinition, factory: IProfileManagerFactory<ICommandProfileTypeConfiguration>, logger?: Logger);
    /**
     * Load the profiles for the command - the command arguments are supplied to grab the profile names from
     * the arguments supplied by the user.
     * @param {Arguments} commandArguments - The command arguments supplied on this command invocation (Yargs style)
     * @returns {Promise<CommandProfiles>} - The promise is fulfilled with the map object OR rejected with an
     * Imperative error
     * @memberof CommandProfileLoader
     */
    loadProfiles(commandArguments: Arguments): Promise<CommandProfiles>;
    /**
     * Builds the command map for input the the command map object for the command handlers
     * @private
     * @param {IProfileLoaded[]} responses - The full list of profiles loaded for this command
     * @param {Map<string, IProfile[]>} map - The map to populate
     * @memberof CommandProfileLoader
     */
    private buildCommandMap;
    /**
     * Builds the command meta map for input the the command map object for the command handlers
     * @private
     * @param {IProfileLoaded[]} responses - The full list of profiles loaded for this command
     * @param {Map<string, IProfile[]>} map - The meta map to populate
     * @memberof CommandProfileLoader
     */
    private buildCommandMetaMap;
    /**
     * Builds the list of profiles to load for this command.
     * @private
     * @param {Arguments} commandArguments - The arguments supplied on the command (Yargs Style)
     * @returns {ICommandLoadProfile[]} - The list of profiles to load (and other control information)
     * @memberof CommandProfileLoader
     */
    private constructLoadList;
    /**
     * Builds the control parameters for the loading of each profile name/type.
     * @private
     * @param {boolean} optional - If the profile is optional
     * @param {string[]} types - The profile types to load
     * @param {Arguments} commandArguments - The command arguments
     * @returns {ICommandLoadProfile[]} - The list of profiles to load (and control parameters)
     * @memberof CommandProfileLoader
     */
    private buildLoad;
    /**
     * Invoke the profile managers to load the profiles requested for this command.
     * @private
     * @param {ICommandLoadProfile[]} list - The list of profiles to load and control parameters.
     * @returns {Promise<IProfileLoaded[]>} - The promise to fulfill with the entire load response OR rejected with
     * an Imperative Error.
     * @memberof CommandProfileLoader
     */
    private loadAll;
    /**
     * Accessor for the profile manager factory
     * @readonly
     * @private
     * @type {IProfileManagerFactory<ICommandProfileTypeConfiguration>}
     * @memberof CommandProfileLoader
     */
    private get factory();
    /**
     * Accessor for the command definition document
     * @readonly
     * @private
     * @type {ICommandDefinition}
     * @memberof CommandProfileLoader
     */
    private get definition();
    /**
     * Accessor for the logging object
     * @readonly
     * @private
     * @type {Logger}
     * @memberof CommandProfileLoader
     */
    private get log();
}
