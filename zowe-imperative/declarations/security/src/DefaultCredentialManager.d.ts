import { AbstractCredentialManager, SecureCredential } from "./abstract/AbstractCredentialManager";
/**
 * Default Credential Manager is our implementation of the Imperative Credential Manager. This manager invokes methods
 * created by the keytar utility (https://www.npmjs.com/package/keytar) to access the secure credential vault on the
 * user's machine.
 *
 * ### Keychains Used by Keytar
 *
 * | OS | Vault |
 * |----|----------|
 * | Windows | Credential Vault |
 * | macOS | Keychain |
 * | Linux | Secret Sevice API/libsecret |
 *
 * ### Keytar must be installed by the app using imperative (like zowe-cli).
 *
 * On Linux, Keytar will not work out of the box without some additional
 * configuration to install libsecret. Keytar provides the following
 * documentation for Linux users to install libsecret:
 *
 * ---
 *
 * Depending on your distribution, you will need to run the following command:
 *
 * - Debian/Ubuntu: `sudo apt-get install libsecret-1-dev`
 * - Red Hat-based: `sudo yum install libsecret-devel`
 * - Arch Linux: `sudo pacman -S libsecret`
 */
export declare class DefaultCredentialManager extends AbstractCredentialManager {
    /**
     * The service name for our built-in credential manager.
     */
    static readonly SVC_NAME = "Zowe";
    /**
     * Reference to the lazily loaded keytar module.
     */
    private keytar;
    /**
     * Errors that occurred while loading keytar will be stored in here.
     *
     * Every method of this class should call the {@link checkForKeytar} method before proceeding. It
     * is this method that will check for keytar and throw this error if it was detected that keytar
     * wasn't loaded.
     *
     * @private
     */
    private loadError;
    /**
     * Combined list of services that the plugin will go through
     */
    private allServices;
    /**
     * Maximum credential length allowed by Windows 7 and newer.
     *
     * We don't support older versions of Windows where the limit is 512 bytes.
     */
    private readonly WIN32_CRED_MAX_STRING_LENGTH;
    /**
     * Pass-through to the superclass constructor.
     *
     * @param {string} service The service string to send to the superclass constructor.
     * @param {string} displayName The display name for this credential manager to send to the superclass constructor
     */
    constructor(service: string, displayName?: string);
    /**
     * Called by {@link CredentialManagerFactory.initialize} before the freeze of the object. This
     * gives us a chance to load keytar into the class before we are locked down. If a load failure
     * occurs, we will store the error and throw it once a method of this class tries to execute. This
     * prevents a missing keytar module from stopping all operation of the cli.
     *
     * In the future, we could go even further to have keytar load into a sub-object of this class so
     * that the load doesn't hold up the main class execution.
     *
     * @returns {Promise<void>} A promise that the function has completed.
     */
    initialize(): Promise<void>;
    protected get possibleSolutions(): string[];
    /**
     * Calls the keytar deletePassword service with {@link DefaultCredentialManager#service} and the
     * account passed to the function by Imperative.
     *
     * @param {string} account The account for which to delete the password
     *
     * @returns {Promise<void>} A promise that the function has completed.
     *
     * @throws {@link ImperativeError} if keytar is not defined.
     */
    protected deleteCredentials(account: string): Promise<void>;
    /**
     * Calls the keytar getPassword service with {@link DefaultCredentialManager#service} and the
     * account passed to the function by Imperative.
     *
     * @param {string} account The account for which to get credentials
     * @param {boolean} optional Set to true if failure to find credentials should be ignored
     *
     * @returns {Promise<SecureCredential>} A promise containing the credentials stored in keytar.
     *
     * @throws {@link ImperativeError} if keytar is not defined.
     * @throws {@link ImperativeError} when keytar.getPassword returns null or undefined.
     */
    protected loadCredentials(account: string, optional?: boolean): Promise<SecureCredential>;
    /**
     * Calls the keytar setPassword service with {@link DefaultCredentialManager#service} and the
     * account and credentials passed to the function by Imperative.
     *
     * @param {string} account The account to set credentials
     * @param {SecureCredential} credentials The credentials to store
     *
     * @returns {Promise<void>} A promise that the function has completed.
     *
     * @throws {@link ImperativeError} if keytar is not defined.
     */
    protected saveCredentials(account: string, credentials: SecureCredential): Promise<void>;
    /**
     * The default service name for storing credentials.
     */
    private get defaultService();
    /**
     * This function is called before the {@link deletePassword}, {@link getPassword}, and
     * {@link setPassword} functions. It will check if keytar is not null and will throw an error
     * if it is.
     *
     * The error thrown will be the contents of {@link loadError} or a new {@link ImperativeError}.
     * The former error will be the most common one as we expect failures during the load since keytar
     * is optional. The latter error will indicate that some unknown condition has happened so we will
     * create a new ImperativeError with the report suppressed. The report is suppressed because it
     * may be possible that a detailed report could capture a username and password, which would
     * probably be a bad thing.
     *
     * @private
     *
     * @throws {@link ImperativeError} when keytar is null or undefined.
     */
    private checkForKeytar;
    /**
     * Helper to load credentials from vault that supports values longer than
     * `DefaultCredentialManager.WIN32_CRED_MAX_STRING_LENGTH` on Windows.
     * @private
     * @param service The string service name.
     * @param account The string account name.
     * @returns A promise for the credential string.
     */
    private getCredentialsHelper;
    /**
     * Helper to save credentials to vault that supports values longer than
     * `DefaultCredentialManager.WIN32_CRED_MAX_STRING_LENGTH` on Windows.
     * @private
     * @param service The string service name.
     * @param account The string account name.
     * @param value The string credential.
     */
    private setCredentialsHelper;
    private deleteCredentialsHelper;
    private getMissingEntryMessage;
}
