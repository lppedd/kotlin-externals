import { AbstractProfileManagerFactory } from "../../../profiles";
import { CliProfileManager, ICommandProfileTypeConfiguration } from "../../../cmd/";
import { ImperativeApi } from "../api/ImperativeApi";
/**
 * The imperative profile manager factory returns instances of the cli profile manager
 * @export
 * @class ProfileManagerFactory
 * @extends {AbstractProfileManagerFactory<ICommandProfileTypeConfiguration>}
 */
export declare class ImperativeProfileManagerFactory extends AbstractProfileManagerFactory<ICommandProfileTypeConfiguration> {
    private mImperativeApi;
    constructor(imperativeApi: ImperativeApi);
    /**
     * Returns a instance of the CliProfileManager
     * @param {string} type - The profile type you want to manage.
     * @returns {CliProfileManager} - The profile manager instance
     * @memberof ProfileManagerFactory
     */
    getManager(type: string): CliProfileManager;
}
