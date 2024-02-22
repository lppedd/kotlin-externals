@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.report.env

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * This enum represents the runtime environment items of interest. These are more than just
 * environment variables. We will report on these items (and report on any detected problems) in the
 * order that the items are listed below.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ItemId {
  companion object {
    @JsIntValue(0)
    val ZOWE_VER: ItemId

    @JsIntValue(1)
    val NODEJS_VER: ItemId

    @JsIntValue(2)
    val NVM_VER: ItemId

    @JsIntValue(3)
    val PLATFORM: ItemId

    @JsIntValue(4)
    val ARCHITECTURE: ItemId

    @JsIntValue(5)
    val OS_PATH: ItemId

    @JsIntValue(6)
    val ZOWE_CLI_HOME: ItemId

    @JsIntValue(7)
    val ZOWE_APP_LOG_LEVEL: ItemId

    @JsIntValue(8)
    val ZOWE_IMPERATIVE_LOG_LEVEL: ItemId

    @JsIntValue(9)
    val OTHER_ZOWE_VARS: ItemId

    @JsIntValue(10)
    val NPM_VER: ItemId

    @JsIntValue(11)
    val ZOWE_CONFIG_TYPE: ItemId

    @JsIntValue(12)
    val ZOWE_PLUGINS: ItemId
  }
}
