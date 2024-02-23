@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentFormattingEditProvider
import vscode.DocumentRangeFormattingEditProvider
import vscode.DocumentSelector
import vscode.IDisposable

/**
 * Register a formatting provider for a document range.
 *
 * *Note:* A document range provider is also a [DocumentFormattingEditProvider]
 * which means there is no need to [vscode.languages.registerDocumentFormattingEditProvider] a document
 * formatter when also registering a range provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document range formatting edit provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentRangeFormattingEditProvider(
  selector: DocumentSelector,
  provider: DocumentRangeFormattingEditProvider,
): IDisposable
