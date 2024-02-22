package vscode

/**
 * A code lens provider adds [Command]s to source text. The commands will be shown
 * as dedicated horizontal lines in between the source text.
 */
external interface CodeLensProvider<T : CodeLens /* default is CodeLens */> {
  /**
   * An optional event to signal that the code lenses from this provider have changed.
   */
  var onDidChangeCodeLenses: Event<Unit>?

  /**
   * Compute a list of [CodeLens]s. This call should return as fast as possible and if
   * computing the commands is expensive implementors should only return code lens objects with the
   * range set and implement [CodeLensProvider.resolveCodeLens].
   *
   * @param document The document in which the command was invoked.
   * @param token A cancellation token.
   * @return An array of code lenses or a thenable that resolves to such. The lack of a result can be
   *   signaled by returning `undefined`, `null`, or an empty array.
   */
  fun provideCodeLenses(
    document: TextDocument,
    token: CancellationToken,
  ): ProviderResult<Array<T>>

  /**
   * This function will be called for each visible code lens, usually when scrolling and after
   * calls to [CodeLensProvider.provideCodeLenses].
   *
   * @param codeLens Code lens that must be resolved.
   * @param token A cancellation token.
   * @return The given, resolved code lens or thenable that resolves to such.
   */
  fun resolveCodeLens(
    codeLens: T,
    token: CancellationToken,
  ): ProviderResult<T>
}
