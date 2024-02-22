package vscode

import js.array.JsTuple2
import js.array.ReadonlyArray

/**
 * An event describing the change in a tree item's checkbox state.
 */
external interface TreeCheckboxChangeEvent<T> {
  /**
   * The items that were checked or unchecked.
   */
  val items: ReadonlyArray<JsTuple2<T, TreeItemCheckboxState>>
}
