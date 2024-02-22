@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.TypeDefinitionProvider

/**
 * Register a type definition provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A type definition provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerTypeDefinitionProvider(
  selector: DocumentSelector,
  provider: TypeDefinitionProvider,
): Disposable
