package vscode

/**
 * The event that is fired when there is a change in tree view's visibility ([TreeView.visible]).
 */
external interface TreeViewVisibilityChangeEvent {
  /**
   * `true` if the [TreeView] is visible otherwise `false`.
   */
  val visible: Boolean
}
