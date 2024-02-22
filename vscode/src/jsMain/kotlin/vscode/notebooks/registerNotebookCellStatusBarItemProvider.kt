@file:JsModule("vscode")

package vscode.notebooks

import vscode.Disposable
import vscode.NotebookCellStatusBarItemProvider

/**
 * Register a [NotebookCellStatusBarItemProvider] for the given notebook type.
 *
 * @param notebookType The notebook type to register for.
 * @param provider A cell status bar provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerNotebookCellStatusBarItemProvider(
  notebookType: String,
  provider: NotebookCellStatusBarItemProvider,
): Disposable
