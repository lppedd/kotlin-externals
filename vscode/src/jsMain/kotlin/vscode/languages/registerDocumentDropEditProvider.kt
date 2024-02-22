@file:JsModule("vscode")

package vscode.languages

import vscode.Disposable
import vscode.DocumentDropEditProvider
import vscode.DocumentSelector

/**
 * Registers a new [DocumentDropEditProvider].
 *
 * @param selector A selector that defines the documents this provider applies to.
 * @param provider A drop provider.
 *
 * @return A [Disposable] that unregisters this provider when disposed of.
 */
external fun registerDocumentDropEditProvider(
  selector: DocumentSelector,
  provider: DocumentDropEditProvider,
): Disposable
