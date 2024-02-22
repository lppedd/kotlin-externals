@file:JsModule("vscode")

package vscode

/**
 * Enumeration of file change types.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FileChangeType {
  companion object {
    /**
     * The contents or metadata of a file have changed.
     */
    val Changed: FileChangeType

    /**
     * A file has been created.
     */
    val Created: FileChangeType

    /**
     * A file has been deleted.
     */
    val Deleted: FileChangeType
  }
}
