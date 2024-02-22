@file:JsModule("vscode")

package vscode.workspace

import vscode.IDisposable
import vscode.NotebookDocumentContentOptions
import vscode.NotebookSerializer

/**
 * Register a [NotebookSerializer].
 *
 * A notebook serializer must be contributed through the `notebooks` extension point. When opening a notebook file, the editor will send
 * the `onNotebook:<notebookType>` activation event, and extensions must register their serializer in return.
 *
 * @param notebookType A notebook.
 * @param serializer A notebook serializer.
 * @param options Optional context options that define what parts of a notebook should be persisted
 * @return A [IDisposable] that unregisters this serializer when being disposed.
 */
external fun registerNotebookSerializer(
  notebookType: String,
  serializer: NotebookSerializer,
  options: NotebookDocumentContentOptions = definedExternally,
): IDisposable
