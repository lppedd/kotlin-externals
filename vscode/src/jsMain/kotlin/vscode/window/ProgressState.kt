package vscode.window

external interface ProgressState {
  /**
   * A progress message that represents a chunk of work
   */
  var message: String?

  /**
   * An increment for discrete progress. Increments will be summed up until 100% is reached
   */
  var increment: Double?
}
