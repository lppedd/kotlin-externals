@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.RenameProvider

/**
 * Register a rename provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and asked in sequence. The first provider producing a result
 * defines the result of the whole operation.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A rename provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerRenameProvider(
  selector: DocumentSelector,
  provider: RenameProvider,
): Disposable
