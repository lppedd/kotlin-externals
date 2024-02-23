@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentRangeSemanticTokensProvider
import vscode.DocumentSelector
import vscode.IDisposable
import vscode.SemanticTokensLegend

/**
 * Register a semantic tokens provider for a document range.
 *
 * *Note:* If a document has both a `DocumentSemanticTokensProvider` and a `DocumentRangeSemanticTokensProvider`,
 * the range provider will be invoked only initially, for the time in which the full document provider takes
 * to resolve the first request. Once the full document provider resolves the first request, the semantic tokens
 * provided via the range provider will be discarded and from that point forward, only the document provider
 * will be used.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document range semantic tokens provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentRangeSemanticTokensProvider(
  selector: DocumentSelector,
  provider: DocumentRangeSemanticTokensProvider,
  legend: SemanticTokensLegend,
): IDisposable
