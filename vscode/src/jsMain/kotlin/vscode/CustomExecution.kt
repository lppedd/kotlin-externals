@file:JsModule("vscode")

package vscode

/**
 * Class used to execute an extension callback as a task.
 */

external class CustomExecution {
  /**
   * Constructs a CustomExecution task object. The callback will be executed when the task is run, at which point the
   * extension should return the Pseudoterminal it will "run in". The task should wait to do further execution until
   * [Pseudoterminal.open] is called. Task cancellation should be handled using
   * [Pseudoterminal.close]. When the task is complete fire
   * [Pseudoterminal.onDidClose].
   * @param callback The callback that will be called when the task is started by a user. Any ${} style variables that
   * were in the task definition will be resolved and passed into the callback as `resolvedDefinition`.
   */
  constructor(callback: (resolvedDefinition: TaskDefinition) -> Thenable<Pseudoterminal>)
}
