@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * The kind of [QuickPickItem].
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface QuickPickItemKind {
  companion object {
    /**
     * When a [QuickPickItem] has a kind of [Separator], the item is just a visual separator and does not represent a real item.
     * The only property that applies is [QuickPickItem.label]. All other properties on [QuickPickItem] will be ignored and have no effect.
     */
    @JsIntValue(-1)
    val Separator: QuickPickItemKind

    /**
     * The default [QuickPickItem.kind] is an item that can be selected in the quick pick.
     */
    @JsIntValue(0)
    val Default: QuickPickItemKind
  }
}
