@file:JsModule("vscode")
@file:JsQualifier("tasks")

package vscode.tasks

import vscode.Task
import vscode.TaskFilter
import vscode.Thenable

/**
 * Fetches all tasks available in the systems. This includes tasks
 * from `tasks.json` files as well as tasks from task providers
 * contributed through extensions.
 *
 * @param filter Optional filter to select tasks of a certain type or version.
 * @return A thenable that resolves to an array of tasks.
 */
external fun fetchTasks(filter: TaskFilter = definedExternally): Thenable<Array<Task>>
