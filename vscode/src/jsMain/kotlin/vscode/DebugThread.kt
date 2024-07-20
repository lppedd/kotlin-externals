@file:JsModule("vscode")

package vscode

/**
 * Represents a thread in a debug session.
 */
external class DebugThread {
  /**
   * Debug session for thread.
   */
  val session: DebugSession

  /**
   * ID of the associated thread in the debug protocol.
   */
  val threadId: Int
}
