package zowe.sdk.zos.jobs.types

/**
 * The possible job status strings (as specified by the z/OSMF documentation). Used in the Jobs APIs for monitoring
 * jobstatus, etc.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface JobStatus {
  companion object {
    @seskar.js.JsValue("ACTIVE")
    val ACTIVE: JobStatus

    @seskar.js.JsValue("OUTPUT")
    val OUTPUT: JobStatus

    @seskar.js.JsValue("INPUT")
    val INPUT: JobStatus
  }
}
