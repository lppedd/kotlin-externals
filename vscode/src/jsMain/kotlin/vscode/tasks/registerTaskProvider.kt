@file:JsModule("vscode")

package vscode.tasks

import vscode.Disposable
import vscode.Task
import vscode.TaskProvider

/**
 * Register a task provider.
 *
 * @param type The task kind type this provider is registered for.
 * @param provider A task provider.
 * @return A [Disposable] that unregisters this provider when being disposed.
 */
external fun registerTaskProvider(
  type: String,
  provider: TaskProvider<Task>,
): Disposable
