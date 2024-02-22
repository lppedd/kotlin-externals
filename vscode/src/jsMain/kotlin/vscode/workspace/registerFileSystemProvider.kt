@file:JsModule("vscode")

package vscode.workspace

import vscode.Disposable
import vscode.FileSystemProvider
import vscode.Uri

/**
 * Register a filesystem provider for a given scheme, e.g. `ftp`.
 *
 * There can only be one provider per scheme and an error is being thrown when a scheme
 * has been claimed by another provider or when it is reserved.
 *
 * @param scheme The [Uri.scheme] the provider registers for.
 * @param provider The filesystem provider.
 * @param options Immutable metadata about the provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerFileSystemProvider(
  scheme: String,
  provider: FileSystemProvider,
  options: RegisterFileSystemProviderOptions = definedExternally,
): Disposable
