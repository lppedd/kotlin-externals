import { AbstractProfileManager } from "./AbstractProfileManager";
import { IProfileTypeConfiguration } from "../doc/config/IProfileTypeConfiguration";
import { IProfileManagerFactory } from "../doc/api/IProfileManagerFactory";
/**
 * Abstract profile manager (implemented by imperative, etc.)
 * @export
 * @abstract
 * @class AbstractProfileManagerFactory
 * @implements {IProfileManagerFactory<T>}
 * @template T
 */
export declare abstract class AbstractProfileManagerFactory<T extends IProfileTypeConfiguration> implements IProfileManagerFactory<T> {
    /**
     * Returns and instance of the profile manager for the type specified.
     * @abstract
     * @param {string} type - the profile type
     * @returns {AbstractProfileManager<T>} - The manager
     * @memberof AbstractProfileManagerFactory
     */
    abstract getManager(type: string): AbstractProfileManager<T>;
}
