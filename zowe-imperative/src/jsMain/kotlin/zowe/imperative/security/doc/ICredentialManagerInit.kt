package zowe.imperative.security.doc

import zowe.imperative.security.DefaultCredentialManager
import zowe.imperative.security.abstract.AbstractCredentialManager
import kotlin.js.plain.JsPlainObject
import kotlin.ts.Union

@JsPlainObject
external interface ICredentialManagerInit {
  /**
   * The service name to be used in the security manager. This value is useful for credential
   * managers that require a service ID (such as the default manager which implements Keytar).
   */
  var service: String

  /**
   * A class that extends [AbstractCredentialManager] that will be instantiated and used as
   * the actual credential manager. If a string is passed, we will attempt to load the module
   * specified in the string as a class that extends the __AbstractCredentialManager__.
   * If the class imported doesn't extend the abstract class, we will throw an error.
   *
   * Defaults to the [DefaultCredentialManager] (uses keytar)
   */
  var Manager: Union<String, ICredentialManagerConstructor>?

  /**
   * The display name of the credential manager in use. Used in messaging/debugging and if the
   * credential manager is managing secure profile fields via the imperative "CliProfileManager",
   * then profiles will display "managed by ${displayName}" for secure fields in the profile yaml
   * files. Defaults to the service name if not provided.
   *
   * Note: If the credential manager class contains a hard-coded display name, this parameter is
   * ignored in favor of using their explicit name
   */
  var displayName: String?

  /**
   * If true, will default to using the invalid credential manager (all API calls throw errors) if
   * initialization of the credential manager fails.
   */
  var invalidOnFailure: Boolean?
}
