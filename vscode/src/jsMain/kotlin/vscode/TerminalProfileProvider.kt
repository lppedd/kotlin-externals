package vscode

/**
 * Provides a terminal profile for the contributed terminal profile when launched via the UI or
 * command.
 */
external interface TerminalProfileProvider {
  /**
   * Provide the terminal profile.
   * @param token A cancellation token that indicates the result is no longer needed.
   * @return The terminal profile.
   */
  fun provideTerminalProfile(token: CancellationToken): ProviderResult<TerminalProfile>
}
