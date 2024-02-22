@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentSelector
import vscode.IDisposable
import vscode.LinkedEditingRangeProvider

/**
 * Register a linked editing range provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider that has a result is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A linked editing range provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerLinkedEditingRangeProvider(
  selector: DocumentSelector,
  provider: LinkedEditingRangeProvider,
): IDisposable
