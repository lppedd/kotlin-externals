@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.edit

/**
 * Type indicates which file system is being used for storage on mainframe [ILocalFile]
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface EditFileType {
  companion object {
    @seskar.js.JsValue("uss")
    val uss: EditFileType

    @seskar.js.JsValue("ds")
    val ds: EditFileType
  }
}
