package vscode

/**
 * A Debug Adapter Tracker is a means to track the communication between the editor and a Debug Adapter.
 */

external interface DebugAdapterTracker {
  /**
   * A session with the debug adapter is about to be started.
   */
  fun onWillStartSession(): Unit

  /**
   * The debug adapter is about to receive a Debug Adapter Protocol message from the editor.
   */
  fun onWillReceiveMessage(message: Any?): Unit

  /**
   * The debug adapter has sent a Debug Adapter Protocol message to the editor.
   */
  fun onDidSendMessage(message: Any?): Unit

  /**
   * The debug adapter session is about to be stopped.
   */
  fun onWillStopSession(): Unit

  /**
   * An error with the debug adapter has occurred.
   */
  fun onError(error: Error): Unit

  /**
   * The debug adapter has exited with the given exit code or signal.
   */
  fun onExit(
    code: Double?,
    signal: String?,
  ): Unit
}
