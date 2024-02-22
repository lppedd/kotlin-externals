@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentHighlightProvider
import vscode.DocumentSelector
import vscode.IDisposable

/**
 * Register a document highlight provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and groups sequentially asked for document highlights.
 * The process stops when a provider returns a `non-falsy` or `non-failure` result.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document highlight provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentHighlightProvider(
  selector: DocumentSelector,
  provider: DocumentHighlightProvider,
): IDisposable
