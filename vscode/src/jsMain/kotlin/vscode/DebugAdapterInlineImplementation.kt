@file:JsModule("vscode")

package vscode

/**
 * A debug adapter descriptor for an inline implementation.
 */
external class DebugAdapterInlineImplementation {
  /**
   * Create a descriptor for an inline implementation of a debug adapter.
   */
  constructor(implementation: DebugAdapter)
}
