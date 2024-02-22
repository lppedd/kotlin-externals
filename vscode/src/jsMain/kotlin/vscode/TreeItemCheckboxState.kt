@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Checkbox state of the tree item
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TreeItemCheckboxState {
  companion object {
    /**
     * Determines an item is unchecked
     */
    @JsIntValue(0)
    val Unchecked: TreeItemCheckboxState

    /**
     * Determines an item is checked
     */
    @JsIntValue(1)
    val Checked: TreeItemCheckboxState
  }
}
