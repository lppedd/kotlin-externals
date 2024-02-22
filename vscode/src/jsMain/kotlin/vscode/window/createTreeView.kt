@file:JsModule("vscode")

package vscode.window

import vscode.TreeView
import vscode.TreeViewOptions

/**
 * Create a [TreeView] for the view contributed using the extension point `views`.
 * @param viewId Id of the view contributed using the extension point `views`.
 * @param options Options for creating the [TreeView]
 * @return a [TreeView].
 */
external fun <T> createTreeView(
  viewId: String,
  options: TreeViewOptions<T>,
): TreeView<T>
