@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.FileDecorationProvider
import vscode.IDisposable

/**
 * Register a file decoration provider.
 *
 * @param provider A [FileDecorationProvider].
 * @return A [IDisposable] that unregisters the provider.
 */
external fun registerFileDecorationProvider(provider: FileDecorationProvider): IDisposable
