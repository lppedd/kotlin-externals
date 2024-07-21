package zowe.sdk.zos.files.methods.mount.doc

/**
 * Type for the mode option of the mount file-system API.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IMountFsMode {
  companion object {
    @seskar.js.JsValue("rdonly")
    val rdonly: IMountFsMode

    @seskar.js.JsValue("rdwr")
    val rdwr: IMountFsMode
  }
}
