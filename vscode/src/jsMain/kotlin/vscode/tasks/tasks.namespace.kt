@file:JsModule("vscode")

package vscode.tasks

import js.array.ReadonlyArray
import vscode.*

/**
 * The currently active task executions or an empty array.
 */
external val taskExecutions: ReadonlyArray<TaskExecution>

/**
 * Fires when a task starts.
 */
external val onDidStartTask: Event<TaskStartEvent>

/**
 * Fires when a task ends.
 */
external val onDidEndTask: Event<TaskEndEvent>

/**
 * Fires when the underlying process has been started.
 * This event will not fire for tasks that don't
 * execute an underlying process.
 */
external val onDidStartTaskProcess: Event<TaskProcessStartEvent>

/**
 * Fires when the underlying process has ended.
 * This event will not fire for tasks that don't
 * execute an underlying process.
 */
external val onDidEndTaskProcess: Event<TaskProcessEndEvent>
