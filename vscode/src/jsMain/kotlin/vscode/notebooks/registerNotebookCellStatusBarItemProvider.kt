@file:JsModule("vscode")

package vscode.notebooks

import vscode.IDisposable
import vscode.NotebookCellStatusBarItemProvider

/**
 * Register a [NotebookCellStatusBarItemProvider] for the given notebook type.
 *
 * @param notebookType The notebook type to register for.
 * @param provider A cell status bar provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
external fun registerNotebookCellStatusBarItemProvider(
  notebookType: String,
  provider: NotebookCellStatusBarItemProvider,
): IDisposable
