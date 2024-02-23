@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import vscode.IDisposable
import vscode.StatusBarItem
import vscode.Thenable

/**
 * Set a message to the status bar. This is a short hand for the more powerful
 * status bar [vscode.window.createStatusBarItem].
 *
 * @param text The message to show, supports icon substitution as in status bar [StatusBarItem.text].
 * @param hideAfterTimeout Timeout in milliseconds after which the message will be disposed.
 * @return A disposable which hides the status bar message.
 */
external fun setStatusBarMessage(
  text: String,
  hideAfterTimeout: Int,
): IDisposable

/**
 * Set a message to the status bar. This is a short hand for the more powerful
 * status bar [vscode.window.createStatusBarItem].
 *
 * @param text The message to show, supports icon substitution as in status bar [StatusBarItem.text].
 * @param hideWhenDone Thenable on which completion (resolve or reject) the message will be disposed.
 * @return A disposable which hides the status bar message.
 */
external fun setStatusBarMessage(
  text: String,
  hideWhenDone: Thenable<Any?>,
): IDisposable

/**
 * Set a message to the status bar. This is a short hand for the more powerful
 * status bar [vscode.window.createStatusBarItem].
 *
 * *Note* that status bar messages stack and that they must be disposed when no
 * longer used.
 *
 * @param text The message to show, supports icon substitution as in status bar [StatusBarItem.text].
 * @return A disposable which hides the status bar message.
 */
external fun setStatusBarMessage(text: String): IDisposable
