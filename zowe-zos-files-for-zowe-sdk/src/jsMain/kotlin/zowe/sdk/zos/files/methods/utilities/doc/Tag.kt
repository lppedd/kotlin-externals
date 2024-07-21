package zowe.sdk.zos.files.methods.utilities.doc

import seskar.js.JsValue

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
