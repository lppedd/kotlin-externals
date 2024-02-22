@file:JsModule("vscode")

package vscode

/**
 * Inlay hint kinds.
 *
 * The kind of an inline hint defines its appearance, e.g the corresponding foreground and background colors are being
 * used.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InlayHintKind {
  companion object {
    /**
     * An inlay hint that for a type annotation.
     */
    val Type: InlayHintKind

    /**
     * An inlay hint that is for a parameter.
     */
    val Parameter: InlayHintKind
  }
}
