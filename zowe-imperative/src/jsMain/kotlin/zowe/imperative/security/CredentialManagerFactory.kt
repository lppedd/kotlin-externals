@file:JsModule("@zowe/imperative")

package zowe.imperative.security

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.Imperative
import zowe.imperative.imperative.doc.IImperativeOverrides
import zowe.imperative.imperative.plugins.PluginManagementFacility
import zowe.imperative.security.abstract.AbstractCredentialManager
import zowe.imperative.security.doc.ICredentialManagerInit
import zowe.imperative.settings.AppSettings

/**
 * This is a wrapper class that controls access to the credential manager used within the Imperative
 * framework. All calls to the credential manager done by Imperative must go through this class for
 * security reasons.
 */
external class CredentialManagerFactory {
  companion object {
    /**
     * Initialize the credential manager, then lock the door and throw away the key. This method can
     * only be called once and should be called by [Imperative.init] immediately after the CLI
     * configuration has been loaded.
     *
     * This is where any Credential Manager your cli provides will be initialized. First Imperative
     * will instantiate your manager (or the [DefaultCredentialManager] if none was provided
     * to [Imperative.init]) and will then call your class's initialize method.
     *
     * ### Dynamic Import of Module
     *
     * This method will perform a dynamic import of your [IImperativeOverrides.CredentialManager]
     * module when the Manager parameter is passed as a string.
     * If anything goes wrong during this import or if the module that was exported doesn't
     * extend the [AbstractCredentialManager], this method will throw an error.
     *
     * ### Immutable Class Creation
     *
     * After this method is complete, the instantiated credential manager will no longer allow
     * changes to its direct variable assignments. This means that even your class can only change
     * the values of it's direct properties in the constructor and the initialize method. However,
     * this does not prevent you from changing values of properties of one of your classes objects.
     *
     * For example, after initialization, your class can not do something like this: `this.someProp = 5`.
     * This will result in a JavaScript "Cannot assign to read only property" exception
     * because your class is immutable. You still will be able to do stuff like this if someProp was
     * already an object: `this.someProp.someValue = 5`. This occurs because while Imperative marks
     * your class as immutable (using Object.freeze) the underlying `this.someProp` object is still
     * mutable.
     *
     * ### Plugin Provided Overrides
     *
     * This class attempts to handle a failed plugin override as well. If this method errors out
     * because of problems with the `Manager` parameter, it will check to see if the override was
     * provided by a plugin loaded in the [PluginManagementFacility]. The check is done by
     * looking at the value present in the [AppSettings.getSettings] of the singleton present in
     * [AppSettings.instance]
     *
     * If it was detected that the Manager was not provided by a plugin, the error encountered
     * is thrown to the calling function.
     *
     * If the initialization option "invalidOnFailure" is true, we will default to using the
     * [InvalidCredentialManager] which implements the [AbstractCredentialManager] methods.
     * All these methods have been designed to throw the error we caught in the
     * **CredentialManagerFactory.initialize** function.
     *
     * @param params Initialization parameters, see interface for details.
     * @throws ImperativeError When it has been detected that this method has been called
     *   before. It is important that this method only executes once.
     * @throws ImperativeError When the module specified by the Manager string references a
     *   module that does not extend [AbstractCredentialManager] and the override was not
     *   provided by a plugin. When the override is provided by a plugin, we will fall back to the
     *   [InvalidCredentialManager].
     * @see IImperativeOverrides.CredentialManager
     */
    fun initialize(params: ICredentialManagerInit): Promise<Unit>

    /**
     * @return The credential manager that Imperative should use to retrieve user credentials.
     * @throws ImperativeError When the Credential Manager has not been initialized yet.
     */
    val manager: AbstractCredentialManager

    /**
     * The credential manager may not be initialized if Keytar (or a plugin override) is not
     * present. In this scenario, the default is to store credentials in plain text.
     *
     * @return True if the credential manager has been initialized.
     */
    val initialized: Boolean
  }
}
