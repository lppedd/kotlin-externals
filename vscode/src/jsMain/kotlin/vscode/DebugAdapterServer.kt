@file:JsModule("vscode")

package vscode

/**
 * Represents a debug adapter running as a socket based server.
 */
external class DebugAdapterServer {
  /**
   * Create a description for a debug adapter running as a socket based server.
   */
  constructor(port: Int, host: String = definedExternally)

  /**
   * The port.
   */
  val port: Int

  /**
   * The host.
   */
  val host: String?
}
