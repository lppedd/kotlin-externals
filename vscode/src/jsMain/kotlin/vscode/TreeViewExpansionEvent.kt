package vscode

/**
 * The event that is fired when an element in the [TreeView] is expanded or collapsed
 */
external interface TreeViewExpansionEvent<T> {
  /**
   * Element that is expanded or collapsed.
   */
  val element: T
}
