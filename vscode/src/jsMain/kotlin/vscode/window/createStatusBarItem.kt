@file:JsModule("vscode")

package vscode.window

import vscode.StatusBarAlignment
import vscode.StatusBarItem

/**
 * Creates a status bar [StatusBarItem].
 *
 * @param id The identifier of the item. Must be unique within the extension.
 * @param alignment The alignment of the item.
 * @param priority The priority of the item. Higher values mean the item should be shown more to the left.
 * @return A new status bar item.
 */
external fun createStatusBarItem(
  id: String,
  alignment: StatusBarAlignment = definedExternally,
  priority: Double = definedExternally,
): StatusBarItem

/**
 * Creates a status bar [StatusBarItem].
 *
 * @see [createStatusBarItem] for creating a status bar item with an identifier.
 * @param alignment The alignment of the item.
 * @param priority The priority of the item. Higher values mean the item should be shown more to the left.
 * @return A new status bar item.
 */
external fun createStatusBarItem(
  alignment: StatusBarAlignment = definedExternally,
  priority: Double = definedExternally,
): StatusBarItem
