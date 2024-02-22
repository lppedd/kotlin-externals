@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.doc.types

/**
 * z/OSMF options for recall of migrated data sets. See the z/OSMF REST API publication for complete details.
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ZosmfMigratedRecallOptions {
  companion object {
    @seskar.js.JsValue("wait")
    val wait: ZosmfMigratedRecallOptions

    @seskar.js.JsValue("nowait")
    val nowait: ZosmfMigratedRecallOptions

    @seskar.js.JsValue("error")
    val error: ZosmfMigratedRecallOptions
  }
}
