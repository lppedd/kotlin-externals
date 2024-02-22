@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Enumeration of file types. The types `File` and `Directory` can also be
 * a symbolic links, in that case use `FileType.File | FileType.SymbolicLink` and
 * `FileType.Directory | FileType.SymbolicLink`.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FileType {
  companion object {
    /**
     * The file type is unknown.
     */
    @JsIntValue(0)
    val Unknown: FileType

    /**
     * A regular file.
     */
    @JsIntValue(1)
    val File: FileType

    /**
     * A directory.
     */
    @JsIntValue(2)
    val Directory: FileType

    /**
     * A symbolic link to a file.
     */
    @JsIntValue(64)
    val SymbolicLink: FileType
  }
}
