package vscode

import js.array.ReadonlyArray

/**
 * The selection range provider interface defines the contract between extensions and the "Expand and Shrink Selection" feature.
 */
external interface SelectionRangeProvider {
  /**
   * Provide selection ranges for the given positions.
   *
   * Selection ranges should be computed individually and independent for each position. The editor will merge
   * and deduplicate ranges but providers must return hierarchies of selection ranges so that a range
   * is contained ([Range.contains]) by its parent.
   *
   * @param document The document in which the command was invoked.
   * @param positions The positions at which the command was invoked.
   * @param token A cancellation token.
   * @return Selection ranges or a thenable that resolves to such. The lack of a result can be
   *   signaled by returning `undefined` or `null`.
   */
  fun provideSelectionRanges(
    document: TextDocument,
    positions: ReadonlyArray<Position>,
    token: CancellationToken,
  ): ProviderResult<Array<SelectionRange>>
}
