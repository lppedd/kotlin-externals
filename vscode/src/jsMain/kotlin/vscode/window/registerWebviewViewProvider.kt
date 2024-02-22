@file:JsModule("vscode")

package vscode.window

import vscode.IDisposable
import vscode.WebviewViewProvider

/**
 * Register a new provider for webview views.
 *
 * @param viewId Unique id of the view. This should match the `id` from the
 *   `views` contribution in the package.json.
 * @param provider Provider for the webview views.
 *
 * @return Disposable that unregisters the provider.
 */
external fun registerWebviewViewProvider(
  viewId: String,
  provider: WebviewViewProvider,
  options: RegisterWebviewViewProviderOptions = definedExternally,
): IDisposable
