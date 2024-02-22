@file:JsModule("@zowe/imperative")

package zowe.imperative.security.errors

import js.errors.JsError
import zowe.imperative.error.ImperativeError
import zowe.imperative.security.CredentialManagerFactory
import zowe.imperative.security.InvalidCredentialManager

/**
 * This class represents the error thrown by methods of the [InvalidCredentialManager] when
 * initialized by [CredentialManagerFactory.initialize]
 */
external class BadCredentialManagerError : ImperativeError {
  /**
   * Construct the error referencing a specific cause error.
   *
   * @param causeError The error that caused the load failure.
   */
  constructor(causeError: JsError)
}
