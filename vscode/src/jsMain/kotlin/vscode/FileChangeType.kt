@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Enumeration of file change types.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FileChangeType {
  companion object {
    /**
     * The contents or metadata of a file have changed.
     */
    @JsIntValue(1)
    val Changed: FileChangeType

    /**
     * A file has been created.
     */
    @JsIntValue(2)
    val Created: FileChangeType

    /**
     * A file has been deleted.
     */
    @JsIntValue(3)
    val Deleted: FileChangeType
  }
}
