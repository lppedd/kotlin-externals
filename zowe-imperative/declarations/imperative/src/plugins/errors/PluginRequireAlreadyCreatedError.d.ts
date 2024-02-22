import { ImperativeError } from "../../../../error";
/**
 * This error is thrown when a second call to {@link PluginRequireProvider.createPluginHooks} has
 * been made without destroying a previous hook call.
 */
export declare class PluginRequireAlreadyCreatedError extends ImperativeError {
    constructor();
}
