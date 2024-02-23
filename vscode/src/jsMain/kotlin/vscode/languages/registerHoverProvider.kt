@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentSelector
import vscode.HoverProvider
import vscode.IDisposable

/**
 * Register a hover provider.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A hover provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerHoverProvider(
  selector: DocumentSelector,
  provider: HoverProvider,
): IDisposable
