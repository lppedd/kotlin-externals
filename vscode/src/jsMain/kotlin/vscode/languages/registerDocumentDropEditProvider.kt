@file:JsModule("vscode")
@file:JsQualifier("languages")

package vscode.languages

import vscode.DocumentDropEditProvider
import vscode.DocumentSelector
import vscode.IDisposable

/**
 * Registers a new [DocumentDropEditProvider].
 *
 * @param selector A selector that defines the documents this provider applies to.
 * @param provider A drop provider.
 *
 * @return A [IDisposable] that unregisters this provider when disposed of.
 */
external fun registerDocumentDropEditProvider(
  selector: DocumentSelector,
  provider: DocumentDropEditProvider,
): IDisposable
