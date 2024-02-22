@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentSelector
import vscode.DocumentSymbolProvider
import vscode.DocumentSymbolProviderMetadata
import vscode.IDisposable

/**
 * Register a document symbol provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A document symbol provider.
 * @param metaData metadata about the provider
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerDocumentSymbolProvider(
  selector: DocumentSelector,
  provider: DocumentSymbolProvider,
  metaData: DocumentSymbolProviderMetadata = definedExternally,
): IDisposable
