package vscode

import js.array.ReadonlyArray

/**
 * The event that is fired when there is a change in tree view's selection ([TreeView.selection]).
 */
external interface TreeViewSelectionChangeEvent<T> {
  /**
   * Selected elements.
   */
  val selection: ReadonlyArray<T>
}
