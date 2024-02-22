@file:JsModule("vscode")

package vscode

import js.errors.JsError

/**
 * An error type that should be used to signal cancellation of an operation.
 *
 * This type can be used in response to a [CancellationToken]
 * being cancelled or when an operation is being cancelled by the
 * executor of that operation.
 */
external class CancellationError : JsError {
  /**
   * Creates a new cancellation error.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor()
}
