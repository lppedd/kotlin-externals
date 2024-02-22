@file:JsModule("@zowe/imperative")

package zowe.imperative.security

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.security.abstract.AbstractCredentialManager
import zowe.imperative.security.abstract.SecureCredential

/**
 * Default Credential Manager is our implementation of the Imperative Credential Manager. This
 * manager invokes methods created by the keytar utility (https://www.npmjs.com/package/keytar) to
 * access the secure credential vault on the user's machine.
 *
 * ### Keychains Used by Keytar
 * | OS      | Vault                       |
 * |---------|-----------------------------|
 * | Windows | Credential Vault            |
 * | macOS   | Keychain                    |
 * | Linux   | Secret Sevice API/libsecret |
 *
 * ### Keytar must be installed by the app using imperative (like zowe-cli).
 *
 * On Linux, Keytar will not work out of the box without some additional configuration to install
 * libsecret. Keytar provides the following documentation for Linux users to install libsecret:
 *
 * ---
 *
 * Depending on your distribution, you will need to run the following command:
 * - Debian/Ubuntu: `sudo apt-get install libsecret-1-dev`
 * - Red Hat-based: `sudo yum install libsecret-devel`
 * - Arch Linux: `sudo pacman -S libsecret`
 */
external class DefaultCredentialManager : AbstractCredentialManager {
  /**
   * Pass-through to the superclass constructor.
   *
   * @param service The service string to send to the superclass constructor.
   * @param displayName The display name for this credential manager to send to the
   *   superclass constructor
   */
  constructor(service: String, displayName: String = definedExternally)

  /**
   * Called by [CredentialManagerFactory.initialize] before the freeze of the object. This
   * gives us a chance to load keytar into the class before we are locked down. If a load failure
   * occurs, we will store the error and throw it once a method of this class tries to execute. This
   * prevents a missing keytar module from stopping all operation of the cli.
   *
   * In the future, we could go even further to have keytar load into a sub-object of this class so
   * that the load doesn't hold up the main class execution.
   *
   * @return A promise that the function has completed.
   */
  override fun initialize(): Promise<Unit>

  override val possibleSolutions: Array<String>

  /**
   * Calls the keytar deletePassword service with [DefaultCredentialManager.service]and the
   * account passed to the function by Imperative.
   *
   * @param account The account for which to delete the password
   * @return A promise that the function has completed.
   * @throws ImperativeError if keytar is not defined.
   */
  override fun deleteCredentials(account: String): Promise<Unit>

  /**
   * Calls the keytar getPassword service with [DefaultCredentialManager.service] and the
   * account passed to the function by Imperative.
   *
   * @param account The account for which to get credentials
   * @param optional Set to true if failure to find credentials should be ignored
   * @return A promise containing the credentials stored in keytar.
   * @throws ImperativeError if keytar is not defined.
   * @throws ImperativeError when keytar.getPassword returns null or undefined.
   */
  override fun loadCredentials(
    account: String,
    optional: Boolean,
  ): Promise<SecureCredential>

  /**
   * Calls the keytar setPassword service with [DefaultCredentialManager.service] and the
   * account and credentials passed to the function by Imperative.
   *
   * @param account The account to set credentials
   * @param credentials The credentials to store
   * @return A promise that the function has completed.
   * @throws ImperativeError if keytar is not defined.
   */
  override fun saveCredentials(
    account: String,
    credentials: SecureCredential,
  ): Promise<Unit>

  companion object {
    /**
     * The service name for our built-in credential manager.
     */
    @JsString("Zowe")
    val SVC_NAME: String
  }
}
