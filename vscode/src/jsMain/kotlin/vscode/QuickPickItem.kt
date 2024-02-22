package vscode

import js.array.ReadonlyArray
import kotlin.ts.Union3

/**
 * Represents an item that can be selected from
 * a list of items.
 */
external interface QuickPickItem {
  /**
   * A human-readable string which is rendered prominent. Supports rendering of [ThemeIcon]s via
   * the `$(<name>)`-syntax.
   */
  var label: String

  /**
   * The kind of QuickPickItem that will determine how this item is rendered in the quick pick. When not specified,
   * the default is [QuickPickItemKind.Default].
   */
  var kind: QuickPickItemKind?

  /**
   * The icon path or [ThemeIcon] for the QuickPickItem.
   */
  var iconPath: (Union3<Uri, ThemeUris, ThemeIcon> /* Uri | { light: Uri; dark: Uri; } | ThemeIcon */)?

  /**
   * A human-readable string which is rendered less prominent in the same line. Supports rendering of
   * [ThemeIcon]s via the `$(<name>)`-syntax.
   *
   * Note: this property is ignored when [QuickPickItem.kind] is set to [QuickPickItemKind.Separator]
   */
  var description: String?

  /**
   * A human-readable string which is rendered less prominent in a separate line. Supports rendering of
   * [ThemeIcon]s via the `$(<name>)`-syntax.
   *
   * Note: this property is ignored when [QuickPickItem.kind] is set to [QuickPickItemKind.Separator]
   */
  var detail: String?

  /**
   * Optional flag indicating if this item is picked initially. This is only honored when using
   * the [vscode.window.showQuickPick] API. To do the same thing with
   * the [vscode.window.createQuickPick] API, simply set the [QuickPick.selectedItems]
   * to the items you want picked initially.
   * (*Note:* This is only honored when the picker allows multiple selections.)
   *
   * @see [QuickPickOptions.canPickMany]
   *
   * Note: this property is ignored when [QuickPickItem.kind] is set to [QuickPickItemKind.Separator]
   */
  var picked: Boolean?

  /**
   * Always show this item.
   *
   * Note: this property is ignored when [QuickPickItem.kind] is set to [QuickPickItemKind.Separator]
   */
  var alwaysShow: Boolean?

  /**
   * Optional buttons that will be rendered on this particular item. These buttons will trigger
   * an [QuickPickItemButtonEvent] when clicked. Buttons are only rendered when using a quickpick
   * created by the [vscode.window.createQuickPick] API. Buttons are not rendered when using
   * the [vscode.window.showQuickPick] API.
   *
   * Note: this property is ignored when [QuickPickItem.kind] is set to [QuickPickItemKind.Separator]
   */
  var buttons: ReadonlyArray<QuickInputButton>?
}
