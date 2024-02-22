@file:JsModule("vscode")

package vscode.window

import js.array.ReadonlyArray
import vscode.CancellationToken
import vscode.QuickPickItem
import vscode.QuickPickOptions
import vscode.Thenable

/**
 * Shows a selection list allowing multiple selections.
 *
 * @param items An array of strings, or a promise that resolves to an array of strings.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected items or `undefined`.
 */
external fun showQuickPick(
  items: ReadonlyArray<String>,
  options: ShowQuickPickOptions,
  token: CancellationToken = definedExternally,
): Thenable<Array<String>?>

/**
 * Shows a selection list allowing multiple selections.
 *
 * @param items An array of strings, or a promise that resolves to an array of strings.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected items or `undefined`.
 */
external fun showQuickPick(
  items: Thenable<ReadonlyArray<String>>,
  options: ShowQuickPickOptions,
  token: CancellationToken = definedExternally,
): Thenable<Array<String>?>

/**
 * Shows a selection list.
 *
 * @param items An array of strings, or a promise that resolves to an array of strings.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selection or `undefined`.
 */
external fun showQuickPick(
  items: ReadonlyArray<String>,
  options: QuickPickOptions = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<String?>

/**
 * Shows a selection list.
 *
 * @param items An array of strings, or a promise that resolves to an array of strings.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selection or `undefined`.
 */
external fun showQuickPick(
  items: Thenable<ReadonlyArray<String>>,
  options: QuickPickOptions = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<String?>

/**
 * Shows a selection list allowing multiple selections.
 *
 * @param items An array of items, or a promise that resolves to an array of items.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected items or `undefined`.
 */
external fun <T : QuickPickItem> showQuickPick(
  items: ReadonlyArray<T>,
  options: ShowQuickPickOptions,
  token: CancellationToken = definedExternally,
): Thenable<Array<T>?>

/**
 * Shows a selection list allowing multiple selections.
 *
 * @param items An array of items, or a promise that resolves to an array of items.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected items or `undefined`.
 */
external fun <T : QuickPickItem> showQuickPick(
  items: Thenable<ReadonlyArray<T>>,
  options: ShowQuickPickOptions,
  token: CancellationToken = definedExternally,
): Thenable<Array<T>?>

/**
 * Shows a selection list.
 *
 * @param items An array of items, or a promise that resolves to an array of items.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected item or `undefined`.
 */
external fun <T : QuickPickItem> showQuickPick(
  items: ReadonlyArray<T>,
  options: QuickPickOptions = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<T?>

/**
 * Shows a selection list.
 *
 * @param items An array of items, or a promise that resolves to an array of items.
 * @param options Configures the behavior of the selection list.
 * @param token A token that can be used to signal cancellation.
 * @return A promise that resolves to the selected item or `undefined`.
 */
external fun <T : QuickPickItem> showQuickPick(
  items: Thenable<ReadonlyArray<T>>,
  options: QuickPickOptions = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<T?>
