import { ImperativeError } from "../../../error";
/**
 * This class represents an error thrown when a null singleton {@link AppSettings} object is referenced.
 */
export declare class SettingsNotInitialized extends ImperativeError {
    constructor();
}
