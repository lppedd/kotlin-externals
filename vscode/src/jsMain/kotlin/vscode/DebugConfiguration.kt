package vscode

/**
 * Configuration for a debug session.
 */

external interface DebugConfiguration {
  /**
   * The type of the debug session.
   */
  var type: String

  /**
   * The name of the debug session.
   */
  var name: String

  /**
   * The request type of the debug session.
   */
  var request: String

  /**
   * Additional debug type specific properties.
   */

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
