@file:JsModule("vscode")

package vscode

/**
 * Predefined buttons for [QuickPick} and {@link InputBox].
 */
external class QuickInputButtons {
  companion object {
    /**
     * A back button for [QuickPick} and {@link InputBox].
     *
     * When a navigation 'back' button is needed this one should be used for consistency.
     * It comes with a predefined icon, tooltip and location.
     */
    val Back: QuickInputButton
  }
}
