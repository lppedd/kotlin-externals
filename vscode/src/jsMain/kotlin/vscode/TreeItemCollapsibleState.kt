package vscode

import seskar.js.JsIntValue

/**
 * Collapsible state of the tree item
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TreeItemCollapsibleState {
  companion object {
    /**
     * Determines an item can be neither collapsed nor expanded. Implies it has no children.
     */
    @JsIntValue(0)
    val None: TreeItemCollapsibleState

    /**
     * Determines an item is collapsed
     */
    @JsIntValue(1)
    val Collapsed: TreeItemCollapsibleState

    /**
     * Determines an item is expanded
     */
    @JsIntValue(2)
    val Expanded: TreeItemCollapsibleState
  }
}
