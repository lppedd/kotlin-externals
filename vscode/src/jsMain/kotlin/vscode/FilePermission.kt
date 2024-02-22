@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * Permissions of a file.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FilePermission {
  companion object {
    /**
     * The file is readonly.
     *
     * *Note:* All `FileStat` from a `FileSystemProvider` that is registered with
     * the option `isReadonly: true` will be implicitly handled as if `FilePermission.Readonly`
     * is set. As a consequence, it is not possible to have a readonly file system provider
     * registered where some `FileStat` are not readonly.
     */
    @JsIntValue(1)
    val Readonly: FilePermission
  }
}
