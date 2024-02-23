@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.IDisposable
import vscode.TerminalProfileProvider

/**
 * Registers a provider for a contributed terminal profile.
 *
 * @param id The ID of the contributed terminal profile.
 * @param provider The terminal profile provider.
 * @return A [IDisposable] that unregisters the provider.
 */
external fun registerTerminalProfileProvider(
  id: String,
  provider: TerminalProfileProvider,
): IDisposable
