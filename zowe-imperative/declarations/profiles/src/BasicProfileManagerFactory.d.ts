import { AbstractProfileManagerFactory } from "./abstract/AbstractProfileManagerFactory";
import { IProfileTypeConfiguration } from "./doc/config/IProfileTypeConfiguration";
import { BasicProfileManager } from "./BasicProfileManager";
/**
 * A basic profile mananger factory - returns instances of profile managers depending on the types passed.
 * @export
 * @class BasicProfileManagerFactory
 * @extends {AbstractProfileManagerFactory<IProfileTypeConfiguration>}
 */
export declare class BasicProfileManagerFactory extends AbstractProfileManagerFactory<IProfileTypeConfiguration> {
    /**
     * The root directory where the profiles will be found.
     * @private
     * @type {string}
     * @memberof BasicProfileManagerFactory
     */
    private mProfilesRootDirectory;
    /**
     * Type configurations for the basic profile manager
     * @private
     * @type {IProfileTypeConfiguration[]}
     * @memberof BasicProfileManagerFactory
     */
    private mTypeConfigurations;
    /**
     * Creates an instance of BasicProfileManagerFactory.
     * @param {string} profilesRootDirectory - The root directory to find your profiles
     * @memberof BasicProfileManagerFactory
     */
    constructor(profilesRootDirectory: string, typeConfigurations?: IProfileTypeConfiguration[]);
    /**
     * Returns a new instance of the basic profile manager for the type.
     * @param {string} type - the profile type to manager.
     * @returns {BasicProfileManager<IProfileTypeConfiguration>} - The profile manager instance for the type.
     * @memberof BasicProfileManagerFactory
     */
    getManager(type: string): BasicProfileManager<IProfileTypeConfiguration>;
    /**
     * Accessor for the profiles root directory
     * @readonly
     * @private
     * @type {string}
     * @memberof BasicProfileManagerFactory
     */
    private get profilesRootDirectory();
    /**
     * Accessor for the type configurations
     * @readonly
     * @private
     * @type {IProfileTypeConfiguration[]}
     * @memberof BasicProfileManagerFactory
     */
    private get typeConfigurations();
}
