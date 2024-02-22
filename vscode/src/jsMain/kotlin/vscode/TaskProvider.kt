package vscode

/**
 * A task provider allows to add tasks to the task service.
 * A task provider is registered via [vscode.tasks.registerTaskProvider].
 */
external interface TaskProvider<
  @Suppress("FINAL_UPPER_BOUND")
  T : Task, // default is Task
> {
  /**
   * Provides tasks.
   * @param token A cancellation token.
   * @return an array of tasks
   */
  fun provideTasks(token: CancellationToken): ProviderResult<Array<T>>

  /**
   * Resolves a task that has no [Task.execution] set. Tasks are
   * often created from information found in the `tasks.json`-file. Such tasks miss
   * the information on how to execute them and a task provider must fill in
   * the missing information in the `resolveTask`-method. This method will not be
   * called for tasks returned from the above `provideTasks` method since those
   * tasks are always fully resolved. A valid default implementation for the
   * `resolveTask` method is to return `undefined`.
   *
   * Note that when filling in the properties of `task`, you _must_ be sure to
   * use the exact same `TaskDefinition` and not create a new one. Other properties
   * may be changed.
   *
   * @param task The task to resolve.
   * @param token A cancellation token.
   * @return The resolved task
   */
  fun resolveTask(
    task: T,
    token: CancellationToken,
  ): ProviderResult<T>
}
