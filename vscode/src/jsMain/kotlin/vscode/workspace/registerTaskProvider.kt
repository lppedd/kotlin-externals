@file:JsModule("vscode")

package vscode.workspace

import vscode.IDisposable
import vscode.Task
import vscode.TaskProvider

/**
 * Register a task provider.
 *
 * @param type The task kind type this provider is registered for.
 * @param provider A task provider.
 * @return A [IDisposable] that unregisters this provider when being disposed.
 */
@Deprecated("Use the corresponding function on the tasks namespace instead")
external fun registerTaskProvider(
  type: String,
  provider: TaskProvider<Task>,
): IDisposable
