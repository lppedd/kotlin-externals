import { AbstractCredentialManager, SecureCredential } from "./abstract/AbstractCredentialManager";
/**
 * **NOTE** THIS CLASS SHOULD NOT BE EXPORTED FOR PUBLIC CONSUMPTION.
 *
 * This class is the fallback class when a credential manager fails to initialize.
 * All methods in this class must throw te error passed in by the constructor.
 */
export declare class InvalidCredentialManager extends AbstractCredentialManager {
    protected readonly service: string;
    private readonly causeError;
    /**
     * Construct the credential manager object.
     * @param service A service that needs to be passed to the superclass
     * @param causeError The load failure that has occurred
     */
    constructor(service: string, causeError: Error);
    protected deleteCredentials(account: string): Promise<void>;
    protected loadCredentials(account: string, optional?: boolean): Promise<SecureCredential>;
    protected saveCredentials(account: string, credentials: SecureCredential): Promise<void>;
}
