import { ICommandArguments, IHandlerParameters } from "../../cmd";
import { AbstractAuthHandler } from "../../imperative/src/auth/handlers/AbstractAuthHandler";
import { IConfigAutoStoreStoreSessCfgPropsOpts } from "./doc/IConfigAutoStoreOpts";
/**
 * Class to manage automatic storage of properties in team config.
 */
export declare class ConfigAutoStore {
    /**
     * Finds the profile where auto-store properties should be saved.
     * @param params CLI handler parameters object
     * @param profileProps List of properties required in the profile schema
     * @returns Tuple containing profile type and name, or undefined if no profile was found
     */
    static findActiveProfile(params: IHandlerParameters, profileProps: string[]): [string, string] | undefined;
    /**
     * Helper method to find an active profile based on the optional CLI handler parameters
     * @param opts Set of options required to find an active profile
     * @returns Tuple containing profile type and name, or undefined if no profile was found
     */
    private static _findActiveProfile;
    /**
     * Finds the token auth handler class for a team config profile.
     * @param profilePath JSON path of profile
     * @param cmdArguments CLI arguments which may specify a profile
     * @returns Auth handler class or undefined if none was found
     */
    static findAuthHandlerForProfile(profilePath: string, cmdArguments: ICommandArguments): AbstractAuthHandler | undefined;
    /**
     * Helper method that finds the token auth handler class for a team config profile
     * @param opts Set of options required to find the auth handler for a given profile path
     * @returns Auth handler class or undefined if none was found
     */
    private static _findAuthHandlerForProfile;
    /**
     * Stores session config properties into a team config profile.
     * @param params CLI handler parameters object
     * @param sessCfg Session config containing properties to store
     * @param propsToStore Names of properties that should be stored
     */
    static storeSessCfgProps(params: IHandlerParameters, sessCfg: {
        [key: string]: any;
    }, propsToStore: string[]): Promise<void>;
    /**
     * Stores session config properties into a team config profile.
     * @param opts Set of options required to store session config properties
     */
    static _storeSessCfgProps(opts: IConfigAutoStoreStoreSessCfgPropsOpts): Promise<void>;
    /**
     * Retrieves token value that will be auto-stored into session config.
     * @param params CLI handler parameters object
     * @param sessCfg Session config with credentials for basic or cert auth
     * @param profilePath JSON path of profile containing tokenType
     * @returns True if auth handler was found and token was fetched
     */
    private static fetchTokenForSessCfg;
    /**
     * Helper function that retrieves token value that will be auto-stored into session config
     * @param opts Set of options required to fetch the token value to be auto-stored
     * @returns True if auth handler was found and token was fetched
     */
    private static _fetchTokenForSessCfg;
}
