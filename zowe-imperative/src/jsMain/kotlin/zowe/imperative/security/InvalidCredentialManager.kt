@file:JsModule("@zowe/imperative")

package zowe.imperative.security

import js.promise.Promise
import zowe.imperative.security.abstract.AbstractCredentialManager
import zowe.imperative.security.abstract.SecureCredential

/**
 * **NOTE** THIS CLASS SHOULD NOT BE EXPORTED FOR PUBLIC CONSUMPTION.
 *
 * This class is the fallback class when a credential manager fails to initialize. All methods in
 * this class must throw te error passed in by the constructor.
 */
external class InvalidCredentialManager : AbstractCredentialManager {
  /**
   * Construct the credential manager object.
   *
   * @param service A service that needs to be passed to the superclass
   * @param causeError The load failure that has occurred
   */
  constructor(service: String, causeError: Error)

  override val service: String

  override fun deleteCredentials(account: String): Promise<Unit>

  override fun loadCredentials(
    account: String,
    optional: Boolean,
  ): Promise<SecureCredential>

  // Note(Edoardo): artificial overload
  fun loadCredentials(account: String): Promise<SecureCredential>

  override fun saveCredentials(
    account: String,
    credentials: SecureCredential,
  ): Promise<Unit>
}
