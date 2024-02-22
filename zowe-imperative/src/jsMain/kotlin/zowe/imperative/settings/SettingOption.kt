@file:JsModule("@zowe/imperative")

package zowe.imperative.settings

import seskar.js.JsValue
import seskar.js.JsVirtual
import zowe.imperative.settings.doc.ISettingsFile

/**
 * `keyof` [ISettingsFile]
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SettingOption {
  companion object {
    @JsValue("overrides")
    val overrides: SettingOption
  }
}
