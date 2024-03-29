package vscode

/**
 * Optional options to be used when calling [vscode.authentication.getSession] with the flag `forceNewSession`.
 */
external interface AuthenticationForceNewSessionOptions {
  /**
   * An optional message that will be displayed to the user when we ask to re-authenticate. Providing additional context
   * as to why you are asking a user to re-authenticate can help increase the odds that they will accept.
   */
  var detail: String?
}
