package vscode

/**
 * A provider that enables detection and handling of links within terminals.
 */
external interface TerminalLinkProvider<T : TerminalLink /* default is TerminalLink */> {
  /**
   * Provide terminal links for the given context. Note that this can be called multiple times
   * even before previous calls resolve, make sure to not share global objects (eg. `RegExp`)
   * that could have problems when asynchronous usage may overlap.
   *
   * @param context Information about what links are being provided for.
   * @param token A cancellation token.
   * @return A list of terminal links for the given line.
   */
  fun provideTerminalLinks(
    context: TerminalLinkContext,
    token: CancellationToken,
  ): ProviderResult<Array<T>>

  /**
   * Handle an activated terminal link.
   *
   * @param link The link to handle.
   */
  fun handleTerminalLink(link: T): ProviderResult<Unit>
}
