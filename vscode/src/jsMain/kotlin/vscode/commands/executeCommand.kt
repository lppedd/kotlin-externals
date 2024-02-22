@file:JsModule("vscode")

package vscode.commands

import vscode.*

/**
 * Executes the command denoted by the given command identifier.
 *
 * * *Note 1:* When executing an editor command not all types are allowed to
 * be passed as arguments. Allowed are the primitive types `string`, `boolean`,
 * `number`, `undefined`, and `null`, as well as [Position], [Range], [Uri] and [Location].
 * * *Note 2:* There are no restrictions when executing commands that have been contributed
 * by extensions.
 *
 * @param command Identifier of the command to execute.
 * @param rest Parameters passed to the command function.
 * @return A thenable that resolves to the returned value of the given command. Returns `undefined` when
 *   the command handler function doesn't return anything.
 */
external fun <T /* default is Any? */> executeCommand(command: String, vararg rest: Any?): Thenable<T>
