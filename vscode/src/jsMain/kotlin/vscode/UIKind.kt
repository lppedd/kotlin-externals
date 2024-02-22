@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Possible kinds of UI that can use extensions.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface UIKind {
  companion object {
    /**
     * Extensions are accessed from a desktop application.
     */
    @JsIntValue(1)
    val Desktop: UIKind

    /**
     * Extensions are accessed from a web browser.
     */
    @JsIntValue(2)
    val Web: UIKind
  }
}
