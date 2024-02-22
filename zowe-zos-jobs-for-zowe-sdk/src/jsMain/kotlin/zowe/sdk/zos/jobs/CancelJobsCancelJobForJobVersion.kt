@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CancelJobsCancelJobForJobVersion {
  companion object {
    @seskar.js.JsValue("1.0")
    val OneZero: CancelJobsCancelJobForJobVersion

    @seskar.js.JsValue("2.0")
    val TwoZero: CancelJobsCancelJobForJobVersion
  }
}
