@file:JsModule("vscode")

package vscode

/**
 * The kind of [QuickPickItem quick pick item].
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface QuickPickItemKind {
  companion object {
    /**
     * When a [QuickPickItem} has a kind of {@link Separator], the item is just a visual separator and does not represent a real item.
     * The only property that applies is [QuickPickItem.label label }. All other properties on {@link QuickPickItem] will be ignored and have no effect.
     */
    val Separator: QuickPickItemKind

    /**
     * The default [QuickPickItem.kind] is an item that can be selected in the quick pick.
     */
    val Default: QuickPickItemKind
  }
}
