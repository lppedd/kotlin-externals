@file:JsModule("vscode")

package vscode

/**
 * A cancellation source creates and controls a [CancellationToken].
 */
external class CancellationTokenSource {
  /**
   * The cancellation token of this source.
   */
  var token: CancellationToken

  /**
   * Signal cancellation on the token.
   */
  fun cancel()

  /**
   * Dispose object and free resources.
   */
  fun dispose()
}
