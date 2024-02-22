@file:JsModule("@zowe/imperative")

package zowe.imperative.security.abstract

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.imperative.Imperative
import zowe.imperative.imperative.doc.IImperativeConfig
import zowe.imperative.imperative.doc.IImperativeOverrides
import zowe.imperative.security.CredentialManagerFactory
import zowe.imperative.security.DefaultCredentialManager
import zowe.imperative.security.doc.ICredentialManagerConstructor

/**
 * The abstract credential manager defines basic methods that must be implemented by any credential
 * manager provided to Imperative. The abstract class is used by various methods for proper typing
 * information.
 *
 * All credential managers will be instantiated by [CredentialManagerFactory.initialize] and
 * are expected to extend the __AbstractCredentialManager__. This is enforced by requiring your
 * class constructor to follow the implementation rules specified by the [ICredentialManagerConstructor].
 *
 * The constructor signature that the [ICredentialManagerConstructor] specifies will always be
 * identical to the constructor signature of the __AbstractCredentialManager__ superclass.
 *
 * Imperative will provide your CLI with a default manager, [DefaultCredentialManager]. If the
 * default provided is not to your liking, you can provide your own manager as a parameter on
 * [Imperative.init] at startup. This is done by providing it as part of the [IImperativeConfig.overrides] object.
 *
 * @see IImperativeOverrides.CredentialManager
 */
open external class AbstractCredentialManager {
  /**
   * This class can not be directly instantiated so the constructor is protected. All extending
   * classes must make a call to `super(...)` with the expected parameters.
   *
   * @param service The service that the Credential Manager is running under. Imperative
   *   will set this to the cliName
   * @param displayName The display name of this manager. Used in messaging/logging.
   */
  constructor(service: String, displayName: String)

  /**
   * This is an optional method that your Credential Manager may choose to implement. If present, it
   * will be called by the {@link CredentialManagerFactory.initialize} function to allow your
   * manager to do more initialization after the class has become instantiated.
   *
   * Also, since asynchronous operations are not well handled in the constructor, this allows your
   * Credential Manager to perform any asynchronous operations needed. Your initialize method just
   * has to return the promise and we'll handle the rest.
   *
   * @return A promise of the completion of your initialize function.
   */
  open fun initialize(): Promise<Unit>

  open val service: String

  /**
   * The display name of this manager. Use in logging/messaging.
   */
  val name: String

  /**
   * Delete credentials for an account managed by the credential manager.
   *
   * @param account The account (or profile identifier) associated with credentials
   */
  fun delete(account: String): Promise<Unit>

  /**
   * Load credentials for an account managed by the credential manager.
   *
   * @param account The account (or profile identifier) associated with credentials
   * @param optional Set to true if failure to find credentials should be ignored
   * @return The username and password associated with the account.
   */
  fun load(
    account: String,
    optional: Boolean = definedExternally,
  ): Promise<String>

  /**
   * Save credentials for an account managed by the credential manager.
   *
   * @param account The account (or profile identifier) associated with credentials
   * @param secureValue Value to be securely stored
   * @throws ImperativeError when the secure field is missing.
   */
  fun save(
    account: String,
    secureValue: String,
  ): Promise<Unit>

  /**
   * @return Additional details for credential manager errors, if the current
   *   CredentialManager has provided any.
   */
  fun secureErrorDetails(): String?

  /**
   * List of possible solutions for credential manager errors.
   * Override this in your CredentialManager to supply more detailed error messages.
   */
  open val possibleSolutions: Array<String>?

  /**
   * Called by Imperative to delete the credentials of a profile.
   *
   * @param account A user account (or profile identifier)
   * @throws ImperativeError when the delete operation failed. The error object should have
   *   details about what failed.
   */
  open fun deleteCredentials(account: String): Promise<Unit>

  /**
   * Called by Imperative to load the credentials of a profile.
   *
   * @param account A user account (or profile identifier)
   * @param optional Set to true if failure to find credentials should be ignored
   * @return A base64 encoded username:password string
   * @throws ImperativeError when the get operation failed. The error object should have details
   *   about what failed.
   */
  open fun loadCredentials(
    account: String,
    optional: Boolean = definedExternally,
  ): Promise<SecureCredential>

  /**
   * Called by Imperative to save the credentials for a profile.
   *
   * @param account A user account (or profile identifier)
   * @param credentials A base64 encoded username:password string
   * @throws ImperativeError when the set operation failed. The error object should have details
   *   about what failed.
   */
  open fun saveCredentials(
    account: String,
    credentials: SecureCredential,
  ): Promise<Unit>
}
