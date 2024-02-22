@file:JsModule("vscode")

package vscode.authentication

import vscode.AuthenticationProvider
import vscode.AuthenticationProviderOptions
import vscode.Disposable

/**
 * Register an authentication provider.
 *
 * There can only be one provider per id and an error is being thrown when an id
 * has already been used by another provider. Ids are case-sensitive.
 *
 * @param id The unique identifier of the provider.
 * @param label The human-readable name of the provider.
 * @param provider The authentication provider provider.
 * @param options Additional options for the provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerAuthenticationProvider(
  id: String,
  label: String,
  provider: AuthenticationProvider,
  options: AuthenticationProviderOptions = definedExternally,
): Disposable
