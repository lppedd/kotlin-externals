package zowe.imperative.settings

import seskar.js.JsValue
import zowe.imperative.settings.doc.ISettingsFile

/**
 * `keyof` [ISettingsFile]
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SettingOption {
  companion object {
    @JsValue("overrides")
    val overrides: SettingOption
  }
}
