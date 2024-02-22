@file:JsModule("vscode")

package vscode.languages

import js.array.ReadonlyArray
import vscode.DocumentFilter
import vscode.DocumentFormattingEditProvider
import vscode.IDisposable
import vscode.Union

/**
 * Register a formatting provider for a document.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document formatting edit provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentFormattingEditProvider(
  selector: DocumentFilter,
  provider: DocumentFormattingEditProvider,
): IDisposable

/**
 * Register a formatting provider for a document.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document formatting edit provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentFormattingEditProvider(
  selector: String,
  provider: DocumentFormattingEditProvider,
): IDisposable

/**
 * Register a formatting provider for a document.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and the best-matching provider is used. Failure
 * of the selected provider will cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document formatting edit provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentFormattingEditProvider(
  selector: ReadonlyArray<Union<DocumentFilter, String>>,
  provider: DocumentFormattingEditProvider,
): IDisposable
