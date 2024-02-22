@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import seskar.js.JsValue
import seskar.js.JsVirtual

/**
 * The types of persistence schemas which are available in settings.json
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface PersistenceSchemaEnum {
  companion object {
    @JsValue("zowe.ds.history")
    val Dataset: PersistenceSchemaEnum

    @JsValue("zowe.uss.history")
    val USS: PersistenceSchemaEnum

    @JsValue("zowe.jobs.history")
    val Job: PersistenceSchemaEnum
  }
}
