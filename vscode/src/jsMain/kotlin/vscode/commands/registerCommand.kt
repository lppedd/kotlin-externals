@file:JsModule("vscode")
@file:JsQualifier("commands")

package vscode.commands

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
 * @param thisArg The `this` context used when invoking the handler function.
 * @return Disposable which unregisters this command on disposal.
 */
external fun registerCommand(
  command: String,
  callback: (args: Array<Any?>) -> Any?, // (...args: any[]) => any
  thisArg: Any? = definedExternally,
): IDisposable
