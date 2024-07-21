package vscode

import seskar.js.JsIntValue

/**
 * Completion item tags are extra annotations that tweak the rendering of a completion
 * item.
 */
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
