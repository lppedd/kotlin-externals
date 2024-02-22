@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.SelectionRangeProvider

/**
 * Register a selection range provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A selection range provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerSelectionRangeProvider(
  selector: DocumentSelector,
  provider: SelectionRangeProvider,
): Disposable
