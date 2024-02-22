import { ImperativeError } from "../../../../error";
/**
 * This error is thrown when a call to {@link PluginRequireProvider.destroyPluginHooks} has
 * been made without hooks in place.
 */
export declare class PluginRequireNotCreatedError extends ImperativeError {
    constructor();
}
