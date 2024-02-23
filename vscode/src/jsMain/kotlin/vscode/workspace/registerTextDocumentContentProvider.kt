@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.IDisposable
import vscode.TextDocumentContentProvider

/**
 * Register a text document content provider.
 *
 * Only one provider can be registered per scheme.
 *
 * @param scheme The uri-scheme to register for.
 * @param provider A content provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerTextDocumentContentProvider(
  scheme: String,
  provider: TextDocumentContentProvider,
): IDisposable
