@file:JsModule("vscode")

package vscode

/**
 * Represents a debug adapter running as a Named Pipe (on Windows)/UNIX Domain Socket (on non-Windows) based server.
 */
external class DebugAdapterNamedPipeServer {
  /**
   * Create a description for a debug adapter running as a Named Pipe (on Windows)/UNIX Domain Socket (on non-Windows) based server.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(path: String)

  /**
   * The path to the NamedPipe/UNIX Domain Socket.
   */
  val path: String
}
