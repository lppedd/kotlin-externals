@file:JsModule("vscode")

package vscode.env

import vscode.Thenable
import vscode.Uri
import vscode.UriHandler

/**
 * Resolves a uri to a form that is accessible externally.
 *
 * #### `http:` or `https:` scheme
 *
 * Resolves an *external* uri, such as a `http:` or `https:` link, from where the extension is running to a
 * uri to the same resource on the client machine.
 *
 * This is a no-op if the extension is running on the client machine.
 *
 * If the extension is running remotely, this function automatically establishes a port forwarding tunnel
 * from the local machine to `target` on the remote and returns a local uri to the tunnel. The lifetime of
 * the port forwarding tunnel is managed by the editor and the tunnel can be closed by the user.
 *
 * *Note* that uris passed through `openExternal` are automatically resolved and you should not call `asExternalUri` on them.
 *
 * #### `vscode.env.uriScheme`
 *
 * Creates a uri that - if opened in a browser (e.g. via `openExternal`) - will result in a registered [UriHandler]
 * to trigger.
 *
 * Extensions should not make any assumptions about the resulting uri and should not alter it in any way.
 * Rather, extensions can e.g. use this uri in an authentication flow, by adding the uri as callback query
 * argument to the server to authenticate to.
 *
 * *Note* that if the server decides to add additional query parameters to the uri (e.g. a token or secret), it
 * will appear in the uri that is passed to the [UriHandler].
 *
 * **Example** of an authentication flow:
 * ```typescript
 * vscode.window.registerUriHandler({
 *   handleUri(uri: vscode.Uri): vscode.ProviderResult<void> {
 *     if (uri.path === '/did-authenticate') {
 *       console.log(uri.toString());
 *     }
 *   }
 * });
 *
 * const callableUri = await vscode.env.asExternalUri(vscode.Uri.parse(vscode.env.uriScheme + '://my.extension/did-authenticate'));
 * await vscode.env.openExternal(callableUri);
 * ```
 *
 * *Note* that extensions should not cache the result of `asExternalUri` as the resolved uri may become invalid due to
 * a system or user action — for example, in remote cases, a user may close a port forwarding tunnel that was opened by
 * `asExternalUri`.
 *
 * #### Any other scheme
 *
 * Any other scheme will be handled as if the provided URI is a workspace URI. In that case, the method will return
 * a URI which, when handled, will make the editor open the workspace.
 *
 * @return A uri that can be used on the client machine.
 */
external fun asExternalUri(target: Uri): Thenable<Uri>
