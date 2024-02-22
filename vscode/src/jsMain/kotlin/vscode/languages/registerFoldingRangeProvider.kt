@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.FoldingRangeProvider

/**
 * Register a folding range provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged.
 * If multiple folding ranges start at the same position, only the range of the first registered provider is used.
 * If a folding range overlaps with an other range that has a smaller position, it is also ignored.
 *
 * A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A folding range provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerFoldingRangeProvider(
  selector: DocumentSelector,
  provider: FoldingRangeProvider,
): Disposable
