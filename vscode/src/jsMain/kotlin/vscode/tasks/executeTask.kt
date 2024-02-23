@file:JsModule("vscode")
@file:JsQualifier("tasks")

package vscode.tasks

import js.errors.JsError
import vscode.Task
import vscode.TaskExecution
import vscode.Thenable

/**
 * Executes a task that is managed by the editor. The returned
 * task execution can be used to terminate the task.
 *
 * @throws [JsError] When running a ShellExecution or a ProcessExecution
 * task in an environment where a new process cannot be started.
 * In such an environment, only CustomExecution tasks can be run.
 *
 * @param task the task to execute
 * @return A thenable that resolves to a task execution.
 */
external fun executeTask(task: Task): Thenable<TaskExecution>
