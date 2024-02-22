package zowe.imperative.security.doc

import zowe.imperative.security.abstract.AbstractCredentialManager

/**
 * This interface defines the constructor for a credential manager. This is used by the TypeScript
 * compiler to verify that any class that wishes to be a Credential Manager adheres to the constructor
 * arguments sent to it.
 *
 * Your class will satisfy this interface when all the following are true:
 *  1. Your class extends [AbstractCredentialManager]
 *  2. Your constructor has less than or equal to the number of parameters specified in the interface
 *  3. Your constructor has matching parameter types for all parameters accepted
 */
typealias ICredentialManagerConstructor = (
  cliName: String,
  displayName: String,
) -> AbstractCredentialManager // new (cliName: string, displayName: string) => AbstractCredentialManager
