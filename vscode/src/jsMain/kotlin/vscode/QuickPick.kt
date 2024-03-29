package vscode

import js.array.ReadonlyArray

/**
 * A concrete [QuickInput] to let the user pick an item from a
 * list of items of type T. The items can be filtered through a filter text field and
 * there is an option [QuickPick.canSelectMany] to allow for
 * selecting multiple items.
 *
 * Note that in many cases the more convenient [vscode.window.showQuickPick]
 * is easier to use. [vscode.window.createQuickPick] should be used
 * when [vscode.window.showQuickPick] does not offer the required flexibility.
 */
external interface QuickPick<T : QuickPickItem> : QuickInput {
  /**
   * Current value of the filter text.
   */
  var value: String

  /**
   * Optional placeholder shown in the filter textbox when no filter has been entered.
   */
  var placeholder: String?

  /**
   * An event signaling when the value of the filter text has changed.
   */
  val onDidChangeValue: Event<String>

  /**
   * An event signaling when the user indicated acceptance of the selected item(s).
   */
  val onDidAccept: Event<Unit>

  /**
   * Buttons for actions in the UI.
   */
  var buttons: ReadonlyArray<QuickInputButton>

  /**
   * An event signaling when a button in the title bar was triggered.
   * This event does not fire for buttons on a [QuickPickItem].
   */
  val onDidTriggerButton: Event<QuickInputButton>

  /**
   * An event signaling when a button in a particular [QuickPickItem] was triggered.
   * This event does not fire for buttons in the title bar.
   */
  val onDidTriggerItemButton: Event<QuickPickItemButtonEvent<T>>

  /**
   * Items to pick from. This can be read and updated by the extension.
   */
  var items: ReadonlyArray<T>

  /**
   * If multiple items can be selected at the same time. Defaults to false.
   */
  var canSelectMany: Boolean

  /**
   * If the filter text should also be matched against the description of the items. Defaults to false.
   */
  var matchOnDescription: Boolean

  /**
   * If the filter text should also be matched against the detail of the items. Defaults to false.
   */
  var matchOnDetail: Boolean

  /**
   * An optional flag to maintain the scroll position of the quick pick when the quick pick items are updated. Defaults to false.
   */
  var keepScrollPosition: Boolean?

  /**
   * Active items. This can be read and updated by the extension.
   */
  var activeItems: ReadonlyArray<T>

  /**
   * An event signaling when the active items have changed.
   */
  val onDidChangeActive: Event<ReadonlyArray<T>>

  /**
   * Selected items. This can be read and updated by the extension.
   */
  var selectedItems: ReadonlyArray<T>

  /**
   * An event signaling when the selected items have changed.
   */
  val onDidChangeSelection: Event<ReadonlyArray<T>>
}
