@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.security

import js.promise.Promise
import node.Module
import zowe.imperative.error.ImperativeError
import zowe.imperative.security.abstract.AbstractCredentialManager
import zowe.imperative.security.abstract.SecureCredential

/**
 * Keytar - Securely store user credentials in the system keychain
 */
external class KeytarCredentialManager : AbstractCredentialManager {
  /**
   * Pass-through to the superclass constructor.
   *
   * @param service The service string to send to the superclass constructor.
   * @param displayName The display name for this credential manager to send to the superclass constructor
   */
  constructor(service: String, displayName: String)

  /**
   * Calls the keytar deletePassword service with {@link DefaultCredentialManager#service} and the
   * account passed to the function by Imperative.
   *
   * @param account The account for which to delete the password
   *
   * @return A promise that the function has completed.
   *
   * @throws ImperativeError if keytar is not defined.
   * @throws ImperativeError when keytar.deletePassword returns false.
   */
  override fun deleteCredentials(account: String): Promise<Unit>

  /**
   * Calls the keytar getPassword service with {@link DefaultCredentialManager#service} and the
   * account passed to the function by Imperative.
   *
   * @param account The account for which to get credentials
   * @param optional Set to true if failure to find credentials should be ignored
   * @return A promise containing the credentials stored in keytar.
   *
   * @throws ImperativeError if keytar is not defined.
   * @throws ImperativeError when keytar.getPassword returns null or undefined.
   */
  override fun loadCredentials(
    account: String,
    optional: Boolean,
  ): Promise<SecureCredential>

  /**
   * Calls the keytar setPassword service with {@link DefaultCredentialManager#service} and the
   * account and credentials passed to the function by Imperative.
   *
   * @param account The account to set credentials
   * @param credentials The credentials to store
   *
   * @return A promise that the function has completed.
   *
   * @throws ImperativeError if keytar is not defined.
   */
  override fun saveCredentials(
    account: String,
    credentials: SecureCredential,
  ): Promise<Unit>

  companion object {
    /**
     * Reference to the lazily loaded keytar module.
     */
    var keytar: KeytarModule

    fun getSecurityModules(
      moduleName: String,
      isTheia: Boolean,
    ): Module?
  }
}
