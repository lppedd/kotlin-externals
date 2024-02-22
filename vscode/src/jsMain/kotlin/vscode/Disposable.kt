@file:JsModule("vscode")

package vscode

/**
 * Represents a type which can release resources, such
 * as event listening or a timer.
 */
external interface Disposable {
  /**
   * Dispose this object.
   */
  fun dispose(): Any?
}
