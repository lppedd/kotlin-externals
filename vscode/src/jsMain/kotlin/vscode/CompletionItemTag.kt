@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Completion item tags are extra annotations that tweak the rendering of a completion
 * item.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CompletionItemTag {
  companion object {
    /**
     * Render a completion as obsolete, usually using a strike-out.
     */
    @JsIntValue(1)
    val Deprecated: CompletionItemTag
  }
}
