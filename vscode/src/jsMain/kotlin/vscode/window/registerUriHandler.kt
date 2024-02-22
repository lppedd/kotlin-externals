@file:JsModule("vscode")

package vscode.window

import vscode.IDisposable
import vscode.Uri
import vscode.UriHandler

/**
 * Registers a [UriHandler] capable of handling system-wide [Uri]s.
 * In case there are multiple windows open, the topmost window will handle the uri.
 * A uri handler is scoped to the extension it is contributed from; it will only
 * be able to handle uris which are directed to the extension itself. A uri must respect
 * the following rules:
 *
 * - The uri-scheme must be `vscode.env.uriScheme`;
 * - The uri-authority must be the extension id (e.g. `my.extension`);
 * - The uri-path, -query and -fragment parts are arbitrary.
 *
 * For example, if the `my.extension` extension registers a uri handler, it will only
 * be allowed to handle uris with the prefix `product-name://my.extension`.
 *
 * An extension can only register a single uri handler in its entire activation lifetime.
 *
 * * *Note:* There is an activation event `onUri` that fires when a uri directed for
 * the current extension is about to be handled.
 *
 * @param handler The uri handler to register for this extension.
 * @return A [IDisposable] that unregisters the handler.
 */
external fun registerUriHandler(handler: UriHandler): IDisposable
