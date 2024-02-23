@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.MessageItem
import vscode.MessageOptions
import vscode.Thenable

/**
 * Show an error message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun showErrorMessage(
  message: String,
  vararg items: String,
): Thenable<String?>

/**
 * Show an error message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param options Configures the behaviour of the message.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun showErrorMessage(
  message: String,
  options: MessageOptions,
  vararg items: String,
): Thenable<String?>

/**
 * Show an error message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun <T : MessageItem> showErrorMessage(
  message: String,
  vararg items: T,
): Thenable<T?>

/**
 * Show an error message.
 *
 * @see [vscode.window.showInformationMessage]
 *
 * @param message The message to show.
 * @param options Configures the behaviour of the message.
 * @param items A set of items that will be rendered as actions in the message.
 * @return A thenable that resolves to the selected item or `undefined` when being dismissed.
 */
external fun <T : MessageItem> showErrorMessage(
  message: String,
  options: MessageOptions,
  vararg items: T,
): Thenable<T?>
