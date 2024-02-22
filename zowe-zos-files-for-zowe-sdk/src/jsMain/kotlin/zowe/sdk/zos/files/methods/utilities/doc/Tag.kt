@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.utilities.doc

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Tag {
  companion object {
    @JsValue("text")
    val TEXT: Tag

    @JsValue("binary")
    val BINARY: Tag

    @JsValue("mixed")
    val MIXED: Tag
  }
}
