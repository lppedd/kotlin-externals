@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.DocumentSemanticTokensProvider
import vscode.SemanticTokensLegend

/**
 * Register a semantic tokens provider for a whole document.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document semantic tokens provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentSemanticTokensProvider(
  selector: DocumentSelector,
  provider: DocumentSemanticTokensProvider,
  legend: SemanticTokensLegend,
): Disposable
