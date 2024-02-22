import { AbstractCredentialManager } from "./abstract/AbstractCredentialManager";
import { ICredentialManagerInit } from "./doc/ICredentialManagerInit";
/**
 * This is a wrapper class that controls access to the credential manager used within
 * the Imperative framework. All calls to the credential manager done by Imperative
 * must go through this class for security reasons.
 */
export declare class CredentialManagerFactory {
    /**
     * Initialize the credential manager, then lock the door and throw away the
     * key. This method can only be called once and should be called by {@link Imperative.init}
     * immediately after the CLI configuration has been loaded.
     *
     * This is where any Credential Manager your cli provides will be initialized. First
     * Imperative will instantiate your manager (or the {@link DefaultCredentialManager} if none was provided to
     * {@link Imperative.init}) and will then call your class's initialize method.
     *
     * ### Dynamic Import of Module
     *
     * This method will perform a dynamic import of your {@link IImperativeOverrides.CredentialManager} module when the
     * Manager parameter is passed as a string. If anything goes wrong during this import or if the module that was exported
     * doesn't extend the {@link AbstractCredentialManager}, this method will throw an error.
     *
     * @see {@link IImperativeOverrides.CredentialManager}
     *
     * ### Immutable Class Creation
     *
     * After this method is complete, the instantiated credential manager will no longer allow changes
     * to it's direct variable assignments. This means that even your class can only change the values of it's direct
     * properties in the constructor and the initialize method. However, this does not prevent you from changing values
     * of properties of one of your classes objects.
     *
     * For example, after initialization, your class can not do something like this: `this.someProp = 5`. This will result
     * in a JavaScript "Cannot assign to read only property" exception because your class is immutable.
     * You still will be able to do stuff like this if someProp was already an object: `this.someProp.someValue = 5`. This
     * occurs because while Imperative marks your class as immutable (using Object.freeze) the underlying `this.someProp`
     * object is still mutable.
     *
     * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/freeze
     *
     * ### Plugin Provided Overrides
     *
     * This class attempts to handle a failed plugin override as well. If this method errors out because of problems
     * with the `Manager` parameter, it will check to see if the override was provided by a plugin loaded in the
     * {@link PluginManagementFacility}. The check is done by looking at the value present in the {@link AppSettings#settings}
     * of the singleton present in {@link AppSettings.instance}
     *
     * If the it was detected that the Manager was not provided by a plugin, the error encountered is thrown to
     * the calling function.
     *
     * If the initialization option "invalidOnFailure" is true, we will default to using the {@link InvalidCredentialManager}
     * which implements the {@link AbstractCredentialManager} methods. All these methods have been designed to throw
     * the error we caught in the **CredentialManagerFactory.initialize** function.
     *
     * @param {ICredentialManagerInit} params - Initialization parameters, see interface for details.
     *
     * @throws {@link ImperativeError} When it has been detected that this method has been called before.
     *         It is important that this method only executes once.
     *
     * @throws {@link ImperativeError} When the module specified by the Manager string references a module that
     *         does not extend {@link AbstractCredentialManager} and the override was not provided by a plugin.
     *         When the override is provided by a plugin, we will fall back to the {@link InvalidCredentialManager}.
     */
    static initialize(params: ICredentialManagerInit): Promise<void>;
    /**
     * Static singleton instance of an instantiated {@link AbstractCredentialManager}
     *
     * @private
     */
    private static mManager;
    /**
     * @returns {AbstractCredentialManager} - The credential manager that Imperative should use to
     *   retrieve user credentials.
     *
     * @throws {ImperativeError} - When the Credential Manager has not been initialized yet.
     */
    static get manager(): AbstractCredentialManager;
    /**
     * The credential manager may not be initialized if Keytar (or a plugin override) is not present. In this
     * scenario, the default is to store credentials in plain text.
     * @returns {boolean} - True if the credential manager has been initialized.
     */
    static get initialized(): boolean;
}
