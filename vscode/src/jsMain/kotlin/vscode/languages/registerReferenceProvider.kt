@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentSelector
import vscode.IDisposable
import vscode.ReferenceProvider

/**
 * Register a reference provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A reference provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerReferenceProvider(
  selector: DocumentSelector,
  provider: ReferenceProvider,
): IDisposable
