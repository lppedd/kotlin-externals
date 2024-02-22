@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Symbol tags are extra annotations that tweak the rendering of a symbol.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SymbolTag {
  companion object {
    /**
     * Render a symbol as obsolete, usually using a strike-out.
     */
    @JsIntValue(1)
    val Deprecated: SymbolTag
  }
}
