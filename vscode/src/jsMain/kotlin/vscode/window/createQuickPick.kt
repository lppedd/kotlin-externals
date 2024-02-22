@file:JsModule("vscode")

package vscode.window

import vscode.QuickPick
import vscode.QuickPickItem

/**
 * Creates a [QuickPick] to let the user pick an item from a list
 * of items of type T.
 *
 * Note that in many cases the more convenient [vscode.window.showQuickPick]
 * is easier to use. [vscode.window.createQuickPick] should be used
 * when [vscode.window.showQuickPick] does not offer the required flexibility.
 *
 * @return A new [QuickPick].
 */
external fun <T : QuickPickItem> createQuickPick(): QuickPick<T>
