package vscode

/**
 * Defines a generalized way of reporting progress updates.
 */
external interface Progress<T> {
  /**
   * Report a progress update.
   * @param value A progress item, like a message and/or an
   * report on how much work finished
   */
  fun report(value: T)
}
