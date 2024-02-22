@file:JsModule("vscode")

package vscode.window

import vscode.Progress
import vscode.Thenable

/**
 * Show progress in the Source Control viewlet while running the given callback and while
 * its returned promise isn't resolve or rejected.
 *
 * @param task A callback returning a promise. Progress increments can be reported with
 *   the provided [Progress]-object.
 * @return The thenable the task did return.
 */
@Deprecated("Use withProgress instead", ReplaceWith("withProgress"))
external fun <R> withScmProgress(task: (progress: Progress<Double>) -> Thenable<R>): Thenable<R>
