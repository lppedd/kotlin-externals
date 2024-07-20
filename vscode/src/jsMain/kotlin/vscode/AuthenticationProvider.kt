package vscode

import js.array.ReadonlyArray

/**
 * A provider for performing authentication to a service.
 */
external interface AuthenticationProvider {
  /**
   * An [Event] which fires when the array of sessions has changed, or data
   * within a session has changed.
   */
  val onDidChangeSessions: Event<AuthenticationProviderAuthenticationSessionsChangeEvent>

  /**
   * Get a list of sessions.
   *
   * @param scopes An optional list of scopes. If provided, the sessions returned should match
   *   these permissions, otherwise all sessions should be returned.
   * @return A promise that resolves to an array of authentication sessions.
   */
  fun getSessions(scopes: ReadonlyArray<String> = definedExternally): Thenable<ReadonlyArray<AuthenticationSession>>

  /**
   * Prompts a user to login.
   *
   * If login is successful, the onDidChangeSessions event should be fired.
   *
   * If login fails, a rejected promise should be returned.
   *
   * If the provider has specified that it does not support multiple accounts,
   * then this should never be called if there is already an existing session matching these
   * scopes.
   *
   * @param scopes A list of scopes, permissions, that the new session should be created with.
   * @return A promise that resolves to an authentication session.
   */
  fun createSession(scopes: ReadonlyArray<String>): Thenable<AuthenticationSession>

  /**
   * Removes the session corresponding to session id.
   *
   * If the removal is successful, the onDidChangeSessions event should be fired.
   *
   * If a session cannot be removed, the provider should reject with an error message.
   *
   * @param sessionId The id of the session to remove.
   */
  fun removeSession(sessionId: String): Thenable<Unit>
}
