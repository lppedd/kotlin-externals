@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * A tree item is an UI element of the tree. Tree items are created by the [TreeDataProvider].
 */
open external class TreeItem {
  /**
   * @param label A human-readable string describing this item
   * @param collapsibleState [TreeItemCollapsibleState] of the tree item. Default is [TreeItemCollapsibleState.None]
   */
  constructor(label: String, collapsibleState: TreeItemCollapsibleState = definedExternally)

  /**
   * @param label A human-readable string describing this item
   * @param collapsibleState [TreeItemCollapsibleState] of the tree item. Default is [TreeItemCollapsibleState.None]
   */
  constructor(label: TreeItemLabel, collapsibleState: TreeItemCollapsibleState = definedExternally)

  /**
   * @param resourceUri The [Uri] of the resource representing this item.
   * @param collapsibleState [TreeItemCollapsibleState] of the tree item. Default is [TreeItemCollapsibleState.None]
   */
  constructor(resourceUri: Uri, collapsibleState: TreeItemCollapsibleState = definedExternally)

  /**
   * A human-readable string describing this item. When `falsy`, it is derived from [TreeItem.resourceUri].
   */
  var label: Union<String, TreeItemLabel>?

  /**
   * Optional id for the tree item that has to be unique across tree. The id is used to preserve the selection and expansion state of the tree item.
   *
   * If not provided, an id is generated using the tree item's label. **Note** that when labels change, ids will change and that selection and expansion state cannot be kept stable anymore.
   */
  var id: String?

  /**
   * The icon path or [ThemeIcon] for the tree item.
   * When `falsy`, [ThemeIcon.Folder] is assigned, if item is collapsible otherwise [ThemeIcon.File].
   * When a file or folder [ThemeIcon] is specified, icon is derived from the current file icon theme for the specified theme icon using [TreeItem.resourceUri] (if provided).
   */
  // TODO(Edoardo): split?
  var iconPath: (Any /* string | Uri | { light: string | Uri; dark: string | Uri; } | ThemeIcon */)?

  /**
   * A human-readable string which is rendered less prominent.
   * When `true`, it is derived from [TreeItem.resourceUri] and when `falsy`, it is not shown.
   */
  var description: Union<String, Boolean>?

  /**
   * The [Uri] of the resource representing this item.
   *
   * Will be used to derive the [TreeItem.label], when it is not provided.
   * Will be used to derive the icon from current file icon theme, when [TreeItem.iconPath] has [ThemeIcon] value.
   */
  var resourceUri: Uri?

  /**
   * The tooltip text when you hover over this item.
   */
  var tooltip: Union<String, MarkdownString>?

  /**
   * The [Command] that should be executed when the tree item is selected.
   *
   * Please use `vscode.open` or `vscode.diff` as command IDs when the tree item is opening
   * something in the editor. Using these commands ensures that the resulting editor will
   * appear consistent with how other built-in trees open editors.
   */
  open var command: Command?

  /**
   * [TreeItemCollapsibleState] of the tree item.
   */
  var collapsibleState: TreeItemCollapsibleState?

  /**
   * Context value of the tree item. This can be used to contribute item specific actions in the tree.
   * For example, a tree item is given a context value as `folder`. When contributing actions to `view/item/context`
   * using `menus` extension point, you can specify context value for key `viewItem` in `when` expression like `viewItem == folder`.
   * ```json
   * "contributes": {
   *   "menus": {
   *     "view/item/context": [
   *       {
   *         "command": "extension.deleteFolder",
   *         "when": "viewItem == folder"
   *       }
   *     ]
   *   }
   * }
   * ```
   * This will show action `extension.deleteFolder` only for items with `contextValue` is `folder`.
   */
  var contextValue: String?

  /**
   * Accessibility information used when screen reader interacts with this tree item.
   * Generally, a TreeItem has no need to set the `role` of the accessibilityInformation;
   * however, there are cases where a TreeItem is not displayed in a tree-like way where setting the `role` may make sense.
   */
  var accessibilityInformation: AccessibilityInformation?

  /**
   * [TreeItemCheckboxState] of the tree item.
   * [TreeDataProvider.onDidChangeTreeData] should be fired when [TreeItem.checkboxState] changes.
   */
  // TODO(Edoardo): split?
  var checkboxState:
    (Any /* TreeItemCheckboxState | { readonly state: TreeItemCheckboxState; readonly tooltip?: string; readonly accessibilityInformation?: AccessibilityInformation; } */)?
}
