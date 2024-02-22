import { ImperativeError } from "../../../error";
/**
 * This class represents the error thrown by methods of the {@link InvalidCredentialManager}
 * when initialized by {@link CredentialManagerFactory.initialize}
 */
export declare class BadCredentialManagerError extends ImperativeError {
    /**
     * Construct the error referencing a specific cause error.
     * @param causeError The error that caused the load failure.
     */
    constructor(causeError: Error);
}
