@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentSelector
import vscode.SignatureHelpProvider
import vscode.SignatureHelpProviderMetadata

/**
 * Register a signature help provider.
 *
 * Multiple providers can be registered for a language. In that case providers are sorted
 * by their [vscode.languages.match] and called sequentially until a provider returns a
 * valid result.
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A signature help provider.
 * @param triggerCharacters Trigger signature help when the user types one of the characters, like `,` or `(`.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerSignatureHelpProvider(
  selector: DocumentSelector,
  provider: SignatureHelpProvider,
  vararg triggerCharacters: String,
): Disposable

/**
 * @see [vscode.languages.registerSignatureHelpProvider]
 *
 * @param selector A selector that defines the documents this provider is applicable to.
 * @param provider A signature help provider.
 * @param metadata Information about the provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerSignatureHelpProvider(
  selector: DocumentSelector,
  provider: SignatureHelpProvider,
  metadata: SignatureHelpProviderMetadata,
): Disposable
