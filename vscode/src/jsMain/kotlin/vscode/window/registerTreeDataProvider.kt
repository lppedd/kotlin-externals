@file:JsModule("vscode")

package vscode.window

import vscode.Disposable
import vscode.TreeDataProvider
import vscode.TreeView

/**
 * Register a [TreeDataProvider] for the view contributed using the extension point `views`.
 * This will allow you to contribute data to the [TreeView] and update if the data changes.
 *
 * **Note:** To get access to the [TreeView] and perform operations on it, use [vscode.window.createTreeView].
 *
 * @param viewId Id of the view contributed using the extension point `views`.
 * @param treeDataProvider A [TreeDataProvider] that provides tree data for the view
 * @return A [Disposable] that unregisters the [TreeDataProvider].
 */
external fun <T> registerTreeDataProvider(
  viewId: String,
  treeDataProvider: TreeDataProvider<T>,
): Disposable
