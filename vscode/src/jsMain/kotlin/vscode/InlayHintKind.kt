@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Inlay hint kinds.
 *
 * The kind of an inline hint defines its appearance, e.g the corresponding foreground and background colors are being
 * used.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InlayHintKind {
  companion object {
    /**
     * An inlay hint that for a type annotation.
     */
    @JsIntValue(1)
    val Type: InlayHintKind

    /**
     * An inlay hint that is for a parameter.
     */
    @JsIntValue(2)
    val Parameter: InlayHintKind
  }
}
