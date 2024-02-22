package vscode

/**
 * A custom Debug Adapter Protocol event received from a [DebugSession].
 */
external interface DebugSessionCustomEvent {
  /**
   * The [DebugSession] for which the custom event was received.
   */
  val session: DebugSession

  /**
   * Type of event.
   */
  val event: String

  /**
   * Event specific information.
   */
  val body: Any?
}
