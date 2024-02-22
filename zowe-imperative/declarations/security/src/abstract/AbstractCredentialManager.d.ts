/**
 * String credential
 */
export declare type SecureCredential = string;
export interface AbstractCredentialManager {
    /**
     * This is an optional method that your Credential Manager may choose to implement. If present, it
     * will be called by the {@link CredentialManagerFactory.initialize} function to allow your
     * manager to do more initialization after the class has become instantiated.
     *
     * Also, since asynchronous operations are not well handled in the constructor, this allows your
     * Credential Manager to perform any asynchronous operations needed. Your initialize method just
     * has to return the promise and we'll handle the rest.
     *
     * @returns {Promise<void>} A promise of the completion of your initialize function.
     */
    initialize?(): Promise<void>;
}
/**
 * The abstract credential manager defines basic methods that must be implemented by any credential manager
 * provided to Imperative. The abstract class is used by various methods for proper typing information.
 *
 * All credential managers will be instantiated by {@link CredentialManagerFactory.initialize} and are
 * expected to extend the __AbstractCredentialManager__. This is enforced by requiring your class constructor
 * to follow the implementation rules specified by the {@link ICredentialManagerConstructor}.
 *
 * The constructor signature that the {@link ICredentialManagerConstructor} specifies will always be identical to
 * the constructor signature of the __AbstractCredentialManager__ superclass.
 *
 * Imperative will provide your CLI with a default manager, {@link DefaultCredentialManager}. If the default provided
 * is not to your liking, you can provide your own manager as a parameter on {@link Imperative.init} at startup. This is
 * done by providing it as part of the {@link IImperativeConfig.overrides} object.
 *
 * @see {@link IImperativeOverrides.CredentialManager}
 *
 */
export declare abstract class AbstractCredentialManager {
    protected readonly service: string;
    private displayName;
    /**
     * This class can not be directly instantiated so the constructor is protected. All extending classes must make a call
     * to `super(...)` with the expected parameters.
     *
     * @param {string} service The service that the Credential Manager is running under. Imperative will set this to the
     *                         cliName
     * @param {string} displayName The display name of this manager. Used in messaging/logging.
     */
    protected constructor(service: string, displayName: string);
    /**
     * @returns {string} - the display name of this manager. Use in logging/messaging.
     */
    get name(): string;
    /**
     * Delete credentials for an account managed by the credential manager.
     *
     * @param {string} account The account (or profile identifier) associated with credentials
     *
     * @returns {Promise<void>}
     */
    delete(account: string): Promise<void>;
    /**
     * Load credentials for an account managed by the credential manager.
     *
     * @param {string} account The account (or profile identifier) associated with credentials
     * @param {boolean} optional Set to true if failure to find credentials should be ignored
     *
     * @returns {Promise<string>} The username and password associated with the account.
     */
    load(account: string, optional?: boolean): Promise<string>;
    /**
     * Save credentials for an account managed by the credential manager.
     *
     * @param {string} account The account (or profile identifier) associated with credentials
     * @param {string} secureValue Value to be securely stored
     *
     * @returns {Promise<void>}
     *
     * @throws {@link ImperativeError} - when the secure field is missing.
     */
    save(account: string, secureValue: string): Promise<void>;
    /**
     * @returns {string} - Additional details for credential manager errors,
     * if the current CredentialManager has provided any.
     */
    secureErrorDetails(): string | undefined;
    /**
     * @returns {string[]} - List of possible solutions for credential manager errors.
     * Override this in your CredentialManager to supply more detailed error messages.
     */
    protected get possibleSolutions(): string[] | undefined;
    /**
     * Called by Imperative to delete the credentials of a profile.
     *
     * @param {string} account - A user account (or profile identifier)
     *
     * @returns {Promise<void>}
     *
     * @throws {ImperativeError} - when the delete operation failed. The error object should have details about what failed.
     */
    protected abstract deleteCredentials(account: string): Promise<void>;
    /**
     * Called by Imperative to load the credentials of a profile.
     *
     * @param {string} account - A user account (or profile identifier)
     * @param {boolean} optional - Set to true if failure to find credentials should be ignored
     *
     * @returns {Promise<SecureCredential>} - A base64 encoded username:password string
     *
     * @throws {ImperativeError} - when the get operation failed. The error object should have details about what failed.
     */
    protected abstract loadCredentials(account: string, optional?: boolean): Promise<SecureCredential>;
    /**
     * Called by Imperative to save the credentials for a profile.
     *
     * @param {string} account - A user account (or profile identifier)
     * @param {SecureCredential} credentials - A base64 encoded username:password string
     *
     * @returns {Promise<void>}
     *
     * @throws {ImperativeError} - when the set operation failed. The error object should have details about what failed.
     */
    protected abstract saveCredentials(account: string, credentials: SecureCredential): Promise<void>;
}
