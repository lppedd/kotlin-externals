@file:JsModule("vscode")

package vscode.window

import vscode.IDisposable
import vscode.TerminalLink
import vscode.TerminalLinkProvider

/**
 * Register provider that enables the detection and handling of links within the terminal.
 * @param provider The provider that provides the terminal links.
 * @return Disposable that unregisters the provider.
 */
external fun registerTerminalLinkProvider(provider: TerminalLinkProvider<TerminalLink>): IDisposable
