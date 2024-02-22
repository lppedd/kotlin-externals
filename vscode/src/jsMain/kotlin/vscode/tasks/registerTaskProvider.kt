@file:JsModule("vscode")

package vscode.tasks

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
external fun registerTaskProvider(
  type: String,
  provider: TaskProvider<Task>,
): IDisposable
