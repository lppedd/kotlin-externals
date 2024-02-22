@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentSelector
import vscode.IDisposable
import vscode.InlineValuesProvider

/**
 * Register a provider that returns data for the debugger's 'inline value' feature.
 * Whenever the generic debugger has stopped in a source file, providers registered for the language of the file
 * are called to return textual data that will be shown in the editor at the end of lines.
 *
 * Multiple providers can be registered for a language. In that case providers are asked in
 * parallel and the results are merged. A failing provider (rejected promise or exception) will
 * not cause a failure of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider An inline values provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerInlineValuesProvider(
  selector: DocumentSelector,
  provider: InlineValuesProvider,
): IDisposable
