@file:Suppress("WRONG_EXTERNAL_DECLARATION")

package vscode

/**
 * Represents a type which can release resources, such
 * as event listening or a timer.
 */
external fun interface IDisposable {
  /**
   * Dispose this object.
   */
  fun dispose(): Any?
}
