import { IProfile, IProfileLoaded } from "../../../profiles";
/**
 * Profiles map created by the command profile loader and passed to the handler via parameters. Handlers can
 * retreive loaded profiles from the map via the profile type.
 * @export
 * @class CommandProfiles
 */
export declare class CommandProfiles {
    /**
     * The loaded profiles map - profiles are retrieved via the type key. More than one profile of a particular type
     * can be loaded by the command processor (depending on dependencies, etc.)
     * @private
     * @type {Map<string, IProfile[]>}
     * @memberof CommandProfiles
     */
    private mMap;
    /**
     * The loaded profiles map with meta info - profiles are retrieved via the type key. More than one profile of a particular type
     * can be loaded by the command processor (depending on dependencies, etc.)
     * @private
     * @type {Map<string, IProfileLoaded[]>}
     * @memberof CommandProfiles
     */
    private mMetaMap;
    /**
     * Creates an instance of CommandProfiles.
     * @param {Map<string, IProfile[]>} map - The map of profiles
     * @memberof CommandProfiles
     */
    constructor(map: Map<string, IProfile[]>, metaMap?: Map<string, IProfileLoaded[]>);
    /**
     * Gets the first (or by name) meta profile in the map - automatically throws an exception (unless disabled)
     * @deprecated
     * @template T - The expected profile mapping to be returned
     * @param {string} type - The profile type
     * @param {string} [name=""] - The name of the profile to retrieve
     * @param {boolean} [failNotFound=true] - Automatically throws an imperative exception if not profiles are not
     * found - this is provided as convince for the handlers (will fail your command if not found) - This would
     * normally be the result of a command configuration problem.
     * @returns {T} - The first profile in the map (or the one located by name)
     * @memberof CommandProfiles
     */
    getMeta<T extends IProfileLoaded>(type: string, failNotFound?: boolean, name?: string): T;
    /**
     * Gets the first (or by name) profile in the map - automatically throws an exception (unless disabled)
     * @deprecated Load profile properties from `IHandlerParameters.arguments` property instead.
     * @template T - The expected profile mapping to be returned
     * @param {string} type - The profile type
     * @param {string} [name=""] - The name of the profile to retrieve
     * @param {boolean} [failNotFound=true] - Automatically throws an imperative exception if not profiles are not
     * found - this is provided as convince for the handlers (will fail your command if not found) - This would
     * normally be the result of a command configuration problem.
     * @returns {T} - The first profile in the map (or the one located by name)
     * @memberof CommandProfiles
     */
    get<T extends IProfile>(type: string, failNotFound?: boolean, name?: string): T;
    /**
     * Gets all profiles for the type specified,
     * @deprecated
     * @template T - extends IProfile
     * @param {string} type - The profile type to retrieve loaded profiles
     * @returns {T[]} - The list of profile types
     * @param {boolean} [failNotFound=true] - Automatically throws an imperative exception if not profiles are not
     * found - this is provided as convince for the handlers (will fail your command if not found) - This would
     * normally be the result of a command configuration problem.
     * @memberof CommandProfiles
     */
    getAll<T extends IProfile>(type: string, failNotFound?: boolean): T[];
    /**
     * Add to an instance of CommandProfiles
     * @private
     * @param {Map<string, IProfileLoaded[]>} map - The map of profiles with meta information
     * @memberof CommandProfiles
     */
    private addMeta;
    /**
     * Internal accessor for the map
     * @readonly
     * @private
     * @type {Map<string, IProfile[]>} - The profile Map
     * @memberof CommandProfiles
     */
    private get map();
    /**
     * Internal accessor for the meta map
     * @readonly
     * @private
     * @type {Map<string, IProfileLoaded[]>} - The profile Map
     * @memberof CommandProfiles
     */
    private get metaMap();
    /**
     * Throw an error failing the get(requested by the caller if no profiles are available)
     * @private
     * @param {string} type - the profile type to get from the map
     * @memberof CommandProfiles
     */
    private fail;
}
