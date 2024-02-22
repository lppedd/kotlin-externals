@file:JsModule("vscode")

package vscode

/**
 * Enumeration of file types. The types `File` and `Directory` can also be
 * a symbolic links, in that case use `FileType.File | FileType.SymbolicLink` and
 * `FileType.Directory | FileType.SymbolicLink`.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FileType {
  companion object {
    /**
     * The file type is unknown.
     */
    val Unknown: FileType

    /**
     * A regular file.
     */
    val File: FileType

    /**
     * A directory.
     */
    val Directory: FileType

    /**
     * A symbolic link to a file.
     */
    val SymbolicLink: FileType
  }
}
