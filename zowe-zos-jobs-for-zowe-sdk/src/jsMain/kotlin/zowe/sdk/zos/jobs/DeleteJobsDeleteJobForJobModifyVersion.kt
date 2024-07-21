package zowe.sdk.zos.jobs

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DeleteJobsDeleteJobForJobModifyVersion {
  companion object {
    @seskar.js.JsValue("1.0")
    val OneZero: DeleteJobsDeleteJobForJobModifyVersion

    @seskar.js.JsValue("2.0")
    val TwoZero: DeleteJobsDeleteJobForJobModifyVersion
  }
}
