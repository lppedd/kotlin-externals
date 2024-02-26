package com.github.lppedd.example.shared

import vscode.ExtensionContext
import vscode.IDisposable

/**
 * Registers a command that can be invoked via a keyboard shortcut,
 * a menu item, an action, or directly.
 *
 * Registering a command with an existing command identifier twice
 * will cause an error.
 *
 * @param command A unique identifier for the command.
 * @param callback A command handler function.
 */
fun ExtensionContext.registerCommand(command: String, callback: (args: Array<Any?>) -> Any?) {
  val disposable = vscode.commands.registerCommand(command, callback)
  subscriptions.add(disposable)
}

fun ExtensionContext.registerDisposable(disposable: IDisposable) {
  subscriptions.add(disposable)
}
