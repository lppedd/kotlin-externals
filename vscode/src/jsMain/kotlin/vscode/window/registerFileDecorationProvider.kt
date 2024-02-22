@file:JsModule("vscode")

package vscode.window

import vscode.Disposable
import vscode.FileDecorationProvider

/**
 * Register a file decoration provider.
 *
 * @param provider A [FileDecorationProvider].
 * @return A [Disposable] that unregisters the provider.
 */
external fun registerFileDecorationProvider(provider: FileDecorationProvider): Disposable
