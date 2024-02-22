@file:JsModule("vscode")

package vscode.window

import vscode.Disposable
import vscode.TerminalProfileProvider

/**
 * Registers a provider for a contributed terminal profile.
 *
 * @param id The ID of the contributed terminal profile.
 * @param provider The terminal profile provider.
 * @return A [Disposable] that unregisters the provider.
 */
external fun registerTerminalProfileProvider(
  id: String,
  provider: TerminalProfileProvider,
): Disposable
