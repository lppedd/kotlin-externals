import { ImperativeError } from "../../../error/";
/**
 * This class represents an error that is thrown when a second settings singleton attempts to initialize.
 */
export declare class SettingsAlreadyInitialized extends ImperativeError {
    constructor();
}
