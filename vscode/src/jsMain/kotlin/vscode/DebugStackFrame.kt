@file:JsModule("vscode")

package vscode

/**
 * Represents a stack frame in a debug session.
 */
external class DebugStackFrame {
  /**
   * Debug session for thread.
   */
  val session: DebugSession

  /**
   * ID of the associated thread in the debug protocol.
   */
  val threadId: Int

  /**
   * ID of the stack frame in the debug protocol.
   */
  val frameId: Int
}
