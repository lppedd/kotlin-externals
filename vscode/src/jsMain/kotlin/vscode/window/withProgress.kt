@file:JsModule("vscode")

package vscode.window

import vscode.*

/**
 * Show progress in the editor. Progress is shown while running the given callback
 * and while the promise it returned isn't resolved nor rejected. The location at which
 * progress should show (and other details) is defined via the passed [ProgressOptionsLocation].
 *
 * @param options A [ProgressOptionsLocation]-object describing the options to use for showing progress, like its location
 * @param task A callback returning a promise. Progress state can be reported with
 *   the provided [Progress]-object.
 *
 *   To report discrete progress, use `increment` to indicate how much work has been completed. Each call with
 *   a `increment` value will be summed up and reflected as overall progress until 100% is reached (a value of
 *   e.g. `10` accounts for `10%` of work done).
 *   Note that currently only `ProgressLocation.Notification` is capable of showing discrete progress.
 *
 *   To monitor if the operation has been cancelled by the user, use the provided [CancellationToken].
 *   Note that currently only `ProgressLocation.Notification` is supporting to show a cancel button to cancel the
 *   long running operation.
 *
 * @return The thenable the task-callback returned.
 */
external fun <R> withProgress(
  options: ProgressOptionsLocation,
  task: (progress: Progress<ProgressState>, token: CancellationToken) -> Thenable<R>,
): Thenable<R>

/**
 * Show progress in the editor. Progress is shown while running the given callback
 * and while the promise it returned isn't resolved nor rejected. The location at which
 * progress should show (and other details) is defined via the passed [ProgressOptions].
 *
 * @param options A [ProgressOptions]-object describing the options to use for showing progress, like its location
 * @param task A callback returning a promise. Progress state can be reported with
 *   the provided [Progress]-object.
 *
 *   To report discrete progress, use `increment` to indicate how much work has been completed. Each call with
 *   a `increment` value will be summed up and reflected as overall progress until 100% is reached (a value of
 *   e.g. `10` accounts for `10%` of work done).
 *   Note that currently only `ProgressLocation.Notification` is capable of showing discrete progress.
 *
 *   To monitor if the operation has been cancelled by the user, use the provided [CancellationToken].
 *   Note that currently only `ProgressLocation.Notification` is supporting to show a cancel button to cancel the
 *   long running operation.
 *
 * @return The thenable the task-callback returned.
 */
external fun <R> withProgress(
  options: ProgressOptions,
  task: (progress: Progress<ProgressState>, token: CancellationToken) -> Thenable<R>,
): Thenable<R>
