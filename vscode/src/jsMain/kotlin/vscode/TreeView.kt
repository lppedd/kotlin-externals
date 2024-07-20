package vscode

import js.array.ReadonlyArray

/**
 * Represents a Tree view
 */
external interface TreeView<T> : IDisposable {
  /**
   * Event that is fired when an element is expanded
   */
  val onDidExpandElement: Event<TreeViewExpansionEvent<T>>

  /**
   * Event that is fired when an element is collapsed
   */
  val onDidCollapseElement: Event<TreeViewExpansionEvent<T>>

  /**
   * Currently selected elements.
   */
  val selection: ReadonlyArray<T>

  /**
   * Event that is fired when the [TreeView.selection] has changed
   */
  val onDidChangeSelection: Event<TreeViewSelectionChangeEvent<T>>

  /**
   * `true` if the [TreeView] is visible otherwise `false`.
   */
  val visible: Boolean

  /**
   * Event that is fired when [TreeView.visible] has changed
   */
  val onDidChangeVisibility: Event<TreeViewVisibilityChangeEvent>

  /**
   * An event to signal that an element or root has either been checked or unchecked.
   */
  val onDidChangeCheckboxState: Event<TreeCheckboxChangeEvent<T>>

  /**
   * An optional human-readable message that will be rendered in the view.
   * Setting the message to null, undefined, or empty string will remove the message from the view.
   */
  var message: String?

  /**
   * The tree view title is initially taken from the extension package.json
   * Changes to the title property will be properly reflected in the UI in the title of the view.
   */
  var title: String?

  /**
   * An optional human-readable description which is rendered less prominently in the title of the view.
   * Setting the title description to null, undefined, or empty string will remove the description from the view.
   */
  var description: String?

  /**
   * The badge to display for this TreeView.
   * To remove the badge, set to undefined.
   */
  var badge: ViewBadge?

  /**
   * Reveals the given element in the tree view.
   * If the tree view is not visible then the tree view is shown and element is revealed.
   *
   * By default revealed element is selected.
   * In order not to select, set the option `select` to `false`.
   * In order to focus, set the option `focus` to `true`.
   * In order to expand the revealed element, set the option `expand` to `true`. To expand recursively set `expand` to the number of levels to expand.
   *
   * * *NOTE:* You can expand only to 3 levels maximum.
   * * *NOTE:* The [TreeDataProvider] that the `TreeView` is registered with ([vscode.window.createTreeView]) with must implement [TreeDataProvider.getParent] method to access this API.
   */
  fun reveal(
    element: T,
    options: TreeViewRevealOptions = definedExternally,
  ): Thenable<Unit>
}
